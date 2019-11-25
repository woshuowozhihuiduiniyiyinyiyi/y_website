package com.tj.y.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("user")
@Data
public class User {

  @TableId(type = IdType.AUTO)
  private Integer id;

  /**
   * 昵称
   */
  private String nickName;

  /**
   * 手机号
   */
  private String mobile;

  /**
   * 账号
   */
  private String account;

  /**
   * 密码
   */
  private String password;

  /**
   * 剩余视频数
   */
  private Integer remainVideoNum;

  /**
   * 是否是会员，0否1是
   */
  private Integer hasVip;

  /**
   * vip 过期时间
   */
  private Date vipExpired;

  /**
   * 是否删除，0未删除，1已删除
   */
  private Integer hasDelete;

  /**
   * 创建时间
   */
  private Date createdAt;

  /**
   * 创建人
   */
  private Integer createdBy;

  /**
   * 修改时间
   */
  private Date updatedAt;

  /**
   * 修改人
   */
  private Integer updatedBy;
}
