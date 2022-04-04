package com.fedpet.Interfaces;

import com.fedpet.dtos.CommentDto;
import com.fedpet.dtos.CommentInputDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICommentService {
    CommentDto create( CommentInputDto input);
    List<CommentDto> get( int eventId);
}
