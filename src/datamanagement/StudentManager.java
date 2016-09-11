package datamanagement;

import org.jdom.*;
import java.util.List;
public class StudentManager {
    private static StudentManager self = null;
    // sm = student map
    private StudentMap sm;
    // um = hashmap
    private java.util.HashMap<String, StudentMap> um;
    
public static StudentManager get() {
        if (self == null) 
            self = new StudentManager(); 
            return self; 
}
// Constructor of a class
private StudentManager() {
    sm = new StudentMap();
    um = new java.util.HashMap<>();
    
}
/**
 * @param id the id of a student
 * @return id
 */
 public IStudent getStudent(Integer id) {
    IStudent is = sm.get(id);
    return is != null ? is : createStudent(id);
 }
/**
 * @param id the id of a student
 * @return e1 the element of a student
 */
 // get method for student element based on id
private Element getStudentElement(Integer id) {
    for (Element el : (List<Element>) XMLManager.getXML().getDocument().getRootElement().getChild("studentTable").getChildren("student")) 
        // If input id matches to the id in a database then return e1 otherwise return null
        if (id.toString().equals(el.getAttributeValue("sid"))) 
            return el;
            return null;
}
// createStudent method for create student details
private IStudent createStudent(Integer id) {
    IStudent is;
    Element el = getStudentElement(id);
    if (el != null) {
        StudentUnitRecordList rlist = StudentUnitRecordManager.instance().getRecordsByStudent(id);
        is = new Student(new Integer(el.getAttributeValue("sid")),el.getAttributeValue("fname"),el.getAttributeValue("lname"),rlist);
        sm.put(is.getID(), is);
        return is; 
        }
throw new RuntimeException("DBMD: createStudent : student not in file");
    
}
//createStudentProxy method to create student proxy
private IStudent createStudentProxy(Integer id) {
    Element el = getStudentElement(id);
    if (el != null) return new StudentProxy(id, el.getAttributeValue("fname"), el.getAttributeValue("lname"));
        throw new RuntimeException("DBMD: createStudent : student not in file");
}
//getStudentsByUnit method to get the students by unit
public StudentMap getStudentsByUnit(String uc) {
    StudentMap s = um.get(uc);
    if (s != null) {
        return s;
    }
    s = new StudentMap();
    IStudent is;
    StudentUnitRecordList ur = StudentUnitRecordManager.instance().getRecordsByUnit(uc);
    for (IStudentUnitRecord S : ur) {
        is = createStudentProxy(new Integer(S.getStudentID()));
        s.put(is.getID(), is);
        
    }
        um.put( uc, s);
        return s;
}
    
}
