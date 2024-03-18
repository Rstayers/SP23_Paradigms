from abc import ABC, abstractmethod


class UniversityMember(ABC):
    def __init__(self, name, member_id, email):
        self.name = name
        self.member_id = member_id
        self.email = email

    @abstractmethod
    def get_role(self):
        pass


class Student(UniversityMember):
    def __init__(self, major, name, member_id, email):
        super().__init__(name, member_id, email)
        self.major = major

    def get_role(self):
        return "Student"

    def __str__(self):
        return f'{self.name} ({self.email}) - Major: {self.major}'


class Professor(UniversityMember):
    def __init__(self, department, name, member_id, email):
        super().__init__(name, member_id, email)
        self.department = department

    def get_role(self):
        return "Professor"

    def __str__(self):
        return f'Prof. {self.name.split()[-1]} ({self.email})'


class TA(UniversityMember):

    def __init__(self, name, member_id, email, courses_assisting=[]):
        super().__init__(name, member_id, email)
        self.courses_assisting = courses_assisting

    def get_role(self):
        return "Professor"

    def assign_to_course(self, course):
        self.courses_assisting.append(course)

    def __str__(self):
        codes = [x for x in self.courses_assisting]
        return f"{self.name} ({self.email}). TA for Courses: {', '.join(codes.code for codes in self.courses_assisting)}."


class Course:
    def __init__(self, name, code, enrolled_students=[], instructor=[]):
        self.name = name
        self.code = code
        self.enrolled_students = enrolled_students
        self.instructor = instructor

    def add_student(self, student):
        self.enrolled_students.append(student)

    def remove_student(self, target):
        for index, student in enumerate(self.enrolled_students):
            if student.member_id == target.member_id:
                del self.enrolled_students[index]
                break

    def add_instructor(self, instructor):
        self.instructor.append(instructor)

    def remove_instructor(self, target):
        for index, instructor in enumerate(self.instructor):
            if instructor.member_id == target.member_id:
                del self.instructor[index]
                break
