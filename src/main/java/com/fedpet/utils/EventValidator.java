package com.fedpet.utils;

import com.fedpet.dtos.EventInputDto;
import org.springframework.stereotype.Component;

@Component
public class EventValidator implements IEventValidator {
    @Override
    public void validateCreateEvent(EventInputDto inputDto) {
     //todo:check for valid group id
    }
}
