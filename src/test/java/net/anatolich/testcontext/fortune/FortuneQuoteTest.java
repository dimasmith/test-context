package net.anatolich.testcontext.fortune;

import net.anatolich.testcontext.FeatureTest;
import net.anatolich.testcontext.collector.CollectionQuoteCollector;
import net.anatolich.testcontext.collector.QuoteCollectorInspector;
import net.anatolich.testcontext.collector.TestSetup;
import net.anatolich.testcontext.quote.Quote;
import net.anatolich.testcontext.quote.QuoteCollector;
import net.anatolich.testcontext.quote.QuoteProvider;
import net.anatolich.testcontext.quote.QuoteRestClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@Import(TestSetup.class)
public class FortuneQuoteTest extends FeatureTest {

    @Autowired
    private QuoteProvider quotes;
    @Autowired
    private QuoteCollector quoteCollector;
    @Autowired
    private QuoteCollectorInspector collectorInspector;
    @Autowired
    private QuoteRestClient quoteRestClient;

    @Before
    public void resetHelpers() {
        collectorInspector.clear();
    }

    @Test
    public void fortuneQuoteProvider() {
        assertThat(quotes.name(), equalTo(FortuneQuotes.NAME));
    }

    @Test
    public void testQuoteCollector() {
        assertThat(quoteCollector.name(), equalTo(CollectionQuoteCollector.NAME));
    }

    @Test
    public void quoteCollected() throws Exception {
        quoteRestClient.getRandomQuote();

        final List<Quote> collectedQuotes = collectorInspector.quotes();
        assertThat(collectedQuotes, not(empty()));
    }
}
