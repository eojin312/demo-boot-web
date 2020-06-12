package hachi.demobootweb;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingIntercepter()).order(0);
        registry.addInterceptor(new AnotherIntercepter()).addPathPatterns("/hi").order(-1); // 숫자가 낮을 수록 호출이 더 우선시 됨 + addpathPatterns 는 hi 만 호출하겠다느 ㄴ뜻
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hi").setViewName("hi");
    }
}
