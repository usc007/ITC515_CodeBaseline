package datamanagement;

/**
 *
 * @author Prakash
 */

/**
* 
* This class represents a unit.
*/

public class StudentUnitRecordProxy implements IStudentUnitRecord {

    private Integer studentID;
    private String unitCode;
    private StudentUnitRecordManager mngr;

    /**
     * Constructor of the StudentUnitRecordProxy class
     *
     * @param id           the id of a student
     * @param code         the unit code of a unit
     */       
    public StudentUnitRecordProxy(Integer id, String code) {
        this.studentID = id;
        this.unitCode = code;
        this.mngr = StudentUnitRecordManager.instance();
    }

    /**
    * getter method for id
    */        
    public Integer getStudentID() {
        return studentID;
    }

    /**
    * getter method for unit code
    */        
    public String getUnitCode() {
        return unitCode;
    }

    /**
    * setter method for assignment 1 mark
    */        
    public void setAsg1(float mark) {
        mngr.getStudentUnitRecord(studentID, unitCode).setAsg1(mark);
    }

    /**
    * getter method for assignment 1 mark
    */       
    public float getAsg1() {
        return mngr.getStudentUnitRecord(studentID, unitCode).getAsg1();
    }

    /**
    * setter method for assignment 2
    */      
    public void setAsg2(float mark) {
        mngr.getStudentUnitRecord(studentID, unitCode).setAsg2(mark);
    }

    /**
    * getter method for assignment 2 mark
    */       
    public float getAsg2() {
        return mngr.getStudentUnitRecord(studentID, unitCode).getAsg2();
    }

    /**
    * setter method for exam mark
    */      
    public void setExam(float mark) {
        mngr.getStudentUnitRecord(studentID, unitCode).setExam(mark);
    }

    /**
    * getter method for exam mark
    */       
    public float getExam() {
        return mngr.getStudentUnitRecord(studentID, unitCode).getExam();
    }

    /**
    * getter method for total mark
    */       
    public float getTotal() {
        return mngr.getStudentUnitRecord(studentID, unitCode).getTotal();
    }
}
