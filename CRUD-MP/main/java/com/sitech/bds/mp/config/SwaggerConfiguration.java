package com.sitech.bds.mp.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.sitech.bds.mp.interceptor.SwaggerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
@EnableKnife4j
public class SwaggerConfiguration {
//    @Value("${swagger.basic.username:admin}")
//    private String username;
//    @Value("${swagger.basic.password:admin}")
//    private String password;

    /* 必须在此处配置拦截器,要不然拦不到swagger的静态资源 */
    @Bean
    @ConditionalOnProperty(name = "swagger.basic.enable", havingValue = "true")
    public MappedInterceptor getMappedInterceptor() {
        return new MappedInterceptor(new String[]{"/swagger-ui.html", "/webjars/**"},
                new SwaggerInterceptor("admin", "admin"));
    }

    @Bean(value = "admin")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
                        .description("# 学生管理系统doc")
                        .termsOfServiceUrl("http://www.sitech.com/")
//                        .contact("xx@qq.com")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("后台")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.sitech.bds.mp"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Bean(value = "official")
    public Docket defaultApi() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("# swagger-bootstrap-ui-demo RESTFUL APIs")
                        .termsOfServiceUrl("http://www.xx.com/")
//                        .contact("1219929852@qq.com")
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("官网")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.sitech.bds.mp"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("学生管理")
                .contact(new Contact("za", null, null))
                .description("学生管理")
                .termsOfServiceUrl("http://swagger:8080/")
                .version("1.0.0")
                .build();
    }


}