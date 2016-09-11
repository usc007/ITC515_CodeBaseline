package datamanagement;

/**
 *
 * @author Prakash
 */

public class UnitProxy implements IUnit {

    private String unitCode;
    private String unitName;
    UnitManager unitManager;

    /**
     * Constructor of the Student class
     *
     * @param unitCode           the unit code of a unit
     * @param unitName           the unit name of a unit
     */       
    public UnitProxy(String unitCode, String unitName) {
        this.unitCode = unitCode;
        this.unitName = unitName;
        unitManager = UnitManager.UM();
    }

    /**
    * getter method for unit code
    */        
    public String getUnitCode() {
        return this.unitCode;
    }

    /**
    * getter method for unit name
    */        
    public String getUnitName() {
        return this.unitName;
    }

    /**
    * setter method for pass cut off point
    */       
    public void setPsCutoff1(float cutoff) {
        unitManager.getUnit(unitCode).setPsCutoff1(cutoff);
    }

    /**
    * getter method for pass cut off point
    */       
    public float getPsCutoff() {
        return unitManager.getUnit(unitCode).getPsCutoff();
    }

    /**
    * setter method for credit cut off point
    */       
    public void setCrCutoff(float cutoff) {
        unitManager.getUnit(unitCode).setCrCutoff(cutoff);
    }

    /**
    * getter method for credit cut off point
    */       
    public float getCrCutoff() {
        return unitManager.getUnit(unitCode).getCrCutoff();
    }

    /**
    * setter method for distinction cut off point
    */       
    public void setDiCutoff(float cutoff) {
        unitManager.getUnit(unitCode).setDiCutoff(cutoff);
    }

    /**
    * getter method for distinction cut off point
    */       
    public float getDiCuttoff() {
        return unitManager.getUnit(unitCode).getDiCuttoff();
    }

    /**
    * setter method for high distinction cut off point
    */       
    public void setHdCutoff(float cutoff) {
        unitManager.getUnit(unitCode).setHdCutoff(cutoff);
    }

    /**
    * getter method for high distinction cut off point
    */       
    public float getHdCutoff() {

        return unitManager.getUnit(unitCode).getHdCutoff();
    }

    /**
    * setter method for additional exam cut off point
    */       
    public void setAeCutoff(float cutoff) {
        unitManager.getUnit(unitCode).setAeCutoff(cutoff);
    }

    /**
    * getter method for additional exam cut off point
    */       
    public float getAeCutoff() {
        return unitManager.getUnit(unitCode).getAeCutoff();
    }

    /**
    * get the grade of a unit
    * 
    * @param a1 assignment 1 mark
    * @param a2 assignment 2 mark
    * @param ex exam mark
    */       
    public String getGrade(float a1, float a2, float ex) {
        return unitManager.getUnit(unitCode).getGrade(a1, a2, ex);
    }

    /**
    * add a student record
    * 
    * @param record a student unit record
    */       
    public void addStudentRecord(IStudentUnitRecord record) {
        unitManager.getUnit(unitCode).addStudentRecord(record);
    }

    /**
    * getter method for student record
    */       
    public IStudentUnitRecord getStudentRecord(int s) {
        return unitManager.getUnit(unitCode).getStudentRecord(s);
    }

    /**
    * get all student records
    */       
    public StudentUnitRecordList listStudentRecords() {
        return unitManager.getUnit(unitCode).listStudentRecords();
    }

    /**
    * getter method for assignment 1 weight
    */       
    public int getAsg1Weight() {
        return unitManager.getUnit(unitCode).getAsg1Weight();
    }

    /**
    * getter method for assignment 2 weight
    */         
    public int getAsg2Weight() {
        return unitManager.getUnit(unitCode).getAsg2Weight();
    }

    /**
    * getter method for exam weight
    */         
    public int getExamWeight() {
        return unitManager.getUnit(unitCode).getExamWeight();
    }

    /**
    * set assessment weights
    * 
    * @param asg1Wgt assignment 1 weight
    * @param asg2Wgt assignment 2 weight
    * @param examWgt exam weight
    */         
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt) {
        unitManager.getUnit(unitCode).setAssessmentWeights(asg1Wgt, asg2Wgt, examWgt);
    }
}
