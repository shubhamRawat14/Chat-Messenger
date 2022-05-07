package com.knoldus.chatmessenger.GroupMemberRepository;

import com.knoldus.chatmessenger.model.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Integer> {
    @Query(value = "select * from group_member where userid = ?1", nativeQuery = true)
    GroupMember fetchGroupMember(int userId);
    @Query(value = "select * from group_member where userid = ?1 and groupid= ?2", nativeQuery = true)
    boolean ifGroupMember(int userId, int groupId);

}
