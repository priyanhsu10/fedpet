package com.fedpet.utils;

import com.fedpet.dtos.GroupInputDto;

public interface IGroupValidator {
    void validateCreate(GroupInputDto inputDto);
}
