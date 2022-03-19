package com.fedpet.repositories;

import com.fedpet.entities.Group;
import com.fedpet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findAllByOwner(User user);
}
