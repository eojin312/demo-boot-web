package hachi.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
}