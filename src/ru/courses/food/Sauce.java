package ru.courses.food;

public class Sauce {
    private String name;
    private Spiciness spiciness;
    public enum Spiciness {
        VERY_SPICY("очень острый"),
        SPICY("острый"),
        NOT_SPICY("не острый");

        private final String description;

        Spiciness(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return this.description;
        }

    }

    public Sauce(String name, Spiciness spiciness) {
        if (name == null || spiciness == null) {
            throw new IllegalArgumentException("Название и острота соуса должны быть указаны");
        }
        this.name = name;
        this.spiciness = spiciness;
    }

    public String toString() {
        return "Соус " + name + ": " + spiciness.toString();
    }

}
