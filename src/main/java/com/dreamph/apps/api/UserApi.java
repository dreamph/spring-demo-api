package com.dreamph.apps.api;

import com.dreamph.apps.core.dto.DataResponse;
import com.dreamph.apps.dto.UserCreateDto;
import com.dreamph.apps.dto.UserDeleteDto;
import com.dreamph.apps.dto.UserListDto;
import com.dreamph.apps.dto.UserUpdateDto;
import com.dreamph.apps.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    private UserApiHandler userApiHandler;

    @ApiOperation(value = "Inquiry User by Id")
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) throws Exception {
        return userApiHandler.findById(id);
    }

    @ApiOperation(value = "Inquiry User by criteria")
    @PostMapping("/list")
    public ResponseEntity<UserListDto.UserListResponse> list(@RequestBody UserListDto.UserListRequest request) throws Exception {
        return userApiHandler.list(request);
    }

    @ApiOperation(value = "Create User")
    @PostMapping
    public ResponseEntity<DataResponse<User>> create(@RequestBody UserCreateDto.UserCreateRequest request) throws Exception {
        return userApiHandler.create(request);
    }

    @ApiOperation(value = "Update User")
    @PutMapping
    public ResponseEntity<DataResponse<User>> update(@RequestBody UserUpdateDto.UserUpdateRequest request) throws Exception {
        return userApiHandler.update(request);
    }

    @ApiOperation(value = "Delete User")
    @DeleteMapping
    public ResponseEntity<DataResponse<String>> delete(@RequestBody UserDeleteDto.UserDeleteRequest request) throws Exception {
        return userApiHandler.delete(request);
    }

}
