public class Lab {
    private Student[] students;
    private double gradesAverage;
    private String day;
    private int capacity;
    private int currentSize;

    /**
     * lab constructor
     * 
     * @param students
     * @param gradesAverage
     * @param day
     * @param capacity
     * @param currentSize
     */
    public Lab(String day, int capacity) {
        this.setDay(day);
        this.setCapacity(capacity);

        this.students = new Student[capacity];
        this.currentSize = 0;
        this.gradesAverage = 0;
    }

    /**
     * set lab capacity
     * 
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * get lab capacity
     * 
     * @return int
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * get lab class starting date
     * 
     * @return String
     */
    public String getDay() {
        return day;
    }

    /**
     * set lab class starting date
     * 
     * @param day
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * enroll student to class
     * 
     * @param student
     */
    public void enrollStudent(Student student) {
        if (this.currentSize < capacity) {
            this.students[currentSize] = student;
            this.currentSize++;
        } else {
            System.out.println("lab is full");
        }
    }

    /**
     * print all enrolled students data
     */
    public void print() {
        for (int index = 0; index < currentSize; index++) {
            Student iterationStudent = this.students[index];
            System.out.println("student id: " + iterationStudent.getId());
            System.out.println("student name is : " + iterationStudent.getFirstName());

            System.out.println("-----------------------------------------------------");
        }
        System.out.println("class average is " + this.gradesAverage);
    }

    /**
     * get all students
     */
    public void getStudents() {
        for (int index = 0; index < currentSize; index++) {
            Student iterationStudent = this.students[index];
            System.out.println("student id: " + iterationStudent.getId());
            System.out.println("student name is : " + iterationStudent.getFirstName());
            System.out.println("student last name is : " + iterationStudent.getLastName());
            System.out.println("student grade is : " + iterationStudent.getGrade());
        }
    }

    /**
     * get all enrolled students grade average
     * 
     * @return double
     */
    public double getAvg() {
        return this.gradesAverage;
    }

    /**
     * calculate enrolled students grade average
     */
    public void calculateGradesAverage() {
        double gradesSum = 0;

        for (int index = 0; index < currentSize; index++) {
            Student iterationStudent = this.students[index];
            gradesSum += iterationStudent.getGrade();
        }

        this.gradesAverage = gradesSum / this.currentSize;
    }
}
