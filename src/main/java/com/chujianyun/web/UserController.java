package com.chujianyun.web;

import com.chujianyun.entity.dto.UserDTO;
import com.chujianyun.entity.param.UserParam;
import com.chujianyun.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/check")
    public ResponseEntity<UserDTO> checkUser(UserParam userParam) {
        return new ResponseEntity<>(userService.checkUser(userParam), HttpStatus.OK);
    }

    @PostMapping("/checkSome")
    public ResponseEntity<UserDTO> checkUserSome(UserParam userParam) {
        return new ResponseEntity<>(userService.checkUserSome(userParam), HttpStatus.OK);
    }
}
