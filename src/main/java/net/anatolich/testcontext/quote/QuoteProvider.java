package net.anatolich.testcontext.quote;

public interface QuoteProvider {

    /**
     * Name of a quote provider.
     * @return name
     */
    String name();

    /**
     * Generates random quote.
     * @return random quote
     */
    Quote randomQuote();
}
