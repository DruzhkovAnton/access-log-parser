import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 0;
        do{
            System.out.println("Введите путь к файлу и нажмите enter:");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            if (file.exists() && file.isFile()){
                i++;
                System.out.println(path + " - Путь указан верно "+i+" раз");
                continue;
            }if (file.isDirectory()){
                System.out.println(path + " - не является путем к файлу, это папка, укажите полный путь к файлу");
            }else {
                System.out.println(path + " - не является путем к файлу или папке");
            }
        }while (1==1);
    }
}