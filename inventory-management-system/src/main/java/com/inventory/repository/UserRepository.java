package com.inventory.repository;

import com.inventory.repository.config.BaseRepository;
import com.inventory.repository.entity.User;

public interface UserRepository extends BaseRepository<User>{

	User validateLoginForUserWithUserNameAndPassword(String userName, String password);
 
}
