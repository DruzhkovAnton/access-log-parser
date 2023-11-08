import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    List<Integer> grades = new ArrayList<>();

    public List<Integer> getGrades() {
        return grades;
    }

    public Student(String name, List<Integer> grades) {
        grades.forEach(j -> {
            checkGrades(j);
        });
        this.name = name;

    }

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String toString() {
        return name + grades.toString();
    }

    public void addGrades(int x) {
        checkGrades(x);
    }

    private void checkGrades(int x) {
        if (x >= 2 && x <= 5) {
            grades.add(x);
        }
    }
}
