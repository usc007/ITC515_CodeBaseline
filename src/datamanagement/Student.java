package datamanagement;

public class Student implements IStudent {
    //id = Studenr ID
    private Integer id;
    //fn = first name
    private String fn;
    //ln = last name
    private String ln;
    //su = student unit record list
    private StudentUnitRecordList su;

/**
   * @param id the id of a student
   * @param fn the first name of a student
   * @param ln the last name of a student
   * @param su the unit record list of a student
*/
public Student( Integer id, String fn, String ln, StudentUnitRecordList su ) {
    this.id = id; 
    this.fn = fn;
    this.ln = ln;
    this.su = su == null ? new StudentUnitRecordList() : su;
}

//get method for id of a student
public Integer getID() {
    return this.id; 
} 
//get method for first name of a student
public String getFirstName() { 
    return fn; 
}
//set method for first name of a student
public void setFirstName( String firstName ) { 
    this.fn = firstName; 
}
//get method for last name of a student
public String getLastName() { 
    return ln; 
}
//set method for last name of student
public void setLastName( String lastName ) { 
this.ln = lastName; 
}
//add method for unit record of a student
public void addUnitRecord( IStudentUnitRecord record ) {
    su.add(record); 
}
//get method unit record of a student
public IStudentUnitRecord getUnitRecord( String unitCode ) {
    for ( IStudentUnitRecord r : su ) 
        if ( r.getUnitCode().equals(unitCode)) 
        return r; 
        return null;
}
//get method for unit record list of a student
public StudentUnitRecordList getUnitRecords() { 
    return su; 
}
}
