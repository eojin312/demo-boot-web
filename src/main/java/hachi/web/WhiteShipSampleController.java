package hachi.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class WhiteShipSampleController {

    @GetMapping("/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name) {
        return "hello" + name;
    }

    @GetMapping("/**")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
