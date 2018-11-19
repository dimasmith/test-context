package net.anatolich.testcontext.adams;

import net.anatolich.testcontext.Application;
import net.anatolich.testcontext.ApplicationTests;
import net.anatolich.testcontext.log.LoggingQuoteCollector;
import net.anatolich.testcontext.quote.QuoteCollector;
import net.anatolich.testcontext.quote.QuoteProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Import({AdamsQuoteTest.QuoteProviderConfiguration.class})
public class AdamsQuoteTest extends ApplicationTests {

    @Autowired
    private QuoteProvider quotes;
    @Autowired
    private QuoteCollector quoteCollector;

    @Test
    public void chuckProvider() {
        assertThat(quotes.name(), equalTo(AdamsQuoteProvider.NAME));
    }

    @Test
    public void loggingQuoteCollector() {
        assertThat(quoteCollector.name(), equalTo(LoggingQuoteCollector.NAME));
    }

    @Configuration
    static class QuoteProviderConfiguration {

        @Primary
        @Bean
        public QuoteProvider quoteProvider() {
            return new AdamsQuoteProvider();
        }
    }
}
