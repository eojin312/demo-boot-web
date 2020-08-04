package hachi.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class WhiteShipSampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 이름파라미터_요청테스트() throws Exception {

        mockMvc.perform(get("/hello/eojin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("helloeojin"));
    }

    @Test
    void 요청테스트() throws Exception {
        mockMvc.perform(get("/hello")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
                .andExpect(handler().handlerType(WhiteShipSampleController.class))
                .andExpect(handler().methodName("hello"));
    }

    @Test
    void header에json타입확인하는테스트() throws Exception {
        mockMvc.perform(get("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON) // JSON 을 원한다 + Accept 헤더에 추가
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void text_plane_요청테스트() throws Exception {
        mockMvc.perform(get("/hello/plane")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void from헤더요청테스트() throws Exception {
        mockMvc.perform(get("/hello/header")
                .header(HttpHeaders.FROM, "localhost") // 헤더에 from 이 있으면 요청 받음
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void from헤더요청없어야하는테스트() throws Exception {
        mockMvc.perform(get("/hello/not-from-header")
                .header(HttpHeaders.AUTHORIZATION, "hachi")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void from헤더요청_value_값이정확히일치해야하는_테스트() throws Exception {
        mockMvc.perform(get("/hello/authorization-value-header")
                .header(HttpHeaders.AUTHORIZATION, "hachi")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void name_파라미터가_있는지_테스트() throws Exception {
        mockMvc.perform(get("/hello/params")
                .param("name", "hachi")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void name_파라미터의값이일치해야하는_있는지_테스트() throws Exception {
        mockMvc.perform(get("/hello/params")
                .param("name", "hachi") //Parameters = {name=[hachi]}
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void 헤더정보_보이는지_테스트() throws Exception {
        mockMvc.perform(head("/hello/params") //get 대신 head 가 들어가면 get 요청과 동일하지만 응답 본문은 받아오지 않고 응답 헤더만 받아온다.
                .param("name", "hachi")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void option테스트() throws Exception {
        mockMvc.perform(options("/hello")) // Headers = [Allow:"GET,HEAD,POST,OPTIONS"]
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     *  allow 되는 메소드들이 맞는지 확인하는 메소드 hasItems() 를 쓰는 이유는 allow 메소드들이 순서대로 정렬해두지않으면
     *  java.lang.AssertionError: Response header 'Allow' expected:<[GET, OPTIONS, POST, HEAD]> but was:<[GET,HEAD,POST,OPTIONS]>
     *  이런 오류를 뜨기 때문.
     *  hasItems(containsString("GET")) 이런 식으로 테스트를 돌리면 순서 상관없이 메소드를 나열해도 된다
     * @throws Exception
     */
    @Test
    void option_응답헤더확인_테스트() throws Exception {
        mockMvc.perform(options("/hello"))
                .andDo(print())
                .andExpect(header().exists(HttpHeaders.ALLOW)) // 어떤 헤더의 값이 있는지 확인
                .andExpect(header().stringValues(HttpHeaders.ALLOW, hasItems(
                        containsString("GET")
                        ,containsString("POST")
                        ,containsString("HEAD")
                        ,containsString("OPTIONS")
                )))
                .andExpect(status().isOk());
    }

    @Test
    void 커스텀어노테이션_테스트() throws Exception {
        mockMvc.perform(get("/hello")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
                .andExpect(handler().handlerType(WhiteShipSampleController.class))
                .andExpect(handler().methodName("hello"));
    }

    @Test
    void url패턴테스트() throws Exception {
        mockMvc.perform(delete("/hello/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1));
    }
}