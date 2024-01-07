package com.lacknb.springbootflywaydemo.user.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lacknb.springbootflywaydemo.common.core.base.BaseEntity;
import com.lacknb.springbootflywaydemo.user.dto.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gitsilence
 * @date 2024-01-06
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@TableName("v_user")
public class UserEntity extends BaseEntity<UserEntity> {

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

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
