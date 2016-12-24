package com.example.john.blue.bookCollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        String path = "1";
        return new Book(String.valueOf(position), "The three Dwarves, volume " + position, makeDetails(position), path);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Once upon a time... ").append(position);
        return builder.toString();
    }

    public static class Book {
        public final String id;
        public final String path;
        public final String content;
        public final String details;

        public Book(String id, String content, String details, String path) {
            this.id = id;
            this.path = path;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }

//        public static String convertStreamToString(InputStream is) throws IOException {
//            // http://www.java2s.com/Code/Java/File-Input-Output/ConvertInputStreamtoString.htm
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            Boolean firstLine = true;
//            while ((line = reader.readLine()) != null) {
//                if(firstLine){
//                    sb.append(line);
//                    firstLine = false;
//                } else {
//                    sb.append("\n").append(line);
//                }
//            }
//            reader.close();
//            return sb.toString();
//        }
//
//        private static String getStringFromFile (String filePath) throws IOException {
//            File fl = new File(filePath);
//            FileInputStream fin = new FileInputStream(fl);
//            String ret = convertStreamToString(fin);
//            //Make sure you close all streams.
//            fin.close();
//            return ret;
//        }
    }
}
