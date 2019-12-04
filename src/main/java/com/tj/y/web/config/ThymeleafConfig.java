package com.tj.y.web.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingRespectLayoutTitleStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ThymeleafConfig {

  @Resource
  private ThymeleafViewResolver thymeleafViewResolver;

  /**
   * 设置Thymeleaf静态变量
   */
  @PostConstruct
  public void setStaticVariables() {
    Map<String, Object> vars = new HashMap<>();
    thymeleafViewResolver.setStaticVariables(vars);
  }

  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect(new GroupingRespectLayoutTitleStrategy());
  }

}
