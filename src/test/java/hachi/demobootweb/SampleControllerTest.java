/*
package hachi.demobootweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.concurrent.TimeUnit;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.print.attribute.standard.Media;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void jsonMessage() throws Exception {
        Person person = new Person();
        person.setId(2019L);
        person.setName("hachi");

        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/jsonMessage")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .accept(MediaType.APPLICATION_JSON_UTF8)
                            .content(jsonString)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2019))
                .andExpect(jsonPath("$.name").value("hachi"));
    }
}
*/
