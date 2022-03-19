package com.fedpet.services;

import com.fedpet.Interfaces.IGroupService;
import com.fedpet.utils.IGroupValidator;
import com.fedpet.Interfaces.IUserDetails;
import com.fedpet.dtos.AddMemberGroupInputDto;
import com.fedpet.dtos.GroupDetailsDto;
import com.fedpet.dtos.GroupInputDto;
import com.fedpet.dtos.GroupUserDto;
import com.fedpet.entities.*;
import com.fedpet.expeptions.PetFedException;
import com.fedpet.repositories.GroupRepository;
import com.fedpet.repositories.UserGroupRepository;
import com.fedpet.security.authentication.UserInfo;
import com.fedpet.utils.IMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService implements IGroupService {
    private final GroupRepository groupRepository;
    private final IUserDetails iUserDetails;
    private IGroupValidator groupValidator;
    private EntityManager entityManager;
    private UserGroupRepository userGroupRepository;
    private IMapper mapper;

    public GroupService(GroupRepository groupRepository, IUserDetails iUserDetails, IGroupValidator groupValidator,
                        EntityManager entityManager,
                        UserGroupRepository userGroupRepository,
                        IMapper mapper) {
        this.groupRepository = groupRepository;
        this.iUserDetails = iUserDetails;
        this.groupValidator = groupValidator;
        this.entityManager = entityManager;
        this.userGroupRepository = userGroupRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public GroupDetailsDto create(GroupInputDto inputDto) {

        groupValidator.validateCreate(inputDto);
        UserInfo userinfo = iUserDetails.get();
        Group group = createGroup(inputDto, userinfo);
        //return part
        return getGroupDetailsDto(userinfo, group);
    }

    private GroupDetailsDto getGroupDetailsDto(UserInfo userinfo, Group group) {
        var groupDto = new GroupDetailsDto();
        groupDto.setGroupName(group.getGroupName());
        groupDto.setActive(group.isActive());
        groupDto.setId(group.getId());
        groupDto.setGroupUserType(UserType.FoodDonner);
        groupDto.setAddedAt(group.getAddedAt());
        GroupUserDto userDto = new GroupUserDto();
        userDto.setPrimaryUserType(UserType.FoodDonner);
        userDto.setId(userinfo.getId());
        userDto.setFirstname(userinfo.getFirstName());
        userDto.setFirstname(userinfo.getLastName());
        groupDto.getMembers().add(userDto);
        return groupDto;
    }

    private Group createGroup(GroupInputDto inputDto, UserInfo userinfo) {
        var group = new Group();
        User user = entityManager.getReference(User.class, userinfo.getId());
        group.setOwner(user);
        group.setGroupName(inputDto.getGroupName());
        group.setPrimaryUserType(UserType.FoodDonner);
        var groupLocation = new GroupLocation().build(inputDto);
        group.setGroupLocation(groupLocation);
        group.setActive(true);
        group.setAddedAt(LocalDateTime.now());
        //set rest of the group properties
        var userGroup = new UserGroup();
        userGroup.setGroup(group);
        userGroup.setUser(user);
        userGroup.setActive(true);
        userGroup.setUserType(UserType.FoodDonner);
        userGroup.setAddedAt(LocalDateTime.now());
        group.addMember(userGroup);

        group = groupRepository.save(group);
        return group;
    }

    @Override
    @Transactional
    public GroupUserDto addMember(AddMemberGroupInputDto groupDto) {
        Group group= entityManager.getReference(Group.class,groupDto.getGroupId());
        User user= entityManager.getReference(User.class,groupDto.getUserId());
        UserGroup userGroup=new UserGroup();
        userGroup.setGroup(group);
        userGroup.setUser(user);
        userGroup.setUserType(groupDto.getUserType());
        userGroupRepository.save(userGroup);
        return  GroupUserDto.build(userGroup);
    }

    @Override
    public GroupDetailsDto getDetails(int id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new PetFedException("Invalid Group Id:" + id));

        return getGroupDetailsDto(group);

    }

    private GroupDetailsDto getGroupDetailsDto(Group group) {
        GroupDetailsDto dto = new GroupDetailsDto();
        dto.setGroupName(group.getGroupName());
        dto.setId(group.getId());
        dto.setActive(group.isActive());
        var members = group.getMembers().stream().map(x -> {
            GroupUserDto groupUserDto = new GroupUserDto();
            groupUserDto.setFirstname(x.getUser().getFirstname());
            groupUserDto.setPrimaryUserType(x.getUserType());
            groupUserDto.setLastname(x.getUser().getLastname());
            groupUserDto.setId(x.getUser().getId());
            return groupUserDto;
        }).collect(Collectors.toSet());
        dto.setMembers(members);
        var events = group.getEvents().stream().map(mapper::toEventDto).collect(Collectors.toSet());
        dto.setEvents(events);
        return dto;
    }

    @Override
    @Transactional
    public List<GroupDetailsDto> getMyGroups() {
        var id=iUserDetails.get().getId();
        User user = entityManager.getReference(User.class, id);
      return   groupRepository.findAllByOwner(user).stream().map(group-> getGroupDetailsDto(group)).collect(Collectors.toList());
    }
}
