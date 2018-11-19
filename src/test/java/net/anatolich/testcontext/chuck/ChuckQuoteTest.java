package net.anatolich.testcontext.chuck;

import net.anatolich.testcontext.ApplicationTests;
import net.anatolich.testcontext.quote.QuoteProvider;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChuckQuoteTest extends ApplicationTests {

    @Autowired
    private QuoteProvider quotes;

    @Test
    public void chuckProvider() {
        assertThat(quotes.name(), Matchers.equalTo(ChuckQuoteProvider.NAME));
    }

    @TestConfiguration
    static class QuoteProviderConfiguration {

        @Primary
        @Bean
        public QuoteProvider quoteProvider() {
            return new ChuckQuoteProvider();
        }
    }
}
