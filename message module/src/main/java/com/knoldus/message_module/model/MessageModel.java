package com.knoldus.message_module.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.NumberFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@SequenceGenerator(name="message_id_seq", initialValue=100)
public class MessageModel {
    @Id
    @Column(name = "message_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="message_id_seq")
    private Long id;

    public MessageModel() {

    }

    public MessageModel(Long id, Long senderId, Long receiverId,
                        String messageBody, Date createdDate,
                        boolean deleteReceiverMessage,
                        boolean deleteSenderMessage) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageBody = messageBody;
        this.createdDate = createdDate;
        this.deleteReceiverMessage = deleteReceiverMessage;
        this.deleteSenderMessage= deleteSenderMessage;
    }
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Long senderId;

    @NotEmpty
    private String messageBody;
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Long receiverId;
    @NotNull
    private boolean deleteSenderMessage;
    @NotNull
    private boolean deleteReceiverMessage;

    public boolean isDeleteSenderMessage() {
        return deleteSenderMessage;
    }

    public void setDeleteSenderMessage(boolean deleteSenderMessage) {
        this.deleteSenderMessage = deleteSenderMessage;
    }

    public boolean isDeleteReceiverMessage() {
        return deleteReceiverMessage;
    }

    public void setDeleteReceiverMessage(boolean deleteReceiverMessage) {
        this.deleteReceiverMessage = deleteReceiverMessage;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }



    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdDate;

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
