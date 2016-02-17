package com.example.repository;

import com.example.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hazim on 2/11/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {
	User findByFacebookId(String facebookId);
}
