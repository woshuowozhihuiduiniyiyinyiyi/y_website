package com.tj.y.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private static final String[] STATIC_RESOURCES = {
      "/assert/**",
      "/common/**",
      "/components/**",
      "/i18n/**",
      "/layout/**",
      "/vendor/**",
      "/views/**",
      "/apple-*.png",
      "favicon.ico",
      "robots.txt",
  };

  /**
   * 访问外部文件配置，访问linux 下的文件
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //配置server虚拟路径，handler为jsp中访问的目录，locations为files相对应的本地路径
    //    registry.addResourceHandler("/files/**")
    //        .addResourceLocations("file:///usr/local/data/helloworld/tmp/");
    registry.addResourceHandler("/files/**").addResourceLocations("file:///C:/Users/tj/Downloads/");
  }
}
