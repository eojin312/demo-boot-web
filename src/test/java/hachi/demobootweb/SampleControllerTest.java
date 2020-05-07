package hachi.demobootweb;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void hello() throws Exception {
        Person person = new Person();
        person.setName("hachi");
        Person savedPerson = personRepository.save(person);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                .param("id", savedPerson.getId().toString()))
                .andDo(print())
                .andExpect((ResultMatcher) content().string("hello hachi"));

    }
    @Test
    public void helloStatic() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/index.html"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((ResultMatcher) content().string(Matchers.containsString("hello index")));
    }
}
