package com.lacknb.springbootflywaydemo.user;

import com.lacknb.springbootflywaydemo.user.command.AddUserCommand;
import com.lacknb.springbootflywaydemo.user.command.UpdateUserCommand;
import com.lacknb.springbootflywaydemo.user.db.UserEntity;
import com.lacknb.springbootflywaydemo.user.db.UserService;
import com.lacknb.springbootflywaydemo.user.dto.UserDTO;
import com.lacknb.springbootflywaydemo.user.model.UserModel;
import com.lacknb.springbootflywaydemo.user.model.UserModelFactory;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitsilence
 * @date 2024-01-06
 */
@Service
@RequiredArgsConstructor
public class UserApplicationService {

    private final UserModelFactory userModelFactory;

    private final UserService userService;

    public List<UserDTO> getUserList() {
        List<UserEntity> list = userService.list();
        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public void addUser(AddUserCommand addUserCommand) {
        UserModel userModel = userModelFactory.create();

        userModel.loadAddCommand(addUserCommand);
        userModel.checkUserNameUnique();

        userModel.insert();
    }

    public void updateUser(UpdateUserCommand updateUserCommand) {
        UserModel userModel = userModelFactory.loadById(updateUserCommand.getUserId());
        userModel.loadUpdateCommand(updateUserCommand);

        userModel.checkUserNameUnique();
        userModel.updateById();
    }

}
