package com.zengtengpeng.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.zengtengpeng"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("auto-code接口(swagger 目前有BUG,参数如果是实体类,设置忽略该参数不起作用.所以请忽略下面 (*.*) 带点的参数,这些参数不会被使用)")
                //创建人
                .contact(new Contact("ztp", "https://gitee.com/ztp/auto-code", "744489075@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API描述")
                .build();
    }


}