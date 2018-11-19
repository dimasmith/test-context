Test Configuration Example
==========================

Example of how to split Spring configurations between tests
without interference.

## Application

It's a restful webapp that provides a "random" quote once
[endpoint](http://localhost:8080/v1/quotes) is called.

E.g.

```bash
curl http://localhost:8080/v1/quotes
```

Main classes:

- `QuoteProvider` object that generates random quote;
- `QuoteCollector` objects that keep track of all showed quotes;
- `QuoteController` REST endpoint to show quotes;

An application has default implementation of `QuoteProvider` - 
`FortuneQuoteProvider`. Default implementation of a 
`QuoteCollector` is `LoggingQuoteCollector`.

`LoggingQuoteCollector` just sends a showed quote to log.

The goal of tests is to replace some beans and isolate those
replacement in a single test.

### Chuck Quote Test

This test uses custom quote provider `ChuckQuoteProvider`.
It also uses default QuoteCollector. No collection is checked.

Custom provider is configured in a nested `@Configuration`
class. This class is imported via `@Import` annotation.

### Adams Quote Test

It also has a custom QuoteProvider and uses test QuoteCollector.
Test QuoteCollector (`CollectionQuoteCollector`) allows to 
check collected quotes.

Custom provider is once again injected using imported 
internal @Configuration class. Instances are checked to 
show that custom configuration is applied and that other custom
configurations do not interfere with this one.
`CollectingQuoteCollector` is injected by importing `TestSetup`
configuration. It's necessary to annotate `TestSetup` class
with `@TestConfiguration` instead of `@Configuration` because
@Configuration will be used by all tests. That will cause 
`ChuckQuoteTest` to fail.

### Fortune Quote Test

`FortuneQuoteTest` uses a default QuoteProvider 
(`FortuneQuoteProvider`) to generate quotes. 
Test overrides a QuoteCollector with test instance by 
importing shared `TestSetup` configuration.

## Things to check

- [ ] Check if test in same package as test with custom configuration 
will be affected

