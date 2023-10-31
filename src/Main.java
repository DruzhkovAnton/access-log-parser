import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pointe pointe1 = new Pointe(1,3);
        Pointe pointe2 = new Pointe(1,3);
        Pointe pointe3 = new Pointe(5,8);
        pointe1.toSring();
        pointe2.toSring();
        pointe3.toSring();
        Pointe.poitEquals(pointe1,pointe2,pointe3);
    }
}