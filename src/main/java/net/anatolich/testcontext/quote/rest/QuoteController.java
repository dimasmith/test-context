package net.anatolich.testcontext.quote.rest;

import net.anatolich.testcontext.quote.Quote;
import net.anatolich.testcontext.quote.QuoteCollector;
import net.anatolich.testcontext.quote.QuoteProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/quotes")
public class QuoteController {

    private final QuoteProvider quoteProvider;
    private final QuoteCollector quoteCollector;

    public QuoteController(QuoteProvider quoteProvider, QuoteCollector quoteCollector) {
        this.quoteProvider = quoteProvider;
        this.quoteCollector = quoteCollector;
    }

    @GetMapping
    public Quote getRandomQuote() {
        final Quote quote = quoteProvider.randomQuote();
        quoteCollector.remember(quote);
        return quote;
    }
}
