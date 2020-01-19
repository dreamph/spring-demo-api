package com.dreamph.apps.repository;

import com.dreamph.apps.dto.UserListDto;
import com.dreamph.apps.repository.utils.SQLCriteriaBuilder;
import com.dreamph.apps.repository.utils.SQLParameter;
import com.dreamph.apps.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.dreamph.apps.core.utils.ValidationUtils.isNotEmpty;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    @Override
    public List<User> findByCriteria(UserListDto.UserListRequest request) throws Exception {
        SQLCriteriaBuilder cb = new SQLCriteriaBuilder();
        cb.addQuery("SELECT * FROM app_user");
        if (isNotEmpty(request.getId())) {
            cb.addQuery("AND id = :id", SQLParameter.of("id", request.getId()));
        }
        if (isNotEmpty(request.getIdCardNo())) {
            cb.addQuery("AND id_card_no = :idCardNo", SQLParameter.of("idCardNo", request.getIdCardNo()));
        }

        List<User> queryResults = jdbcTemplate.query(cb.getSql().toString(), cb.getParameters(), new BeanPropertyRowMapper(User.class));

        return queryResults;
    }
}
