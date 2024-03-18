from question4 import Professor, Student, TA, Course


if __name__ == '__main__':
    cse_30332 = Course("Programming Paradigms", "CSE-30332")

    prof_santos = Professor('CSE', "Joanna Cecilia da Silva Santos", "jdasilv2", "jdasilv2@nd.edu")

    ta_1 = TA("Ningzhi Tang", "ntang", "ntang@nd.edu", [cse_30332])
    ta_2 = TA("Robert Wallace", "rwallac1", "rwallac1@nd.edu", [cse_30332])
    ta_3 = TA("Christian Northrup", "cnorthr2", "cnorthr2@nd.edu", [cse_30332])
    ta_4 = TA("Tara Flannery", "tflanne2", "tflanne2@nd.edu", [cse_30332])
    ta_5 = TA("Daniel Shield", "dshield2", "dshield2@nd.edu", [cse_30332])

    stud_1 = Student("Computer Science", "Rex Stayer-Suprick", "rstayers", "rstayers@nd.edu")
    stud_2 = Student("Computer Science", "Kyle Conners", "kconner3", "kconner3@nd.edu")
    stud_3 = Student("Computer Science", "Jai Krishnan", "jkrishna", "jkrishna@nd.edu")

    cse_30332.add_student(stud_1)
    cse_30332.add_student(stud_2)
    cse_30332.add_student(stud_3)
    cse_30332.add_instructor(prof_santos)


