package datamanagement;
/*
IUnit Interface implementing different methods
*/
public interface IUnit 
{
    //method defined for getting unitcode and unitname which is of variable string
    public String getUnitCode();
    public String getUnitName();
    //method defined for setting and getting the pass mark 
    public float getPsCutoff();
    public void  setPsCutoff1(float cutoff);
    //method defined for setting and getting the credit mark 
    public float getCrCutoff();
    public void  setCrCutoff(float cutoff);
    //method defined for setting and getting the distinction mark 
    public float getDiCuttoff();    
    public void  setDiCutoff(float cutoff);
    //method defined for setting and getting the high distinction mark 
    public float getHdCutoff();
    public void  setHdCutoff(float cutoff);    

    public float getAeCutoff();    
    public void  setAeCutoff(float cutoff);
    
    //method defining for getting and setting Asg1,Asg2 and ExamWeight 
    /* variable declaration float value would ave suited more*/
    public int getAsg1Weight();
    public int getAsg2Weight();
    public int getExamWeight();
    public void setAssessmentWeights(int asg1Wgt, int asg2Wgt, int examWgt);
    //method for getting grade from asg1 asg2 and mark
    public String getGrade(float asg1, float asg2, float exam);
    //method description comment not given
    public void addStudentRecord(IStudentUnitRecord record );
    public IStudentUnitRecord getStudentRecord(int studentID );
    
    public StudentUnitRecordList listStudentRecords();
}
