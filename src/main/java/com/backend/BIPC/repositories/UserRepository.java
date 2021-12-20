package com.backend.BIPC.repositories;

import com.backend.BIPC.entities.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String email);

}
