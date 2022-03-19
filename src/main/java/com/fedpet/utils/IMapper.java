package com.fedpet.utils;

import com.fedpet.dtos.CommentDto;
import com.fedpet.dtos.EventDto;
import com.fedpet.dtos.UserDto;
import com.fedpet.dtos.UserRegistrationDto;
import com.fedpet.entities.Comment;
import com.fedpet.entities.Event;
import com.fedpet.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapper {
    User toUser(UserRegistrationDto userRegistrationDto);
    UserDto toUserDto(User user);
    Event toEvent(EventDto eventDto);
    EventDto toEventDto(Event event);
    Comment toComment(CommentDto eventDto);
    CommentDto toCommentDto(Comment event);
}
