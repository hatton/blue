package com.example.john.blue.bookCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookCollection {


    public static final List<Book> BOOKS = new ArrayList<Book>();
    public static final Map<String, Book> ID_TO_BOOK_MAP = new HashMap<String, Book>();
    private static final int COUNT = 25;

    static {
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyBook(i));
        }
    }

    private static void addItem(Book item) {
        BOOKS.add(item);
        ID_TO_BOOK_MAP.put(item.id, item);
    }

    private static Book createDummyBook(int position) {
        return new Book(String.valueOf(position), "The three Dwarves, volume " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Once upon a time... ").append(position);
        return builder.toString();
    }

    public static class Book {
        public final String id;
        public final String content;
        public final String details;

        public Book(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
