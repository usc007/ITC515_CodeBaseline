package datamanagement;
/**
 *
 * @author KishanTamang
 */
public class StudentProxy implements IStudent {
    private Integer id;
    private String firstname;
    private String lastname;
    private StudentManager studentmanager;

    /**
     * Constructor of a StudentProxy class
     * @param id the id of a student
     * @param fn the first name of a student
     * @param ln the last name of a student
     */
public StudentProxy( Integer id, String fn, String ln) {
        this.id = id;
        this.firstname = fn;
        this.lastname = ln;
        this.studentmanager = StudentManager.get();
    
}
// get method for ID of a student
public Integer getID() {
    return id; 
}
// get method for first name
public String getFirstName() { 
    return firstname; 
    
}
//get method for last name
public String getLastName() { 
    return lastname; 
}
/**
* Set method for first name  
* 
* @param firstName the first name of a student
*/  
public void setFirstName(String firstName) {
    studentmanager.getStudent(id).setFirstName(firstName);
    
}
/**
* Set method for last name  
* 
* @param lastName the last name of a student
*/  
public void setLastName(String lastName) {
    studentmanager.getStudent(id).setLastName(lastName);
    
}
/**
* addUnitRecord add unit record to a student
* 
* @param record the record of a student
*/  
public void addUnitRecord(IStudentUnitRecord record) {
    studentmanager.getStudent(id).addUnitRecord(record);
    
}
/**
 * get unit record from a student
 * @param unitCode the unitCode of a student
*/
public IStudentUnitRecord getUnitRecord(String unitCode) {
    return studentmanager.getStudent(id).getUnitRecord(unitCode);
    
}
//get all unit records from a student
public StudentUnitRecordList getUnitRecords() {
    return studentmanager.getStudent(id).getUnitRecords();
    
}
    
}
