package datamanagement;

/**
 *
 * @author Prakash
 */

/**
* 
* This class represents a unit.
*/
public class Unit implements IUnit {

    private String unitCode;
    private String unitName;
    private float passCutOffPoint;
    private float creditCutOffPoint;
    private float distinctionCutOffPoint;
    private float highDistinctionCutOffPoint;
    private float additionalExamCutOffPoint;
    private int assignment1Weight, assignment2Weight, examWeight;
    private StudentUnitRecordList recordList;

    /**
     * Constructor of the Student class
     *
     * @param unitCode           the unit code of a unit
     * @param unitName           the unit name of a unit
     * @param pass               cut off point for pass
     * @param credit             cut off point for credit
     * @param distinction        cut off point for distinction
     * @param highDistinction     cut off point for high distinction
     * @param additionalExam     cut off point for additional exam
     * @param assignment1Weight  assignment 1 weight
     * @param assignment2Weight  assignment 2 weight
     * @param examWeight         exam weight
     * @param rl                 student record list
     */    
    public Unit(String unitCode, String unitName, float pass, float credit, float distinction, 
            float highDistinction, float additionalExam, 
            int assignment1Weight, int assignment2Weight, int examWeight, StudentUnitRecordList rl) {

        this.unitCode = unitCode;
        this.unitName = unitName;
        this.passCutOffPoint = pass;
        this.creditCutOffPoint = credit;
        this.distinctionCutOffPoint = distinction;
        this.highDistinctionCutOffPoint = highDistinction;
        this.additionalExamCutOffPoint = additionalExam;
        this.setAssessmentWeights(assignment1Weight, assignment2Weight, examWeight);
        this.recordList = rl == null ? new StudentUnitRecordList() : rl;
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
        this.passCutOffPoint = cutoff;
    }

    /**
    * getter method for pass cut off point
    */    
    public float getPsCutoff() {
        return this.passCutOffPoint;
    }

    /**
    * setter method for credit cut off point
    */        
    public void setCrCutoff(float cutoff) {
        this.creditCutOffPoint = cutoff;
    }

    /**
    * getter method for credit cut off point
    */        
    public float getCrCutoff() {
        return this.creditCutOffPoint;
    }

    /**
    * setter method for distinction cut off point
    */        
    public void setDiCutoff(float cutoff) {
        this.distinctionCutOffPoint = cutoff;
    }

    /**
    * getter method for distinction cut off point
    */        
    public float getDiCuttoff() {
        return this.distinctionCutOffPoint;
    }

    /**
    * setter method for high distinction cut off point
    */        
    public void setHdCutoff(float cutoff) {
        this.highDistinctionCutOffPoint = cutoff;
    }

    /**
    * getter method for high distinction cut off point
    */      
    public float getHdCutoff() {
        return this.highDistinctionCutOffPoint;

    }

    /**
    * setter method for additional exam cut off point
    */        
    public void setAeCutoff(float cutoff) {
        this.additionalExamCutOffPoint = cutoff;
    }

    /**
    * getter method for additional exam cut off point
    */      
    public float getAeCutoff() {
        return this.additionalExamCutOffPoint;
    }

    /**
    * add a student record
    * 
    * @param record a student record
    */        
    public void addStudentRecord(IStudentUnitRecord record) {
        recordList.add(record);
    }

    /**
    * get a student record
    * 
    * @param studentID a student ID
    */        
    public IStudentUnitRecord getStudentRecord(int studentID) {
        // return the student record if the student id is in the record
        for (IStudentUnitRecord r : recordList) {
            if (r.getStudentID() == studentID) {
                return r;
            }
        }
        return null;
    }

    /**
    * get the student records
    */        
    public StudentUnitRecordList listStudentRecords() {
        return recordList;
    }

    /**
    * get the assignment 1 weight
    */       
    @Override
    public int getAsg1Weight() {
        return assignment1Weight;
    }

    /**
    * get the assignment 2 weight
    */       
    @Override
    public int getAsg2Weight() {
        return assignment2Weight;
    }

    /**
    * get the exam weight
    */       
    @Override
    public int getExamWeight() {
        return examWeight;
    }

    /**
    * set the assessment weight
    * 
    * @param a1 assignment 1 mark
    * @param a2 assignment 2 mark
    * @param ex exam mark
    */       
    @Override
    public void setAssessmentWeights(int a1, int a2, int ex) {
        // check if the marks are within 0 - 100
        if (a1 < 0 || a1 > 100 || 
            a2 < 0 || a2 > 100 || 
            ex < 0 || ex > 100) {
            throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
        }
        
        // check if assignment 1, assignment 2 and exam adds up to a total of 100
        if (a1 + a2 + ex != 100) {
            throw new RuntimeException("Assessment weights must add to 100");
        }
        
        // set the weights
        this.assignment1Weight = a1;
        this.assignment2Weight = a2;
        this.examWeight = ex;
    }

    /**
    * set the cut off points
    * 
    * @param ps cut off point for pass
    * @param cr cut off point for credit
    * @param di cut off point for distinction
    * @param hd cut off point for high distinction
    * @param ae cut off point for additional exam
    */       
    private void setCutoffs(float ps, float cr, float di, float hd, float ae) {
        // check if the marks are within 0 - 100
        if (ps < 0 || ps > 100 || 
            cr < 0 || cr > 100 || 
            di < 0 || di > 100 ||
            hd < 0 || hd > 100 ||
            ae < 0 || ae > 100) {
            throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
        }
        
        // check if the cut off marks are legitimate
        if (ae >= ps) {
            throw new RuntimeException("AE cutoff must be less than PS cutoff");
        }
        if (ps >= cr) {
            throw new RuntimeException("PS cutoff must be less than CR cutoff");
        }
        if (cr >= di) {
            throw new RuntimeException("CR cutoff must be less than DI cutoff");
        }
        if (di >= hd) {
            throw new RuntimeException("DI cutoff must be less than HD cutoff");
        }

    }

    /**
    * get the grade
    * 
    * @param a1 assignment 1 mark
    * @param a2 assignment 2 mark
    * @param ex exam mark
    */   
    public String getGrade(float a1, float a2, float ex) {
        float total = a1 + a2 + ex;

        if (a1 < 0 || a1 > assignment1Weight || 
            a2 < 0 || a2 > assignment2Weight || 
            ex < 0 || ex > examWeight) {
            throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
        }

        // calculate the grade
        if (total < additionalExamCutOffPoint) {
            return "FL";
        } else if (total < passCutOffPoint) {
            return "AE";
        } else if (total < creditCutOffPoint) {
            return "PS";
        } else if (total < distinctionCutOffPoint) {
            return "CR";
        } else if (total < highDistinctionCutOffPoint) {
            return "DI";
        } else {
            return "HD";
        }
    }

}
