package net.anatolich.testcontext.chuck;

import net.anatolich.testcontext.FeatureTest;
import net.anatolich.testcontext.log.LoggingQuoteCollector;
import net.anatolich.testcontext.quote.QuoteCollector;
import net.anatolich.testcontext.quote.QuoteProvider;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import static org.junit.Assert.assertThat;

@Import(ChuckQuoteTest.QuoteProviderConfiguration.class)
public class ChuckQuoteTest extends FeatureTest {

    @Autowired
    private QuoteProvider quotes;
    @Autowired
    private QuoteCollector quotesCollector;

    @Test
    public void chuckProvider() {
        assertThat(quotes.name(), Matchers.equalTo(ChuckQuoteProvider.NAME));
    }

    @Test
    public void loggingQuoteCollector() {
        assertThat(quotesCollector.name(), Matchers.equalTo(LoggingQuoteCollector.NAME));
    }

    @Configuration
    static class QuoteProviderConfiguration {

        @Primary
        @Bean
        public QuoteProvider quoteProvider() {
            return new ChuckQuoteProvider();
        }
    }
}
