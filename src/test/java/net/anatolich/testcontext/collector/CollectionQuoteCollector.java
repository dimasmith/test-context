package net.anatolich.testcontext.collector;

import net.anatolich.testcontext.quote.Quote;
import net.anatolich.testcontext.quote.QuoteCollector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CollectionQuoteCollector implements QuoteCollector, QuoteCollectorInspector {

    private static final String NAME = "TestCollector";
    private List<Quote> quotes = new ArrayList<>();

    @Override
    public void remember(Quote quote) {
        quotes.add(quote);
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public void clear() {
        quotes.clear();
    }

    @Override
    public List<Quote> quotes() {
        return Collections.unmodifiableList(quotes);
    }
}
