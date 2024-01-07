package com.lacknb.springbootflywaydemo.user.model;

import com.lacknb.springbootflywaydemo.user.command.AddUserCommand;
import com.lacknb.springbootflywaydemo.user.command.UpdateUserCommand;
import com.lacknb.springbootflywaydemo.user.db.UserEntity;
import com.lacknb.springbootflywaydemo.user.db.UserService;
import java.util.Date;
import org.springframework.beans.BeanUtils;

/**
 * @author gitsilence
 * @date 2024-01-07
 */
public class UserModel extends UserEntity {

    private final UserService userService;

    public UserModel(UserService userService) {
        this.userService = userService;
    }

    public UserModel(UserEntity userEntity, UserService userService) {
        if (userEntity != null) {
            // 如果大数据量的话  可以用MapStruct优化
            BeanUtils.copyProperties(userEntity, this);
        }
        this.userService = userService;
    }

    public void loadAddCommand(AddUserCommand addCommand) {
        this.setGroupId(addCommand.getGroupId());
        this.setUserName(addCommand.getUserName());
        this.setUserPwd(addCommand.getUserPwd());
        if (getGmtCreate() == null) {
            setGmtCreate(new Date());
        }
    }

    public void loadUpdateCommand(UpdateUserCommand updateUserCommand) {
        loadAddCommand(updateUserCommand);
        setGmtModify(new Date());
    }

    public void checkUserNameUnique() {
        if (userService.checkUserNameDuplicate(getUserName())) {
            throw new RuntimeException("user name duplicate!");
        }
    }
}
