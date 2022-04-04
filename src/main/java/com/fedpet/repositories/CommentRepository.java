package com.fedpet.repositories;

import com.fedpet.entities.Comment;
import com.fedpet.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Long> {
    List<Comment> finAllByEvent(Event event);
}
