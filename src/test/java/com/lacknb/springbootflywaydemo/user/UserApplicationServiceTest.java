package com.lacknb.springbootflywaydemo.user;

import com.lacknb.springbootflywaydemo.user.command.AddUserCommand;
import com.lacknb.springbootflywaydemo.user.command.UpdateUserCommand;
import com.lacknb.springbootflywaydemo.user.dto.UserDTO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author gitsilence
 * @date 2024-01-07
 */
@SpringBootTest
public class UserApplicationServiceTest {

    @Autowired
    private UserApplicationService userApplicationService;

    @Test
    void getUserList() {
        List<UserDTO> userList = userApplicationService.getUserList();
        userList.forEach(System.out::println);
    }

    @Test
    void addUser() {
        AddUserCommand addUserCommand = new AddUserCommand();
        addUserCommand.setUserName("lsi");
        addUserCommand.setGroupId(1002);
        addUserCommand.setUserPwd("lsi-pass");

        userApplicationService.addUser(addUserCommand);
    }

    @Test
    void updateUser() {
        UpdateUserCommand updateUserCommand = new UpdateUserCommand();
        updateUserCommand.setUserId(1L);
        updateUserCommand.setUserPwd("zs-change-pass");

        userApplicationService.updateUser(updateUserCommand);
    }
}