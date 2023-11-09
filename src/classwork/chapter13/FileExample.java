package classwork.chapter13;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
//        String directoryPath = "C:\\Users\\Lenovo\\IdeaProjects\\JavaCore\\src\\classwork\\chapter13";
//        String fileName = "FileExample.java";
//        String filePath = directoryPath + File.separator + fileName;
        String filePath = "C:\\Users\\Lenovo\\IdeaProjects\\JavaCore\\src\\classwork\\chapter13\\test";
        File file = new File(filePath);
        System.out.println(file.exists());

        if(file.isDirectory()){
            String[] list = file.list();
            for (String name : list) {
                System.out.println(name);
            }
        }
    }
}
