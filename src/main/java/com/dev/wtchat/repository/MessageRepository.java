package com.dev.wtchat.repository;

import com.dev.wtchat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    // That's it
    @Override
    Optional<Message> findById(Integer id);
}
