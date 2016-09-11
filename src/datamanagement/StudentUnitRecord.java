package datamanagement;
import datamanagement.IStudentUnitRecord;
import datamanagement.UnitManager;
/**
 *
 * @author KishanTamang
*/

public class StudentUnitRecord implements IStudentUnitRecord {
	    private Integer studentId;
	    private String unitCode;
	    private float assignment1Mark, assignment2Mark, examMark;

/**
* Constructor of the StudentUnitRecord class
*
* @param id    the id of a student
* @param code  the unit code of a unit
* @param asg1  the assignment 1 mark of a student
* @param asg2  the assignment 2 mark of a student 
* @param exam  the exam mark of a student
*/ 
public StudentUnitRecord(Integer id, String code, float asg1, float asg2,
			float exam) {
	this.studentId = id;
	this.unitCode = code;
	this.setAsg1(asg1);
	this.setAsg2(asg2);
	this.setExam(exam);
}
// get method for student id
public Integer getStudentID() {
	return studentId;
}
// get method for unit code
public String getUnitCode() {
	return unitCode;
}
// set method for assignment1 mark
/**
* @param assignment1Mark the mark of assignment 1
*/  
public void setAsg1(float assignment1Mark) {
	if (assignment1Mark < 0 || assignment1Mark > UnitManager.UM().getUnit(unitCode).getAsg1Weight()) {
		throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
	}
	this.assignment1Mark = assignment1Mark;
}
// get method for assignment 1 mark
public float getAsg1() {
	return assignment1Mark;
}
/**
* @param assignment2Mark the mark of assignment 2
* */
//set method for assignment 2 mark
public void setAsg2(float assignment2Mark) {
	if (assignment2Mark < 0 || assignment2Mark > UnitManager.UM().getUnit(unitCode).getAsg2Weight()) {
		throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
	}
	this.assignment2Mark = assignment2Mark;

}
// get method for assignment 2 mark of a student
public float getAsg2() {
	return assignment2Mark;
}
/**
* @param examMark the mark of exam
*/ 
//Set exam mark 
public void setExam(float examMark) {
	if (examMark < 0 || examMark > UnitManager.UM().getUnit(unitCode).getExamWeight()) {
		throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
	}
	this.examMark = examMark;
}
// get method for exam mark of a student
public float getExam() {
	return examMark;
}
// get method for total marks
public float getTotal() {
	return assignment1Mark + assignment2Mark + examMark;

}
}
