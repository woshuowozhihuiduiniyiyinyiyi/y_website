package com.tj.y.web.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tj.y.web.entity.Video;
import com.tj.y.web.enums.BaseStatusEnum;
import com.tj.y.web.mapper.VideoMapper;
import com.tj.y.web.service.VideoService;
import com.tj.y.web.vo.responseVO.VideoResObj;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

  @Resource
  private VideoMapper videoMapper;

  @Override public List<VideoResObj> listVideo() {
    List<Video> videos = videoMapper
        .selectList(Wrappers.<Video>query().lambda().eq(Video::getHasDelete, BaseStatusEnum.UN_DELETE.getValue()));
    if (CollectionUtils.isEmpty(videos)) {
      return new ArrayList<>();
    }

    List<VideoResObj> videoResObjs = new ArrayList<>();
    for (Video video : videos) {
      VideoResObj videoResObj = new VideoResObj();
      BeanUtils.copyProperties(video, videoResObj);
      videoResObjs.add(videoResObj);
    }

    return videoResObjs;
  }
}
