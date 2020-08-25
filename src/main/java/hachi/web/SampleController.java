package hachi.web;

import hachi.entity.Event;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@RequestParam(required = false, defaultValue = "hachi")String name) {
        Event event = new Event();
        event.setName(name);
        return event;
    }

    @PostMapping("/events/request")
    @ResponseBody
    public Event events(@RequestParam String name, @RequestParam Integer limit) {
        Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        return event;
    }

    @PostMapping("/events/model")
    @ResponseBody
    public Event eventmodel(@ModelAttribute Event event) {
        return event;
    }

    @PostMapping("/events/name/{name}")
    @ResponseBody
    //bindingResult 은 잘못된 파라미터 정보로 바인딩을 못할 때 이 변수에 바인딩에 관한 에러가 담아온다.
    public Event eventbinding(@ModelAttribute Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("==================");
            bindingResult.getAllErrors().forEach(c -> {
                System.out.println(c.toString());
            });
        }
        return event;
    }
}
