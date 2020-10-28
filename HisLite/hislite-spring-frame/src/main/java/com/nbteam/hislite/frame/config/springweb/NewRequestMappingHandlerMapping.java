package com.nbteam.hislite.frame.config.springweb;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;
import org.springframework.web.servlet.mvc.condition.HeadersRequestCondition;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


public class NewRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

	private boolean useSuffixPatternMatch = true;

	private boolean useTrailingSlashMatch = true;
	
	private ContentNegotiationManager contentNegotiationManager = new ContentNegotiationManager();

	private final List<String> fileExtensions = new ArrayList<String>();
	/****
	 *  实现 RequestMapping  默认根据包路径生成 url
	 */
	@Override
	protected RequestMappingInfo getMappingForMethod(Method method,
			Class<?> handlerType) {
		RequestMappingInfo info = null;
		RequestMapping methodAnnotation = AnnotatedElementUtils.findMergedAnnotation(method, RequestMapping.class);
		if (methodAnnotation != null) {
			RequestCondition<?> methodCondition = getCustomMethodCondition(method);
			info = createRequestMappingInfo(methodAnnotation, methodCondition,method);
			RequestMapping typeAnnotation =AnnotatedElementUtils.findMergedAnnotation(handlerType, RequestMapping.class);
			if (typeAnnotation != null) {
				RequestCondition<?> typeCondition = getCustomTypeCondition(handlerType);
				info = createRequestMappingInfo(typeAnnotation, typeCondition,handlerType).combine(info);
			}
		}
		return info;
	}
	/****
	 * 
	* @Title: createRequestMappingInfo 
	* @Description:构造自定义请求 mappig
	* @param   输入参数
	* @return RequestMappingInfo    返回类型 
	* @throws
	 */
	protected RequestMappingInfo createRequestMappingInfo(RequestMapping annotation, RequestCondition<?> customCondition,AnnotatedElement element) {
		String[] patterns = resolveEmbeddedValuesInPatterns(annotation.value());
		if(patterns!=null && (patterns.length == 0)){
			if(element instanceof Class){ // 如果是类名就取包路径
				Class<?> handlerType = (Class<?>) element;
				patterns= new String[]{this.classPathToUrl(handlerType.getName())};
			}else{  //如果是方法就去方法名称
				Method method = (Method) element;
				patterns= new String[]{method.getName()};
			}
			
		}
		return new RequestMappingInfo(
				new PatternsRequestCondition(patterns, getUrlPathHelper(), getPathMatcher(),
						this.useSuffixPatternMatch, this.useTrailingSlashMatch, this.fileExtensions),
				new RequestMethodsRequestCondition(annotation.method()),
				new ParamsRequestCondition(annotation.params()),
				new HeadersRequestCondition(annotation.headers()),
				new ConsumesRequestCondition(annotation.consumes(), annotation.headers()),
				new ProducesRequestCondition(annotation.produces(), annotation.headers(), this.contentNegotiationManager),
				customCondition);
	}
	
	/***
	 * 
	* @Title: classPathToUrl 
	* @Description: 把类路径转换为url
	* @param   输入参数
	* @return String    返回类型 
	* @throws
	 */
	private String  classPathToUrl(String path){
		//1.去除包路径
		//2.去除controller包
		String typeValue = path.replaceAll("^com\\.nbteam\\.hislite\\.[a-zA-z]+\\.|[c|C]ontroller[\\.]*", "");
		//3.类名称首字母转小写
		String[] typeValues = typeValue.split("\\.");
		String lastStr = typeValues[typeValues.length-1];
		typeValues[typeValues.length-1] = lastStr.substring(0, 1).toLowerCase() + lastStr.substring(1);
		return StringUtils.join(typeValues, "/");
	}
	/****
	 * 1. 应为集成FeignRPC 调用,RequestMappingHandlerMapping 扫描@Controller注解或@RequestMapping注解
	 * 但是@FeignClient 种的@RequestMapping 注解不需要扫描
	 */
	@Override
    protected boolean isHandler(Class<?> beanType) {
        return super.isHandler(beanType) &&
                !AnnotatedElementUtils.hasAnnotation(beanType, FeignClient.class);
    }
}