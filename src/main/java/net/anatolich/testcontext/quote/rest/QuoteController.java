package net.anatolich.testcontext.quote.rest;

import net.anatolich.testcontext.quote.Quote;
import net.anatolich.testcontext.quote.QuoteProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/quotes")
public class QuoteController {

    private final QuoteProvider quoteProvider;

    public QuoteController(QuoteProvider quoteProvider) {
        this.quoteProvider = quoteProvider;
    }

    @GetMapping
    public Quote getRandomQuote() {
        return quoteProvider.randomQuote();
    }
}

