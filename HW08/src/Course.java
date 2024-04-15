public class Course {
    private String name;
    private String code;
    private Student[] enrolledStudents = new Student[50];
    private Professor instructor;

    public Course(String name, String code, Professor instructor) {
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        this.enrolledStudents = new Student[50];
    }

    public void addStudent(Student student) {
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null) {
                enrolledStudents[i] = student;
                break;
            }
        }
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i].equals(student)) {
                enrolledStudents[i] = null;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public Professor getInstructor() {
        return instructor;
    }

    public Student[] getEnrolledStudents() {
        return enrolledStudents;
    }
}
