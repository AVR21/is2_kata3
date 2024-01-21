package is2.ulpgc.kata2;

public class StudentData {
    private double numberCourses;
    private double timeStudy;
    private double marks;

    public StudentData(double[] data) {
        this.numberCourses = data[0];
        this.timeStudy = data[1];
        this.marks = data[2];
    }

    @Override
    public String toString() {
        return "is2.ulpgc.StudentData{" +
                "numberCourses=" + numberCourses +
                ", timeStudy=" + timeStudy +
                ", marks=" + marks +
                '}';
    }

    public double getNumberCourses() {
        return numberCourses;
    }

    public void setNumberCourses(double numberCourses) {
        this.numberCourses = numberCourses;
    }

    public double getTimeStudy() {
        return timeStudy;
    }

    public void setTimeStudy(double timeStudy) {
        this.timeStudy = timeStudy;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}