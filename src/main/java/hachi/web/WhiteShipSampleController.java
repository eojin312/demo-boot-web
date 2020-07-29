package hachi.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/hello")
public class WhiteShipSampleController {

    @GetMapping("/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name) {
        return "hello" + name;
    }

    @GetMapping(value = "/params", params = "name=hachi") //파라미터에 name 이라는 게 있어야한다
    @ResponseBody
    public String params() {
        return "parameter";
    }

    @GetMapping(value = "/**", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/plane")
    @ResponseBody
    public String planeText() {
        return "plane text";
    }
    @GetMapping(value = "/header", headers = HttpHeaders.FROM) // 이 헤더가 들어있는 요청만 처리하겠는 뜻 + ! 를 붙이면 from 이 헤더에 없어야한다는 뜻
    @ResponseBody
    public String fromHeader() {
        return "header";
    }

    @GetMapping(value = "/not-from-header", headers = "!" + HttpHeaders.FROM) //! 를 붙이면 from 이 헤더에 없어야한다는 뜻
    @ResponseBody
    public String notFromHeader() {
        return "header";
    }

    @GetMapping(value = "/authorization-value-header", headers = HttpHeaders.AUTHORIZATION + "=" + "hachi") //테스트 코드의 value 의 값과 같으면 통과
    @ResponseBody
    public String authorizationEqualValue() {
        return "header";
    }

    @PostMapping(value = "/**")
    @ResponseBody
    public String posts() {
        return "hello";
    }

    @GetHelloMapping
    @ResponseBody
    public String annotation() {
        return "hello";
    }

}
