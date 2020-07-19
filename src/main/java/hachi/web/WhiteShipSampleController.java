package hachi.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WhiteShipSampleController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
