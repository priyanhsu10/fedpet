package com.fedpet.utils;

import com.fedpet.dtos.EventInputDto;

public interface IEventValidator {
    void validateCreateEvent(EventInputDto inputDto);
}
