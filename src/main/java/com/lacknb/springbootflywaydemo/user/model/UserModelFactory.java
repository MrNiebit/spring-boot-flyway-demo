package com.lacknb.springbootflywaydemo.user.model;

import com.lacknb.springbootflywaydemo.user.db.UserEntity;
import com.lacknb.springbootflywaydemo.user.db.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author gitsilence
 * @date 2024-01-07
 */
@Component
@RequiredArgsConstructor
public class UserModelFactory {

    private final UserService userService;

    public UserModel loadById(Long id) {
        UserEntity byId = userService.getById(id);
        if (byId == null) {
            throw new RuntimeException("not found user");
        }
        return new UserModel(byId, userService);
    }

    public UserModel create() {
        return new UserModel(userService);
    }
}
