package net.anatolich.testcontext.adams;

import net.anatolich.testcontext.feature.FeatureTest;
import net.anatolich.testcontext.collector.CollectionQuoteCollector;
import net.anatolich.testcontext.collector.TestSetup;
import net.anatolich.testcontext.quote.QuoteCollector;
import net.anatolich.testcontext.quote.QuoteProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@Import({AdamsQuoteTest.QuoteProviderConfiguration.class, TestSetup.class})
public class AdamsQuoteTest extends FeatureTest {

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
        assertThat(quoteCollector.name(), equalTo(CollectionQuoteCollector.NAME));
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
