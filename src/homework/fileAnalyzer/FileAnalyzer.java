package homework.fileAnalyzer;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.*;

public class FileAnalyzer {

    public static Map<String, Integer> wordMap(String path) throws IOException {
        // Читаем файл, составляем мапу слово-количество и возвращаем ее
        File file = new File(path);
        if (!file.isFile()) {
            return Map.of();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            Map<String, Integer> myMap = new HashMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(" ");
                for (int i = 0; i < str.length; i++) {
                    if (!myMap.containsKey(str[i])) {
                        myMap.put(str[i], 1);
                    } else {
                        Integer val = myMap.get(str[i]);
                        myMap.put(str[i], ++val);
                    }
                }
            }
            return myMap;
        }
    }


    public static int totalWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем общее количество слов
        File file = new File(path);
        String[] str;
        int count = 0;
        if (file.isFile()) {
            try (BufferedReader br = new BufferedReader((new FileReader(file)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    str = line.split(" ");
                    count += str.length;
                }
                return count;
            }
        }
        return 0;
    }


    public static int uniqueWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем количество уникальных слов
        Set<String> mySet = new HashSet<>();
        String[] str;
        File file = new File(path);
        if (file.isFile()) {
            try (BufferedReader br = new BufferedReader((new FileReader(file)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    str = line.split(" ");
                    for (int i = 0; i < str.length; i++) {
                        String st = str[i];
                        mySet.add(st);
                    }
                }
                return mySet.size();

            }

        }
        return 0;
    }


    public static Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        // Читаем файл, находим топ-N часто встречающихся слов
        File file = new File(path);
        if (file.isFile()) {
            try (BufferedReader br = new BufferedReader((new FileReader(file)))) {
                Map<String, Integer> myMap = new TreeMap<>();
                String line;
                while ((line = br.readLine()) != null) {
                    String[] str = line.split(" ");
                    for (int i = 0; i < str.length; i++) {
                        if (!myMap.containsKey(str[i])) {
                            myMap.put(str[i], 1);
                        } else {
                            Integer val = myMap.get(str[i]);
                            myMap.put(str[i], ++val);
                        }


                    }return myMap;
                }
            }
        }return new TreeMap<>();
    }




    public static int countWordOccurrences(String path, String word) throws IOException {
        // Читаем файл, находим количество вхождений слова и возвращаем это число
        File file = new File(path);
        String[] str;
        int count = 0;
        if (file.isFile()) {
            try (BufferedReader br = new BufferedReader((new FileReader(file)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    str = line.split(" ");
                    for (int i = 0; i < str.length; i++) {
                        if (str[i].equals(word)) {
                            count++;
                        }
                    }
                }
                return count;
            }
        }
        return 0;
    }
}

