package com.tms.repository;

import com.tms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

    @Query(value = "select * from users where role = 'ROLE_USER'", nativeQuery = true)
    List<User> findOnlyUsers();
}