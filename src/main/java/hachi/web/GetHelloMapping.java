package hachi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD) // GetHelloMapping 어노테이션이 어디에 사용될 수 있는지 (METHOD) 만 사용가
@Retention(RetentionPolicy.RUNTIME) // 해당 어노테이션 정보가 언제까지 유지할 것인가
@RequestMapping(method = RequestMethod.GET, value = "/hello")
public @interface GetHelloMapping {
}
