package com.dreamph.apps.repository;

import com.dreamph.apps.dto.UserListDto;
import com.dreamph.apps.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCustomRepository {
    List<User> findByCriteria(UserListDto.UserListRequest request) throws Exception;
}
