package com.lacknb.springbootflywaydemo.user.db;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author gitsilence
 * @date 2024-01-06
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    private final UserMapper userMapper;

    @Override
    public boolean checkUserNameDuplicate(String userName) {
        LambdaQueryWrapper<UserEntity> wrapper = Wrappers.lambdaQuery(UserEntity.class)
            .eq(UserEntity::getUserName, userName);
        return userMapper.exists(wrapper);
    }
}
