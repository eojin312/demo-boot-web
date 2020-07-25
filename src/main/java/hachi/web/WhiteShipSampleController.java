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
}
