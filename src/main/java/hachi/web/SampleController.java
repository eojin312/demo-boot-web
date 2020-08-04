package hachi.web;

import hachi.entity.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable Long id, @MatrixVariable String name) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }

}
