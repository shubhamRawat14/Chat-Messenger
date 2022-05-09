package com.knoldus.message_module.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<MessageModel, Long> {
    public List<MessageModel> findAllBySenderIdAndReceiverId(Long senderId, Long receiverId);
    public List<MessageModel> findAllBySenderId(Long senderId);
    @Query(value = "DELETE FROM message_model WHERE message_id=?1",nativeQuery = true)
    void deleteForEveryOne(long id);

    boolean existsByIdAndSenderId(Long id, Long senderId);
    boolean existsByIdAndReceiverId(Long id, Long receiverId);
    @Query(value = "select * from message_model where (sender_id=?1 and delete_sender_message= false) or (receiver_id=?1 and delete_receiver_message= false )",nativeQuery = true)
    List<MessageModel> fetchMessageById(Long userId);
}
