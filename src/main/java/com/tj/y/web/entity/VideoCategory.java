package com.tj.y.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("video_category")
@Data
public class VideoCategory {

  @TableId(type = IdType.AUTO)
  private Integer id;

  /**
   * 标题
   */
  private String title;

  /**
   * 名称
   */
  private String name;

  /**
   * 描述
   */
  private String description;

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
