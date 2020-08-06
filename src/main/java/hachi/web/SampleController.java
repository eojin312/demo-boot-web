package hachi.web;

import hachi.entity.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@RequestParam(required = false, defaultValue = "eojin")String name) {
        Event event = new Event();
        event.setName(name);
        return event;
    }

}
