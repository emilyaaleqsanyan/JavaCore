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
        int n = 2;
        //   System.out.println(FileAnalyzer.totalWordCount( path));


//        System.out.println(FileAnalyzer.countWordOccurrences(path,word));
//
//        System.out.println(FileAnalyzer.uniqueWordCount(path));


//            Map<String,Integer> myMap = FileAnalyzer.wordMap(path);
//            for (Map.Entry<String, Integer> stringIntegerEntry : myMap.entrySet()) {
//                System.out.println(stringIntegerEntry);
//            }


        Map<String, Integer> myMap = FileAnalyzer.topFrequentWords(path, n);
        for (Map.Entry<String, Integer> stringIntegerEntry : myMap.entrySet()) {
            System.out.println(stringIntegerEntry);
        }

    }
}
