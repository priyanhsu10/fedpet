package com.fedpet.controllers;

import com.fedpet.dtos.CommentDto;
import com.fedpet.dtos.CommentInputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @PostMapping
    public ResponseEntity<CommentDto> create(@RequestBody CommentInputDto input) {
        return null;
    }
    @GetMapping("/eventId/{eventId}")
    public ResponseEntity<List<CommentDto>> create(@PathVariable int eventId) {
        return null;
    }
}
