package net.anatolich.testcontext.adams;

import net.anatolich.testcontext.quote.Quote;
import net.anatolich.testcontext.quote.QuoteProvider;

public class AdamsQuoteProvider implements QuoteProvider {

    static final String NAME = "adams";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public Quote randomQuote() {
        return new Quote("Ultimate answer is 42", "Douglas Adams");
    }
}
