package com.github.prgrms.socialserver.repository;

import com.github.prgrms.socialserver.domain.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();
}
