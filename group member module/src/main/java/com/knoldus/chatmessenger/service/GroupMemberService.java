package com.knoldus.chatmessenger.service;

import com.knoldus.chatmessenger.GroupMemberRepository.GroupMemberRepository;
import com.knoldus.chatmessenger.model.GroupMember;
import com.knoldus.chatmessenger.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GroupMemberService {
    @Autowired
    GroupMemberRepository groupMemberRepository;
    @Autowired
    Validation validation;
    public String removeGroupMember(GroupMember receivedGroupMember){
        GroupMember groupMember = groupMemberRepository.fetchGroupMember(receivedGroupMember.getUserId());
        Date date = new Date();
        groupMember.setUpdatedDate(date);
        groupMember.setActive(false);
        groupMemberRepository.save(groupMember);
        return "Member removed Successfully";
    }
    public String addUserInGroup(GroupMember receivedGroupMember){
            if(validation.checkGroupMemberEntry(receivedGroupMember)){
                GroupMember groupMember = new GroupMember();
                groupMember.setGroupId(receivedGroupMember.getGroupId());
                groupMember.setUserId(receivedGroupMember.getUserId());
                groupMember.setActive(true);
                Date date = new Date();
                groupMember.setJoinedOn(date);
                groupMember.setCreatedDate(date);
                groupMember.setUpdatedDate(date);
                groupMemberRepository.save(groupMember);
                return "User Saved";
            }
            return "User id and Group should not be Zero or empty";

    }
}
