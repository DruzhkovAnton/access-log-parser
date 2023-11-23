import java.io.*;
import java.util.Scanner;

import static ru.courses.parser.ParserLog.parse;

// C:\Users\admin\Downloads\access.log
public class Main {
    public static void main(String[] args) throws IOException {
        do {
            System.out.println("Введите путь к файлу и нажмите enter:");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            if (file.exists() && file.isFile()){
                System.out.println(path + " - Путь указан верно");
                parse(path);
                continue;
            }if (file.isDirectory()){
                System.out.println(path + " - не является путем к файлу, это папка, укажите полный путь к файлу");
            }else {
                System.out.println(path + " - не является путем к файлу или папке");
            }
        } while (1 == 1);
    }

}