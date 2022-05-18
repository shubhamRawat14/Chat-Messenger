package com.knoldus.user_module.repository;
import com.knoldus.user_module.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByMobile(long mobile);
    @Query(value = "SELECT * FROM user WHERE MOBILE = ?1 AND PASSWORD =?2  ", nativeQuery = true)
    User fetchUser(long mobile, String password);

    @Query(value = "SELECT * FROM user WHERE MOBILE = ?1 ", nativeQuery = true)
    User findUser(long mobile);

    @Query(value = "SELECT * FROM user WHERE id = ?1 ", nativeQuery = true)
    User findUserById(int id);

    @Query(value = "SELECT * FROM user WHERE mobile = ?1 ", nativeQuery = true)
    User findbyMobile(Long mobile);
}
