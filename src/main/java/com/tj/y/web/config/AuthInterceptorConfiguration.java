package com.tj.y.web.config;

import com.tj.y.web.config.jwt.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 身份验证
 */
@Configuration
public class AuthInterceptorConfiguration implements WebMvcConfigurer {

  @Resource
  private JwtInterceptor jwtInterceptor;

  /**
   * 路径规则
   * <p>
   * /api/* 所有接口位于该地址下
   * /api/auth/* 所有位于该接口下的地址，需要身份验证
   *
   * @param registry 过滤器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 多个拦截器组成一个拦截器链
    // addPathPatterns 用于添加拦截规则
    // excludePathPatterns 用户排除拦截
    registry.addInterceptor(jwtInterceptor)
        .addPathPatterns("/api/auth/**");
  }

  /**
   * 访问外部文件配置，访问linux 下的文件
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //配置server虚拟路径，handler为jsp中访问的目录，locations为files相对应的本地路径
    //    registry.addResourceHandler("/files/**")
    //        .addResourceLocations("file:///usr/local/data/helloworld/tmp/");
    registry.addResourceHandler("/files/**").addResourceLocations("file:///C:/Users/tj/Downloads/");
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
  }
}
