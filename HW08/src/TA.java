public class TA extends UniversityMember {
    private Course[] coursesAssisting = new Course[2];

    public TA(String name, String id, String email) {
        super(name, id, email);
    }

    @Override
    public String getRole() {
        return "TA";
    }

    public void assignToCourse(Course course) {
        for (int i = 0; i < coursesAssisting.length; i++) {
            if (coursesAssisting[i] == null) {
                coursesAssisting[i] = course;
                break;
            }
        }
    }

    public Course[] getCoursesAssisting() {
        return coursesAssisting;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getName() + " (" + getEmail() + "). TA for Courses: ");
        for (Course c : coursesAssisting) {
            if (c != null) {
                sb.append(c.getCode()).append(", ");
            }
        }
        String result = sb.toString();
        return result.endsWith(", ") ? result.substring(0, result.length() - 2) : result;
    }
}
