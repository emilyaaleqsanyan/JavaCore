package homework.fileUtil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        fileSearch();
        contentSearch();
        printSizeOfPackage();
        createFileWithContent();
        findLines();

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        System.out.println("Please input PATH");
        String path = scanner.nextLine();
        System.out.println("please input FILE_NAME ");
        String fileName = scanner.nextLine();
        String filePath = path + File.separator + fileName;
        File file = new File(filePath);
        System.out.println(file.exists());

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() {
        System.out.println("Please input PATH");
        String path = scanner.nextLine();
        System.out.println("Please input KEYWORD");
        String keyword = scanner.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (File f : list) {
                try (BufferedReader br = new BufferedReader((new FileReader(f.getAbsolutePath())))) {
                    if (br.readLine().contains(keyword)) {
                        System.out.println(f.getName());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }


    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        System.out.println("Please input FILE_PATH");
        String txtPath = scanner.nextLine();
        System.out.println("Please input KEYWORD");
        String keyword = scanner.nextLine();
        File file = new File(txtPath);
        if (file.isFile()) {
            String str;
            try (BufferedReader br = new BufferedReader((new FileReader(txtPath)))) {
                str = br.readLine();
                if (str.contains(keyword)) {
                    System.out.println(str);
                }
            } catch ( IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        long size = 0;
        System.out.println("Please input PATH");
        String path = scanner.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (File f : list) {
                size += f.length();
            }
            System.out.println("Package size: " + size);
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        System.out.println("Pleas input PATH");
        String directoryPath = scanner.nextLine();
        System.out.println("Please input FILE_NAME");
        String fileName = scanner.nextLine();
        System.out.println("Please input FILE_CONTENT");
        String content = scanner.nextLine();
        String filePath = directoryPath + File.separator + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                bw.write(content);
                System.out.println("File created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Can not create file.");
        }

    }

}
