package com.lacknb.springbootflywaydemo.user.dto;

import com.lacknb.springbootflywaydemo.user.db.UserEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author gitsilence
 * @date 2024-01-07
 */
@Data
public class UserDTO {

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

    public UserDTO(UserEntity user) {
        if (user != null) {
            BeanUtils.copyProperties(user, this);
        }
    }
}
