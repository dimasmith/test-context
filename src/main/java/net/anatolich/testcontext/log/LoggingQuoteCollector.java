package net.anatolich.testcontext.log;

import net.anatolich.testcontext.quote.Quote;
import net.anatolich.testcontext.quote.QuoteCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingQuoteCollector implements QuoteCollector {

    public static final String NAME = "LoggingCollector";
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingQuoteCollector.class);

    @Override
    public void remember(Quote quote) {
        LOGGER.info("Quote: {}", quote);
    }

    @Override
    public String name() {
        return NAME;
    }
}
