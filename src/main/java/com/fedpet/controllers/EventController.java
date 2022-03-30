package com.fedpet.controllers;

import com.fedpet.Interfaces.IEventService;
import com.fedpet.dtos.EventDetailDto;
import com.fedpet.dtos.EventInputDto;
import com.fedpet.dtos.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private IEventService iEventService;

    public EventController(IEventService iEventService) {
        this.iEventService = iEventService;
    }

    @PostMapping
    public ResponseEntity<EventDto> create(@Valid  @RequestBody EventInputDto inputDto){
    return ResponseEntity.ok(iEventService.create(inputDto));
}
    @GetMapping("/getEvents")
    public ResponseEntity<List<EventDto>> get(){

         return ResponseEntity.ok(iEventService.getAll());
    }
    @GetMapping("/bygroupid/{groupId}")
    public ResponseEntity<List<EventDto>> getEventBYGroupId(@PathVariable int groupId){
        return ResponseEntity.ok(iEventService.getEventBYGroupId(groupId));
    }
    @GetMapping("/my")
    public ResponseEntity<List<EventDto>> getMyEvents(){
        return ResponseEntity.ok(iEventService.getMyEvents());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventDto> get(@PathVariable long id){
        return ResponseEntity.ok(iEventService.getById(id));
    }
}
