package com.dreamph.apps.repository;

import com.dreamph.apps.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>, UserCustomRepository {

    @Query("SELECT * FROM user WHERE id_card_no = :idCardNo")
    User findByIdCardNo(@Param("idCardNo") String idCardNo);
}
