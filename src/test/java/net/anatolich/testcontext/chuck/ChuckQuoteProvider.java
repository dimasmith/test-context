package net.anatolich.testcontext.chuck;

import net.anatolich.testcontext.quote.Quote;
import net.anatolich.testcontext.quote.QuoteProvider;

public class ChuckQuoteProvider implements QuoteProvider {

    static final String NAME = "chuck";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public Quote randomQuote() {
        return new Quote("Chuck is the Greatest", "Chuck");
    }
}
