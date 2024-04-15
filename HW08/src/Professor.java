public class Professor extends UniversityMember {
    private String department;

    public Professor(String name, String id, String email, String department) {
        super(name, id, email);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        String lastName = getName().substring(getName().lastIndexOf(' ') + 1);
        return "Prof. " + lastName + " (" + getEmail() + ")";
    }
}
