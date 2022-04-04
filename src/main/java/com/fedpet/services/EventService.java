package com.fedpet.services;

import com.fedpet.Interfaces.IEventService;
import com.fedpet.Interfaces.IUserDetails;
import com.fedpet.dtos.EventDetailDto;
import com.fedpet.dtos.EventDto;
import com.fedpet.dtos.EventInputDto;
import com.fedpet.entities.Event;
import com.fedpet.entities.EventLocation;
import com.fedpet.entities.Group;
import com.fedpet.entities.User;
import com.fedpet.repositories.EventRepository;
import com.fedpet.repositories.UserRepository;
import com.fedpet.utils.IEventValidator;
import com.fedpet.utils.IGroupValidator;
import com.fedpet.utils.IMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService implements IEventService {
    private final IUserDetails iUserDetails;
    private IEventValidator eventValidator;
    private IMapper mapper;
    private UserRepository userRepository;
    private EntityManager entityManager;
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository, IUserDetails
            iUserDetails, EntityManager entityManager,
                        IEventValidator eventValidator, IMapper mapper) {
        this.eventRepository = eventRepository;
        this.iUserDetails = iUserDetails;
        this.entityManager = entityManager;
        this.eventValidator = eventValidator;
        this.mapper = mapper;
    }

    @Override
    public List<EventDetailDto> getAll() {

        //TODO: implement the paging
        //find all event near current location around 10km
        List<EventDetailDto> allEvents = eventRepository.findAll().stream().map(x -> {
            var eventDto = mapper.toEventDetailDto(x);
            eventDto.setEventTime(eventDto.getEventDate().atStartOfDay().toLocalTime());
            eventDto.setCreatorInfo(mapper.tocGroupUserDto(x.getCreator()));
            eventDto.setGroupInfo(mapper.toGroupInputLocationDto(x.getGroup().getGroupLocation()));

            eventDto.getGroupInfo().setId(x.getGroup().getId());
            eventDto.getGroupInfo().setGroupName(x.getGroup().getGroupName());
            return eventDto;
        }).collect(Collectors.toList());
        return allEvents;
    }

    @Override
    public EventDto getById(long id) {
        var event =eventRepository.getById(id);
            var eventDto = mapper.toEventDto(event);
            eventDto.setEventTime(eventDto.getEventDate().atStartOfDay().toLocalTime());
            return eventDto;
    }

    @Override
    public List<EventDto> getEventBYGroupId(int groupId) {
        Group group = entityManager.getReference(Group.class, groupId);
        var allEvents =eventRepository.findByGroup(group).stream().map(x -> {
            var eventDto = mapper.toEventDto(x);
            eventDto.setEventTime(eventDto.getEventDate().atStartOfDay().toLocalTime());
            return eventDto;
        }).collect(Collectors.toList());
        return allEvents;
    }

    @Override
    public List<EventDto> getMyEvents() {
        User user = entityManager.getReference(User.class, iUserDetails.get().getId());
        var allEvents =eventRepository.findByCreator(user).stream().map(x -> {
            var eventDto = mapper.toEventDto(x);
            eventDto.setEventTime(eventDto.getEventDate().atStartOfDay().toLocalTime());
            eventDto.setGroupId(x.getGroup().getId());
            eventDto.setCreatorId(iUserDetails.get().getId());
            return eventDto;
        }).collect(Collectors.toList());
        return allEvents;
    }

    @Override
    public EventDto create(EventInputDto inputDto) {
        eventValidator.validateCreateEvent(inputDto);
        //upload file to aws
        Event event = new Event();
        event.setEventDate(inputDto.getEventDate().toLocalDate());
        event.setEventTime(inputDto.getEventDate().toLocalTime());
        event.setName(inputDto.getName());
        event.setDescription(inputDto.getDescription());
        EventLocation eventLocation = new EventLocation();
        eventLocation.setCity(inputDto.getCity());
        eventLocation.setArea(inputDto.getArea());
        eventLocation.setState(inputDto.getState());
        eventLocation.setLatitude(inputDto.getLatitude());
        eventLocation.setAddress(inputDto.getAddress());
        eventLocation.setLongitude(inputDto.getLongitude());
        event.setEventLocation(eventLocation);
        Group group = entityManager.getReference(Group.class, inputDto.getGroupId());
        User user = entityManager.getReference(User.class, iUserDetails.get().getId());
        event.setGroup(group);
        event.setCreator(user);

        event = eventRepository.save(event);

        return mapper.toEventDto(event);

    }
}
