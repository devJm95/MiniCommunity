package com.MiniCommunity.domain.user.repository;

import com.MiniCommunity.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean findByUserName(String userName);
}
