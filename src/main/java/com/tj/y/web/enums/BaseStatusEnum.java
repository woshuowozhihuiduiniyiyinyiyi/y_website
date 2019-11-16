package com.tj.y.web.enums;

public enum BaseStatusEnum {
  DELETE(1, "已删除"),
  UN_DELETE(0, "未删除");

  private Integer value;
  private String description;

  private BaseStatusEnum(Integer value, String description) {
    this.description = description;
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }

  public String getDescription() {
    return this.description;
  }
}