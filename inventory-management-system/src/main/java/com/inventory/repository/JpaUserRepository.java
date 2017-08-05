package com.inventory.repository;

import org.springframework.stereotype.Repository;

import com.inventory.repository.config.DefaultBaseRepository;
import com.inventory.repository.entity.QUser;
import com.inventory.repository.entity.User;
import com.querydsl.core.types.EntityPath;

@Repository
public class JpaUserRepository extends DefaultBaseRepository<User> implements UserRepository{

	@Override
	public EntityPath<User> getDefaultEntityPath() {
		return QUser.user;
	}
	
	@Override
	public User validateLoginForUserWithUserNameAndPassword(String userName, String password) {
		QUser qUser = QUser.user;
		User user = getJpaQueryFactory().selectFrom(qUser)
							.where(qUser.userName.eq(userName).and(qUser.password.eq(password)))
							.fetchOne();
		return user;
	}

}
