package com.example.repository;

import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hazim on 2/11/16.
 */
@Service
@Transactional
public class UserRepositoryService {
	@Autowired
	private UserRepository userRepository;

	public void save(User user){
		userRepository.save(user);
	}

	public User findByFacebookId(String facebookId){
		return userRepository.findByFacebookId(facebookId);
	}

	public boolean existsByFacebookId(String facebookId){
		User user = userRepository.findByFacebookId(facebookId);
		return user != null;
	}
}
