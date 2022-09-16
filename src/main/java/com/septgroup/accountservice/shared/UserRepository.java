package com.septgroup.accountservice.shared;

import com.septgroup.accountservice.shared.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface UserRepository extends JpaRepository<User, UUID> {
}
