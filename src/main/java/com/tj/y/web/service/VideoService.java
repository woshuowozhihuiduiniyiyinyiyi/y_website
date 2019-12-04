package com.tj.y.web.service;

import com.tj.y.web.vo.responseVO.VideoResObj;

import java.util.List;

public interface VideoService {

  /**
   * 视频列表
   *
   * @return 返回所有视频列表
   */
  List<VideoResObj> listVideo();

}
