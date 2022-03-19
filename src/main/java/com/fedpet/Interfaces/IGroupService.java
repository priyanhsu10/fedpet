package com.fedpet.Interfaces;

import com.fedpet.dtos.AddMemberGroupInputDto;
import com.fedpet.dtos.GroupDetailsDto;
import com.fedpet.dtos.GroupInputDto;
import com.fedpet.dtos.GroupUserDto;

import java.util.List;

public interface IGroupService {
    GroupDetailsDto create(GroupInputDto inputDto);
    GroupUserDto addMember(AddMemberGroupInputDto groupDto);
    GroupDetailsDto getDetails( int id);
    List<GroupDetailsDto> getMyGroups();
}
