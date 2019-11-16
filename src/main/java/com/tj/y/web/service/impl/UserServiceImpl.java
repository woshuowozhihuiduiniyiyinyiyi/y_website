package com.tj.y.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tj.y.web.config.handler.ServiceException;
import com.tj.y.web.config.handler.ServiceExceptionEnum;
import com.tj.y.web.config.jwt.TokenHelper;
import com.tj.y.web.entity.User;
import com.tj.y.web.enums.BaseStatusEnum;
import com.tj.y.web.mapper.UserMapper;
import com.tj.y.web.service.UserService;
import com.tj.y.web.vo.responseVO.LoginResObj;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserMapper userMapper;

  @Resource
  private TokenHelper tokenHelper;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public LoginResObj login(String account, String password) {
    User user = userMapper.selectOne(Wrappers.<User>query().lambda()
        .eq(User::getUsername, account).eq(User::getPassword, password)
        .eq(User::getHasDelete, BaseStatusEnum.UN_DELETE.getValue()));
    if (Objects.isNull(user)) {
      throw new ServiceException(ServiceExceptionEnum.USER_LOGIN_ERROR);
    }

    return genLoginResObj(user);
  }

  private LoginResObj genLoginResObj(User user) {
    LoginResObj loginResObj = new LoginResObj();

    loginResObj.setUserId(user.getId());
    loginResObj.setUserName(user.getNickName());
    loginResObj.setPhone(user.getMobile());

    String sid = tokenHelper.generate(user.getId(), user.getNickName());
    loginResObj.setToken(sid);

    return loginResObj;
  }
}
