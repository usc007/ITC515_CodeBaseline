package datamanagement;

public class ListStudentsCTL {
        private StudentManager sm;
// Constructor of a ListStudentsCTL class        
public ListStudentsCTL() {
        sm = StudentManager.get();
        
}
    // List all student based on the chosen subject
public void listStudents( IStudentLister lister, String unitCode ) {
        
        lister.clearStudents(); //clear all students
        StudentMap students = sm.getStudentsByUnit( unitCode ); // create students map and call a getStudentsByUnit method based on unitcode of a student
        for (Integer id : students.keySet() ) lister.addStudent(students.get(id));
        
}
        
}
