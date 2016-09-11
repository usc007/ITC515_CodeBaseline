package datamanagement;

import java.util.List;
import org.jdom.*;

/**
 *
 * @author Prakash
 */

public class StudentUnitRecordManager {

    private static StudentUnitRecordManager s = null;
    private StudentUnitRecordMap rm;
    private java.util.HashMap<String, StudentUnitRecordList> ur;
    private java.util.HashMap<Integer, StudentUnitRecordList> sr;

    // constuctor
    public static StudentUnitRecordManager instance() {
        if (s == null) {
            s = new StudentUnitRecordManager();
        }
        return s;
    }

    // constuctor to init StudentRecordManager
    private StudentUnitRecordManager() {
        rm = new StudentUnitRecordMap();
        ur = new java.util.HashMap<>();
        sr = new java.util.HashMap<>();
    }

    public IStudentUnitRecord getStudentUnitRecord(Integer studentID, String unitCode) {
        IStudentUnitRecord ir = rm.get(studentID.toString() + unitCode);
        // if ir is not found then create new student Unit Record by provided studentID and unitCode
        return ir != null ? ir : createStudentUnitRecord(studentID, unitCode);
    }

    // create new Student Unit Record
    private IStudentUnitRecord createStudentUnitRecord(Integer uid, String sid) {
        IStudentUnitRecord ir;
        // for each element from tab <record>
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (uid.toString().equals(el.getAttributeValue("sid")) && sid.equals(el.getAttributeValue("uid"))) {
                // create new StudentUnitRecord
                ir = new StudentUnitRecord(new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid"), new Float(el.getAttributeValue("asg1")).floatValue(), new Float(el.getAttributeValue("asg2")).floatValue(), new Float(el.getAttributeValue("exam")).floatValue());
                // add the data to Map as Student ID and Unit Code
                rm.put(ir.getStudentID().toString() + ir.getUnitCode(), ir);
                return ir;
            }
        }
        throw new RuntimeException("DBMD: createStudent : student unit record not in file");
    }

    // get record by unit
    public StudentUnitRecordList getRecordsByUnit(String unitCode) {
        // By the hashmap of StudentUnitRecordList ... get the unitCode and stored to the new object name Student Unit Record List
        StudentUnitRecordList recs = ur.get(unitCode);
        if (recs != null) {
            return recs;
        }
        recs = new StudentUnitRecordList();
        
        // for each element in <record> tab
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            // if unitCode is existed
            if (unitCode.equals(el.getAttributeValue("uid"))) {
                // add new Student Unit Record Proxy by the received element by Student ID and Unit ID
                recs.add(new StudentUnitRecordProxy(new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
            }
        }
        if (recs.size() > 0) {
            ur.put(unitCode, recs); // be careful - this could be empty
        }
        return recs;
    }

    // get record by student id
    public StudentUnitRecordList getRecordsByStudent(Integer studentID) {
        StudentUnitRecordList recs = sr.get(studentID);
        if (recs != null) {
            return recs;
        }
        recs = new StudentUnitRecordList();
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            if (studentID.toString().equals(el.getAttributeValue("sid"))) {
                recs.add(new StudentUnitRecordProxy(new Integer(el.getAttributeValue("sid")), el.getAttributeValue("uid")));
            }
        }
        if (recs.size() > 0) {
            sr.put(studentID, recs); // be careful - this could be empty
        }
        return recs;
    }

    // save record 
    public void saveRecord(IStudentUnitRecord irec) {
        // for each element get record
        for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
            // call getStudentID class from Interface Student Unit Record to check if the received student ID is matched
            if (irec.getStudentID().toString().equals(el.getAttributeValue("sid")) && irec.getUnitCode().equals(el.getAttributeValue("uid"))) {
                // add attribute
                el.setAttribute("asg1", new Float(irec.getAsg1()).toString());
                el.setAttribute("asg2", new Float(irec.getAsg2()).toString());
                el.setAttribute("exam", new Float(irec.getExam()).toString());
                // save all element to xml file
                XMLManager.getXML().saveDocument(); //write out the XML file for continuous save
                return;
            }
        }

        throw new RuntimeException("DBMD: saveRecord : no such student record in data");
    }
}
