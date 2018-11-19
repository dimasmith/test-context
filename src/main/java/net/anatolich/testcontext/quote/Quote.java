package net.anatolich.testcontext.quote;

import java.util.StringJoiner;

public class Quote {
    private final String text;
    private final String author;

    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Quote.class.getSimpleName() + "[", "]")
                .add("text='" + text + "'")
                .add("author='" + author + "'")
                .toString();
    }
}
