package com.example.john.blue.books;

public class Book {
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