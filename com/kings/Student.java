package com.kings;


class Student {
    public String name;
    String studentID;
    int age;
    
    public Student(String name, String studentID, int age) {
        this.name = name;
        this.studentID = studentID;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public int getAge() {
        return age;
    }
    
    public String toString() {
        return "Name: " + name + ", ID: " + studentID + ", Age: " + age;
    }
    
}
