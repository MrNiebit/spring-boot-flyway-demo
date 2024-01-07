package com.lacknb.springbootflywaydemo.controller;

import com.lacknb.springbootflywaydemo.user.UserApplicationService;
import com.lacknb.springbootflywaydemo.user.dto.UserDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gitsilence
 * @date 2024-01-07
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserApplicationService userApplicationService;

    @RequestMapping("/list")
    public List<UserDTO> list() {
        return null;
    }

}
