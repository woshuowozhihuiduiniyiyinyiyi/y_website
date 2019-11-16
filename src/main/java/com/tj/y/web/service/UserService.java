package com.tj.y.web.service;

import com.tj.y.web.vo.responseVO.LoginResObj;

public interface UserService {

  /**
   * 根据用户名和密码来获取用户
   *
   * @param account
   * @param password
   * @return
   */
  LoginResObj login(String account, String password);

}
