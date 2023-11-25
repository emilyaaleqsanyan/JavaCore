package homework.fileAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileAnalyzerMain {
    public static void main(String[] args) throws IOException {

        // Map<String,Integer> myMap = new HashMap<>();


        String path = "C:\\Users\\Lenovo\\IdeaProjects\\JavaCore\\src\\homework\\fileUtil\\Text.txt";
        String word = "aram";
        int n = 4;
         //   System.out.println(FileAnalyzer.totalWordCount( path));


//        System.out.println(FileAnalyzer.countWordOccurrences(path,word));
//
//        System.out.println(FileAnalyzer.uniqueWordCount(path));





//            Map<String,Integer> myMap = FileAnalyzer.wordMap(path);
//            for (Map.Entry<String, Integer> stringIntegerEntry : myMap.entrySet()) {
//                System.out.println(stringIntegerEntry);
//            }



        try {
            Map<String,Integer> myMap = FileAnalyzer.topFrequentWords(path,n);
            System.out.println(myMap);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
   }
}
