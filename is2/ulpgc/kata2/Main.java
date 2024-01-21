package is2.ulpgc.kata2;

import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        List<StudentData> students = CSVStudentDataLoader.create("is2/ulpgc/kata2/datos.csv").load();

        TreeMap<Double, Integer> courses = CSVStudentDataLoader.coursesCount(students);
        for(Double key: courses.keySet()){
            System.out.println(key + " : " + courses.get(key));
        }
    }
}
