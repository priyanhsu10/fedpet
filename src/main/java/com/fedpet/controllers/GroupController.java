package com.fedpet.controllers;

import com.fedpet.dtos.AddMemberGroupInputDto;
import com.fedpet.dtos.GroupDetailsDto;
import com.fedpet.dtos.GroupInputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @PostMapping
    public ResponseEntity<GroupInputDto> create(@RequestBody GroupInputDto groupDto){

        return  null;
    }
    @PostMapping("/addMember")
    public ResponseEntity<Void> addMember(@RequestBody AddMemberGroupInputDto groupDto){

        return  null;
    }
    @GetMapping("/details/{id}")
    private  ResponseEntity<List<GroupDetailsDto>> getDetails(@PathVariable int id){
        return null;
    }
}
