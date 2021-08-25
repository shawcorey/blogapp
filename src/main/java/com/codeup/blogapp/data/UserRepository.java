package com.codeup.blogapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{


    User findFirstByUsername(String username);

    User findFirstByEmail(String email);
}
