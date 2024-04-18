public class Main {
    public static void main(String[] args) {

        Professor prof_santos = new Professor("Joanna Cecilia da Silva Santos", "jdasilv2", "jdasilv2@nd.edu", "CSE");
        Course cse_30332 = new Course("Programming Paradigms", "CSE-30332", prof_santos);

        TA ta_1 = new TA("Ningzhi Tang", "ntang", "ntang@nd.edu");
        TA ta_2 = new TA("Robert Wallace", "rwallac1", "rwallac1@nd.edu");
        TA ta_3 = new TA("Christian Northrup", "cnorthr2", "cnorthr2@nd.edu");
        TA ta_4 = new TA("Tara Flannery", "tflanne2", "tflanne2@nd.edu");
        TA ta_5 = new TA("Daniel Shield", "dshield2", "dshield2@nd.edu");
        ta_1.assignToCourse(cse_30332);

        Student stud_1 = new Student("Computer Science", "Rex Stayer-Suprick", "rstayers", "rstayers@nd.edu");
        Student stud_2 = new Student("Computer Science", "Kyle Conners", "kconner3", "kconner3@nd.edu");
        Student stud_3 = new Student("Computer Science", "Jai Krishnan", "jkrishna", "jkrishna@nd.edu");

        cse_30332.addStudent(stud_1);
        cse_30332.addStudent(stud_2);
        cse_30332.addStudent(stud_3);

    }
}