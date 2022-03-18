package com.fedpet.controllers;

import com.fedpet.dtos.EventDetailDto;
import com.fedpet.dtos.EventInputDto;
import com.fedpet.dtos.EventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
@PostMapping
    public ResponseEntity<EventDto> create(@RequestBody EventInputDto inputDto){
    return null;
}
    @GetMapping("/getEvents")
    public ResponseEntity<List<EventDto>> get(){
        return null;
    }
    @GetMapping("/bygroupid/{groupId}")
    public ResponseEntity<List<EventDto>> getEventBYGroupId(@PathVariable int groupId){
        return null;
    }
    @GetMapping("/my")
    public ResponseEntity<List<EventDto>> getMyEvents(){
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventDetailDto> get(@PathVariable int id){
        return null;
    }
}
