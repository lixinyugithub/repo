package com.nbteam.hislite.frame.config.springweb;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
//属性不存在默认设置 true
@ConditionalOnProperty(prefix = "com.nbteam.hislite.common.config.springweb",value = "enable",matchIfMissing = true)
public class WebMvcConfig extends WebMvcConfigurationSupport  {

    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new NewRequestMappingHandlerMapping();
    }

 // 添加ViewResolver
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
   // 处理"redirect:url"字符串
        registry.enableContentNegotiation();
        registry.viewResolver(new InternalResourceViewResolver());
    }
    /***
     * # 修改默认静态路径，默认为/**，当配置WebMvcConfig后此处配置失效
    static-path-pattern: /static/**
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");  
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/"); 
    }
    /***
     * 允许 servlet配置
     */
    @Override  
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {  
        configurer.enable();  
    }
   /* // 添加自己的格式化,  从覆写了WebMvcConfigurerAdapter中类中移过来
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        new CustomFormatterRegistrar(ENUM_PROP_NAME).registerFormatters(registry);
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonMessageConverter());
        super.configureMessageConverters(converters);
    }

    private MappingJackson2HttpMessageConverter jacksonMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        
        mapper.registerModule(new Hibernate4Module());
        messageConverter.setObjectMapper(mapper);
        return messageConverter;
    }*/
}	

