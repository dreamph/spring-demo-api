package com.dreamph.apps.api;

import com.dreamph.apps.core.dto.DataResponse;
import com.dreamph.apps.core.utils.MessageCode;
import com.dreamph.apps.dto.UserCreateDto;
import com.dreamph.apps.dto.UserDeleteDto;
import com.dreamph.apps.dto.UserListDto;
import com.dreamph.apps.dto.UserUpdateDto;
import com.dreamph.apps.repository.UserRepository;
import com.dreamph.apps.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.dreamph.apps.core.utils.ValidationUtils.isNotEmpty;
import static com.dreamph.apps.core.utils.ValidationUtils.requiredNotWhen;


@Component
public class UserApiHandler {
    private static final Logger LOG = LoggerFactory.getLogger(UserApiHandler.class);

    @Autowired
    UserRepository userRepository;

    public void findByIdValidate(String id) throws Exception {
        requiredNotWhen(isNotEmpty(id), MessageCode.E00001, "id");
    }

    public ResponseEntity<User> findById(String id) throws Exception {
        this.findByIdValidate(id);
        Optional<User> query = userRepository.findById(id);
        return query.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    public void listValidate(UserListDto.UserListRequest request) throws Exception {
    }

    public ResponseEntity<UserListDto.UserListResponse> list(UserListDto.UserListRequest request) throws Exception {
        this.listValidate(request);
        List<User> users = userRepository.findByCriteria(request);
        UserListDto.UserListResponse apiResponse = new UserListDto.UserListResponse();
        apiResponse.setData(users);
        return ResponseEntity.ok(apiResponse);
    }

    public void createValidate(UserCreateDto.UserCreateRequest request) throws Exception {

        requiredNotWhen(isNotEmpty(request.getIdCardNo()), MessageCode.E00001, "idCardNo");

        requiredNotWhen(isNotEmpty(request.getLoginName()), MessageCode.E00001, "loginName");
        requiredNotWhen(isNotEmpty(request.getLoginPassword()), MessageCode.E00001, "loginPassword");

        requiredNotWhen(isNotEmpty(request.getUserTxBy()), MessageCode.E00001, "userTxBy");
    }

    public ResponseEntity<DataResponse<User>> create(UserCreateDto.UserCreateRequest request) throws Exception {
        this.createValidate(request);

        User user = new User();
        Date curDateTime = new Date();
        String userTxBy = request.getUserTxBy();

        user.setId(UUID.randomUUID().toString());

        user.setIdCardNo(request.getIdCardNo());
        user.setLoginName(request.getLoginName());
        user.setLoginPassword(request.getLoginPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        user.setCreateBy(userTxBy);
        user.setCreateDate(curDateTime);
        user.setChangeBy(userTxBy);
        user.setChangeDate(curDateTime);

        userRepository.save(user);
        return ResponseEntity.ok(new DataResponse<>(true, user));
    }

    public void updateValidate(UserUpdateDto.UserUpdateRequest request) throws Exception {
        requiredNotWhen(isNotEmpty(request.getId()), MessageCode.E00001, "id");
        requiredNotWhen(isNotEmpty(request.getUserTxBy()), MessageCode.E00001, "userTxBy");
    }

    public ResponseEntity<DataResponse<User>> update(UserUpdateDto.UserUpdateRequest request) throws Exception {
        this.updateValidate(request);

        Optional<User> userEntity = userRepository.findById(request.getId());
        requiredNotWhen(userEntity.isPresent(), MessageCode.E00017, "id");

        Date curDateTime = new Date();

        User user = userEntity.get();
        user.setIdCardNo(request.getIdCardNo());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        user.setChangeBy(request.getUserTxBy());
        user.setChangeDate(curDateTime);

        user.setNewEntity(false);
        User result = userRepository.save(user);

        return ResponseEntity.ok(new DataResponse<>(true, result));
    }

    public void deleteValidate(UserDeleteDto.UserDeleteRequest request) throws Exception {
        requiredNotWhen(isNotEmpty(request.getId()), MessageCode.E00001, "id");
        requiredNotWhen(isNotEmpty(request.getUserTxBy()), MessageCode.E00001, "userTxBy");
    }

    public ResponseEntity<DataResponse<String>> delete(UserDeleteDto.UserDeleteRequest request) throws Exception {
        this.deleteValidate(request);

        Optional<User> userEntity = userRepository.findById(request.getId());
        requiredNotWhen(userEntity.isPresent(), MessageCode.E00017, "id");

        userRepository.deleteById(request.getId());
        return ResponseEntity.ok(new DataResponse<>(true, null));

    }

}
