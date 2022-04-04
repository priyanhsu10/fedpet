package com.fedpet.services;

import com.fedpet.Interfaces.ICommentService;
import com.fedpet.Interfaces.IUserDetails;
import com.fedpet.dtos.CommentDto;
import com.fedpet.dtos.CommentInputDto;
import com.fedpet.entities.Comment;
import com.fedpet.entities.Event;
import com.fedpet.entities.User;
import com.fedpet.repositories.CommentRepository;
import com.fedpet.utils.IMapper;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CommentService implements ICommentService {
    private CommentRepository commentRepository;
    private EntityManager entityManager;
    private IUserDetails userDetails;
    private IMapper mapper;

    public CommentService(CommentRepository commentRepository,
                          EntityManager entityManager, IUserDetails
                                  userDetails,
                          IMapper mapper) {
        this.commentRepository = commentRepository;
        this.entityManager = entityManager;
        this.userDetails = userDetails;
        this.mapper = mapper;
    }

    @Override
    public CommentDto create(CommentInputDto input) {
        Event event =entityManager.getReference(Event.class,input.getEventId());

        User user =entityManager.getReference(User.class,userDetails.get().getId());
        Comment comment =new Comment();
        comment.setEvent(event);
        comment.setCommentData(input.getCommentData());
        comment.setCommenter(user);
        comment.setCommentAt(LocalDateTime.now());

        comment=  commentRepository.save(comment);
        return mapper.toCommentDto(comment);
    }

    @Override
    public List<CommentDto> get(int eventId) {
        Event event= entityManager.getReference(Event.class,eventId);
        return commentRepository.finAllByEvent(event)
                .stream()
                .map(x->mapper.toCommentDto(x))
                .collect(toList());
    }
}
