package is2.ulpgc.kata2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CSVStudentDataLoader implements StudentDataLoader{

    private File file;

    private CSVStudentDataLoader(File file){
        this.file = file;
    }

    public static CSVStudentDataLoader create(String file){
        return new CSVStudentDataLoader(new File(file));
    }

    @Override
    public List<StudentData> load() {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            return load(br);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<StudentData> load(BufferedReader br) {
        return br.lines().skip(1L).map(this::StudentObject).collect(Collectors.toList());
    }

    private StudentData StudentObject(String line){
        double[] values = Arrays.stream(line.split(",")).mapToDouble(Double::parseDouble).toArray();
        return new StudentData(values);
    }

    private static TreeMap<Double, Integer> dataCount(List<Double> data) {
        TreeMap<Double, Integer> resumen = new TreeMap<>();
        data.forEach(i -> resumen.merge(i, 1, Integer::sum));
        return resumen;
    }

    public static TreeMap<Double, Integer> coursesCount(List<StudentData> data_raw) {
        List<Double> data = new ArrayList<>();
        data_raw.forEach(s -> data.add(s.getNumberCourses()));
        data.sort((i,j) -> {return (int)(i-j);});
        return dataCount(data);
    }

}
