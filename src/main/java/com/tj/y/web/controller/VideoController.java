package com.tj.y.web.controller;

import com.tj.y.web.service.VideoService;
import com.tj.y.web.vo.responseVO.VideoResObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {

  @Resource
  private VideoService videoService;

  @GetMapping("/list")
  public ModelAndView videoList() {
    ModelAndView modelAndView = new ModelAndView("views/index/index");

    List<VideoResObj> resObjs = videoService.listVideo();
    modelAndView.addObject("videos", resObjs);

    return modelAndView;
  }
}
