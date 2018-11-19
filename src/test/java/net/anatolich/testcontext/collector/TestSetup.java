package net.anatolich.testcontext.collector;

import net.anatolich.testcontext.quote.QuoteCollector;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class TestSetup {

    @Primary
    @Bean
    public QuoteCollector quoteCollector() {
        return new CollectionQuoteCollector();
    }

    @Bean
    public QuoteCollectorInspector quoteCollectorInspector() {
        return new CollectionQuoteCollector();
    }
}
