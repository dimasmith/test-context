package net.anatolich.testcontext.quote;

import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Component
public class QuoteRestClient {

    private final MockMvc mockMvc;

    public QuoteRestClient(WebApplicationContext context) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public void getRandomQuote() throws Exception {
        mockMvc.perform(get("/v1/quotes"));
    }
}
