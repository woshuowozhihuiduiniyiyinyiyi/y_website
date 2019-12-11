package com.tj.y.web.controller;

import com.tj.y.web.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class VideoController {

  @Resource
  private VideoService videoService;

  @GetMapping("/video/list")
  public ResponseEntity videoList() {
    return ResponseEntity.ok(videoService.listVideo());
  }
}
