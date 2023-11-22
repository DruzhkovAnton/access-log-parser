package ru.courses.main;
import ru.courses.food.Sauce;

public class Main {
    public static void main(String[] args) {
        Sauce sauce = new Sauce("Табаско", Sauce.Spiciness.SPICY);
        System.out.println(sauce);
    }
}