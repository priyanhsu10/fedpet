package com.fedpet.repositories;

import com.fedpet.entities.Event;
import com.fedpet.entities.Group;
import com.fedpet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByGroup(Group group);

    List<Event> findByCreator(User user);
}
