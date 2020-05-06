package hachi.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    //preHandle
    //요청처리
    //postHandler
    //뷰 랜더링
    //afterCompletion2
    //afterCompletion1

    // 정보전달 핸들러 인터셉터

    @GetMapping("/hello{name}")
    public String hello(@RequestParam("name") Person person) {
        return "hello" + person.getName();
    }
}
