package datamanagement;

public interface IStudentUnitRecord 
{
    // getting the student id in integer
    public Integer getStudentID();
    //gettin  unit code in string  
    public String getUnitCode();
    //setting the asg1 mark in float value
    public void setAsg1(float mark);
    //getting the asg1 mark in float value
    public float getAsg1();
    //setting the asg2 mark in float value
    public void setAsg2(float mark);
    //getting the asg2 mark in float value
    public float getAsg2();
    //set the mark of the exam in float value
    public void setExam(float mark);
    //get the mark of the exam
    public float getExam();
    //get the total mark in float value from as1 as2 and exam for student
    public float getTotal();
}
