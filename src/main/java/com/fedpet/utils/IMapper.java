package com.fedpet.utils;

import com.fedpet.dtos.*;
import com.fedpet.entities.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapper {
    User toUser(UserRegistrationDto userRegistrationDto);
    UserDto toUserDto(User user);
    Event toEvent(EventDto eventDto);
    EventDto toEventDto(Event event);
    EventDetailDto toEventDetailDto(Event event);
    Comment toComment(CommentDto eventDto);
    CommentDto toCommentDto(Comment event);
     GroupUserDto tocGroupUserDto(User user);
     GroupInputDto toGroupInputDto(Group group);
    GroupInputDto toGroupInputLocationDto(GroupLocation groupLocation);
}
