package com.septgroup.accountservice.shared;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository<K, ID> extends JpaRepository<K, ID> {
}
