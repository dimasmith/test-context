package net.anatolich.testcontext.adams;


import net.anatolich.testcontext.Application;
import net.anatolich.testcontext.feature.FeatureTest;
import net.anatolich.testcontext.fortune.FortuneQuotes;
import net.anatolich.testcontext.quote.QuoteProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Ensure that nested configuration in the same package class
 * ({@link AdamsQuoteTest} does not affect this test.
 *
 * AdamsQuoteTest configures {@link AdamsQuoteProvider} as a QuoteProvider.
 * This class is expected to have {@link FortuneQuotes} as a Provider.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DefaultQuoteTest extends FeatureTest {

    @Autowired
    private QuoteProvider quoteProvider;

    @Test
    public void ensureDefaultQuoteProvider() {
        assertThat(quoteProvider.name(), equalTo(FortuneQuotes.NAME));
    }
}
