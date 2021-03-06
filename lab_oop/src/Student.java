public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private int grade;

    /**
     * student constructor
     * 
     * @param firstName
     * @param lastName
     * @param id
     */
    public Student(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.grade = 0;
    }

    /**
     * get firstName of student
     * 
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get grade of student
     * 
     * @return int
     */
    public int getGrade() {
        return grade;
    }

    /**
     * set grade of a student
     * 
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * get id of student
     * 
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * set id of student
     * 
     * @param id
     * @exception Exception
     */
    public void setId(String id) {
        if (id.length() == 7) {
            this.id = id;
        }
    }

    /**
     * get lastName of student
     * 
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set lastName of student
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * set firstName for student
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void print() {
        System.out.println(this.lastName + ", student ID: " + this.id + ", grade: " + this.grade);
    }
}
