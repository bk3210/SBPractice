package com.kosa.myapp.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:/application.properties")
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		// CORS 정책으로 오류 해결
		registry.addMapping("/**")
				.allowedMethods("*")
				.allowedOriginPatterns("*");
		/*
		 registry.addMapping("/**")
			.allowedMethods("*")
			.allowedOriginPatterns("*");
		*/
		
	}
	

	//application.properties에 있는 내용 읽어와서 변수에 저장
	@Value("${fileUploadPath}")
	String fileUploadPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		exposeDirectory(fileUploadPath, registry);
	}
	
	void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
		Path uploadDir = Paths.get(dirName);
		// 업로드 폴더의 물리적 구조(절대경로 확인)
		String uploadPath=uploadDir.toFile().getAbsolutePath();
		
		if(dirName.startsWith("../")) {
			dirName=dirName.replace("../", "");
		}
		
		System.out.println(dirName);
		System.out.println(uploadPath);
		
		registry
			.addResourceHandler("/"+dirName+"/**")
			.addResourceLocations("file:/"+uploadPath+"/");
		
		
		// 특정 폴더를 파일 서버로 작동시킨다
		// application.properties의 fileUploadPath에 지정된 폴더값을 읽어서
		// 그 폴더의 권한을 파일 서버로 만든다
		
	}

}