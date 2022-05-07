package com.knoldus.chatmessenger.controller;

import com.knoldus.chatmessenger.model.GroupMember;
import com.knoldus.chatmessenger.service.GroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/groupMember")
public class GroupMemberController {
    @Autowired
    private GroupMemberService groupMemberService;
    @DeleteMapping  (path = "/remove/member")
    public  String removeUser ( @RequestBody GroupMember groupMember) {
        return groupMemberService.removeGroupMember(groupMember);
    }
    @PostMapping (path = "/add/member")
    public  String addNewUser (
             @RequestBody GroupMember groupMember) {
        return groupMemberService.addUserInGroup(groupMember);
    }
}


