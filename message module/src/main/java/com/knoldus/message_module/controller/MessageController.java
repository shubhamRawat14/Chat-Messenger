package com.knoldus.message_module.controller;

import com.knoldus.message_module.model.MessageModel;
import com.knoldus.message_module.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //for getting all message which is send by senderId
//    @GetMapping("/getMessage")
//    public List<MessageModel> getMessageBySenderId(@RequestBody MessageModel messageModel)
//    {
//        return messageService.getMessageBySenderId(messageModel);
//    }
    //for getting all message between senderId and receiverId
    @GetMapping("/getSpecificMessage")
    public List<MessageModel> getSpecificMessage(@RequestBody MessageModel messageModel)
    {
        System.out.println(messageModel.getSenderId());
        return (List<MessageModel>) messageService.getSpecificMessage(messageModel);
    }
    @DeleteMapping("/deleteMessageForMe")
    public String deleteMessageForMe(@RequestBody MessageModel messageModel){
        System.out.println("751");
        return messageService.deleteMessageForMe(messageModel);
    }
    @GetMapping("/getMessageById")
    public List<MessageModel> getMessagesById(@RequestBody MessageModel messageModel)
    {
        System.out.println("hi");
        return  messageService.getMessagesById(messageModel);
    }
}
