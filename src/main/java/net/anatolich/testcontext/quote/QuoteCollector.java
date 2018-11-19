package net.anatolich.testcontext.quote;

public interface QuoteCollector {
    void remember(Quote quote);

    String name();
}
