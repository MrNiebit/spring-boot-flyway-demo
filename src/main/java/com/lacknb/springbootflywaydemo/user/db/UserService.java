package com.lacknb.springbootflywaydemo.user.db;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author gitsilence
 * @date 2024-01-06
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 校验 user name 是否已经存在
     * @param userName
     * @return
     */
    boolean checkUserNameDuplicate(String userName);
}
