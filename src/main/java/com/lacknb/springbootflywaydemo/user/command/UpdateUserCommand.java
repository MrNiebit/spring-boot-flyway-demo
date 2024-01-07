package com.lacknb.springbootflywaydemo.user.command;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gitsilence
 * @date 2024-01-07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateUserCommand extends AddUserCommand {

    private Long userId;

}
