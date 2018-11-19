package net.anatolich.testcontext.collector;

import net.anatolich.testcontext.quote.Quote;

import java.util.List;

public interface QuoteCollectorInspector {
    void clear();

    List<Quote> quotes();
}
