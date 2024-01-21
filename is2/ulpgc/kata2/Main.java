package is2.ulpgc.kata2;

import is2.ulpgc.kata3.*;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        List<StudentData> students = CSVStudentDataLoader.create("is2/ulpgc/kata2/datos.csv").load();

        TreeMap<Double, Integer> courses = CSVStudentDataLoader.coursesCount(students);
        for(Double key: courses.keySet()){
            System.out.println(key + " : " + courses.get(key));
        }

        MainJFrame main = new MainJFrame();
        double[] values = courses.values().stream().mapToDouble(Integer::doubleValue).toArray();
        main.histogramWindow().show(hist(values));
        main.setVisible(true);

    }

    private static Histogram hist(double[] values) {
        Histogram histogram = new Histogram() {
            @Override
            public int bins() {
                return 6;
            }

            @Override
            public double[] values() {
                return values;
            }
        };
        return histogram;
    }
}
