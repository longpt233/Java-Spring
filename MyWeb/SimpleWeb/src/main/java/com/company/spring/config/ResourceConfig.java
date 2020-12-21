// classs nay danh cho cah truy nhap truc tiep vao anh
// => khong bao mat 
// chuyen sang 1 controller rieng xu li anh 

//package com.company.spring.config;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class ResourceConfig implements WebMvcConfigurer {
//
//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        exposeDirectory("product-photos", registry);
//    }
//     
//    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
//        Path uploadDir = Paths.get(dirName);
//        String uploadPath = uploadDir.toFile().getAbsolutePath();
//        System.out.println(uploadPath+"--"+dirName+" cau hinh Path ");
//         
//        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
//    }
//}