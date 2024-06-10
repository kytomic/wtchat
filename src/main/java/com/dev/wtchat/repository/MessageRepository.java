package com.dev.wtchat.repository;

import com.dev.wtchat.entity.Message;
import com.dev.wtchat.entity.MessageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    // That's it
    @Override
    Optional<Message> findById(Integer id);

    @Query("SELECT NEW com.dev.wtchat.entity.MessageDetail(m, u1.username)" +
            " FROM Message m" +
            " JOIN User u1 ON u1.id = m.senderId")
    List<MessageDetail> getMessageDetails();

}
