package com.nbteam.hislite.frame.config.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.service.Parameter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Value("${spring.application.name}")
	private String applicationName ;
	
    public  String VERSION = "1.0.0"; //后期维护注解注入 TODO

	 @Bean  
    public Docket api() { 
		 //header accessToken 验证 配置
	    ParameterBuilder tokenPar = new ParameterBuilder();
    	List<Parameter> pars = new ArrayList<Parameter>();
    	tokenPar.name("accessToken").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
    	pars.add(tokenPar.build());
		 
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(this.apiInfo())
                .select()  
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) //只扫描有API 注解的
                //.apis(RequestHandlerSelectors.any())  全部的RequestHandler多扫描  
                .paths(PathSelectors.any())  
                .build()
                .globalOperationParameters(pars);  
    }
	/****
	 * 
	* @Title: apiInfo 
	* @Description: API 文档说明配置
	* @param   输入参数
	* @return ApiInfo    返回类型 
	* @throws
	 */
	 public ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title(applicationName+"应用API")
	                .description("应用API")
	                .license("Apache 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	                .termsOfServiceUrl("")
	                .build();
	    }
}
