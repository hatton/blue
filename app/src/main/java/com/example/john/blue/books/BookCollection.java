package com.example.john.blue.books;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookCollection {

    private  List<Book> _books = new ArrayList<Book>();
    public  final Map<String, Book> ID_TO_BOOK_MAP = new HashMap<String, Book>();

    public Book get(int i) {
        return _books.get(i);
    }

    public int size() {
        return _books.size();
    }

    private  void addItem(Book item) {
        _books.add(item);
        ID_TO_BOOK_MAP.put(item.id, item);
    }

    private  Book createDummyBook(Context context, int position) {
        String path = setupFiles(context, position);
        return new Book(String.valueOf(position), "The three Dwarves, volume " + position, makeDetails(position), path);
    }

    private  String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Once upon a time... ").append(position);
        return builder.toString();
    }

    public void init(Context context) {
        for (int i = 1; i <= 5; i++) {
            addItem(createDummyBook(context, i));
        }
    }

    private String setupFiles(Context context, int position) {
        ContextWrapper cw = new ContextWrapper(context);
        File directory = cw.getDir("bloomreader", Context.MODE_PRIVATE);

        File file = new File(directory, position + ".htm");
        if(file.exists()) {
            file.delete();
        }

        try {
            FileWriter out = new FileWriter(file);
            out.write("<html><body>Story " + position + "</body></html>");
            out.close();
        } catch (IOException e) {
            showError(context, e.getMessage());
        }
        return file.getAbsolutePath();
    }


    private void showError(Context context, CharSequence message) {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
