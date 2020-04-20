package cn.edu.cqupt.nmid.homeworksystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2019/12/7 17:32
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置swagger
    @Bean
    public Docket docket(Environment environment){
        Profiles profiles = Profiles.of("dev");

        //2.通过environment.acceptsProfiles判断是否处于自己设定的环境
        boolean b = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("main")
                .globalOperationParameters(setHeaderToken())
                .enable(b);
    }
    //配置swagger-ui页面上的信息
    private ApiInfo apiInfo(){
        Contact contact = new Contact("nmid大后端", "https://www.itrover.cn", "1172610139@qq.com");
        return new ApiInfo("HomeWrokSystem的后端", "用于测试","1.0",null,contact,"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",new ArrayList());
    }

    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
}