package com.tj.y.web.controller;

import com.tj.y.web.config.handler.ServiceException;
import com.tj.y.web.config.handler.ServiceExceptionEnum;
import com.tj.y.web.service.UserService;
import com.tj.y.web.vo.requestVO.LoginReqObj;
import com.tj.y.web.vo.responseVO.LoginResObj;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class UserController {

  @Resource
  private UserService userService;

  @PostMapping("/user/login")
  public ResponseEntity login(@Validated @RequestBody LoginReqObj loginReqObj) {
    LoginResObj loginResObj = userService.login(loginReqObj.getAccount(), loginReqObj.getPassword());
    if (StringUtils.isEmpty(loginResObj)) {
      throw new ServiceException(ServiceExceptionEnum.USER_LOGIN_ERROR);
    }

    return ResponseEntity.ok(loginResObj);
  }
}
