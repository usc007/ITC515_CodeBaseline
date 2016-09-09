package datamanagement;

/*Interface IStudent
*/
public interface IStudent {
    
    public Integer getID();
    
    //settin and gettin firstname of student 
    public String getFirstName();
    public void setFirstName(String firstName);

    //settin and gettin firstname of student
    public String getLastName();
    public void setLastName(String lastName);
    
    //adding unit record of the student 
    public void addUnitRecord( IStudentUnitRecord record );
    public IStudentUnitRecord getUnitRecord( String unitCode );
    
    //get unit record list of student
    public StudentUnitRecordList getUnitRecords();

}
