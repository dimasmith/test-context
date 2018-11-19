package net.anatolich.testcontext.fortune;

import net.anatolich.testcontext.quote.Quote;
import net.anatolich.testcontext.quote.QuoteProvider;
import org.springframework.stereotype.Component;

@Component
public class FortuneQuotes implements QuoteProvider {

    public static final String NAME = "fortune";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public Quote randomQuote() {
        return new Quote("Fortune Quote", "Fortune");
    }
}
