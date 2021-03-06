public class App {
    /**
     * main entry point of the program
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Throwable {
        Student student1 = new Student("sina", "shariait", "9931072");
        student1.setGrade(20);

        Student student2 = new Student("bardia", "ardakanian", "9831072");
        student2.setGrade(18);

        Student student3 = new Student("john", "Doe", "9931058");
        student3.setGrade(19);

        Lab lab = new Lab("shanbe 8:00Am", 50);
        lab.enrollStudent(student1);
        lab.enrollStudent(student2);
        lab.enrollStudent(student3);

        lab.calculateGradesAverage();
        lab.print();
    }

}
