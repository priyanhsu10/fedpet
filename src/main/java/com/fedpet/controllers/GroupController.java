package com.fedpet.controllers;

import com.fedpet.Interfaces.IGroupService;
import com.fedpet.dtos.AddMemberGroupInputDto;
import com.fedpet.dtos.GroupDetailsDto;
import com.fedpet.dtos.GroupInputDto;
import com.fedpet.dtos.GroupUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    private IGroupService iGroupService;

    public GroupController(IGroupService iGroupService) {
        this.iGroupService = iGroupService;
    }

    @PostMapping
    public ResponseEntity<GroupDetailsDto> create(@RequestBody GroupInputDto groupDto){

       return ResponseEntity.ok(iGroupService.create(groupDto));
    }
    @PostMapping("/addMember")
    public ResponseEntity<GroupUserDto> addMember(@RequestBody AddMemberGroupInputDto groupDto){

       return ResponseEntity.ok(iGroupService.addMember(groupDto));
    }
    @GetMapping("/details/{id}")
    private  ResponseEntity<GroupDetailsDto> getDetails(@PathVariable int id){

        return ResponseEntity.ok(iGroupService.getDetails(id));
    }

    @GetMapping("/my")
    private  ResponseEntity<List<GroupDetailsDto>> getMyGroups(){

        return ResponseEntity.ok(iGroupService.getMyGroups());

    }

}
