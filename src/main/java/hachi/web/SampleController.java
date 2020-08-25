package hachi.web;

import hachi.entity.Event;
import org.springframework.stereotype.Controller;
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
}
