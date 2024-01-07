package com.lacknb.springbootflywaydemo.user.command;

import lombok.Data;

/**
 * @author gitsilence
 * @date 2024-01-07
 */
@Data
public class AddUserCommand {

    /**
     * 群组id
     */
    private int groupId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

}
