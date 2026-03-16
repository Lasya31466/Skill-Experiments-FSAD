package com.klu;
public class Student 
{
	Course course;
	
 int studentId;
    String name;
    int year;
    String email;
     String phoneNumber;

     public Student()
     {
    	 
     }
     
     public Student(int studentId, String name, int year) 
    {
        this.studentId = studentId;
        this.name = name;
        this.year = year;
    }
   
    public Course getCourse() {
		return course;
	}

	 public void setCourse(Course course) {
		 this.course = course;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getPhoneNumber() {
		 return phoneNumber;
	 }

	 public void setPhoneNumber(String phoneNumber) {
		 this.phoneNumber = phoneNumber;
	 }

	public void display() {
        System.out.println("Student ID      : " + studentId);
        System.out.println("Student Name    : " + name);
        System.out.println("Academic Year   : " + year);
        System.out.println("Email           : " + email);
        System.out.println("Phone Number    : " + phoneNumber);
        System.out.println("Course          : " + course.getCourseName() +" (" +course.getDuration()+" months)");
    }
}
