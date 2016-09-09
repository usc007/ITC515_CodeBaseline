package datamanagement;

/**
Interface for StudentLister which will implement two  method
**/

public interface IStudentLister 
    {
    // clear the  student
	public void clearStudents();
    //add new student
    public void addStudent(IStudent student);
    }

