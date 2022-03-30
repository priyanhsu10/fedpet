package com.fedpet.Interfaces;

import com.fedpet.dtos.EventDetailDto;
import com.fedpet.dtos.EventDto;
import com.fedpet.dtos.EventInputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IEventService {
    // TODO: implement pagination after works completely
     List<EventDto> getAll();
  EventDto getById(long id);
     List<EventDto> getEventBYGroupId(int groupId);
     List<EventDto> getMyEvents();
   EventDto create( EventInputDto inputDto);
}
