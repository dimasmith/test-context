package net.anatolich.testcontext.fortune;

import net.anatolich.testcontext.ApplicationTests;
import net.anatolich.testcontext.quote.QuoteProvider;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FortuneQuoteTest extends ApplicationTests {

    @Autowired
    private QuoteProvider quotes;

    @Test
    public void fortuneQuoteProvider() {
        assertThat(quotes.name(), Matchers.equalTo(FortuneQuotes.NAME));
    }
}
