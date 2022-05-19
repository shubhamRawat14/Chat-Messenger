package com.knoldus.message_module.controller;
import com.knoldus.message_module.model.MessageModel;
import com.knoldus.message_module.model.User;
import com.knoldus.message_module.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @PostMapping("/sendMessage")
    public @ResponseBody String sendData(@Valid @RequestBody MessageModel messageModel)
    {
        return messageService.sendData(messageModel);
    }
    @PostMapping("/getUserIdOfPreviousMessage")
    public @ResponseBody List<Integer> getUserIdOfPreviousMessageController(@RequestBody User user){
        System.out.println((int) user.getId());
        System.out.println();
        return messageService.getUserIdOfPreviousMessageService((int) user.getId());
    }
    //for getting all message which is send by senderId
//    @GetMapping("/getMessage")
//    public List<MessageModel> getMessageBySenderId(@RequestBody MessageModel messageModel)
//    {
//        return messageService.getMessageBySenderId(messageModel);
//    }
    //for getting all message between senderId and receiverId
    @GetMapping("/getSpecificMessage")
    public  @ResponseBody List<MessageModel> getSpecificMessage(@RequestBody MessageModel messageModel)
    {
        return (List<MessageModel>) messageService.getSpecificMessage(messageModel);
    }
    @DeleteMapping("/deleteMessageForMe")
    public  @ResponseBody String deleteMessageForMe(@RequestBody MessageModel messageModel){
        return messageService.deleteMessageForMe(messageModel);
    }
    @GetMapping("/getMessageById")
    public  @ResponseBody List<MessageModel> getMessagesById(@RequestBody MessageModel messageModel) {
        return  messageService.getMessagesById(messageModel);
    }
    @PostMapping("/getMessagesOneToOne")
    public  @ResponseBody List<MessageModel> getMessagesOneToOne(@RequestBody MessageModel messageModel) {
        return  messageService.getMessagesOneToOne(messageModel);
    }
}
