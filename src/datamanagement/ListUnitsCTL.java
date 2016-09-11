package datamanagement;

public class ListUnitsCTL {
    private UnitManager um;
    //Constructor of a class
public ListUnitsCTL() {
    um = UnitManager.UM();
}
// to list all list unit in the xml file
public void listUnits( IUnitLister lister ) {
    
    lister.clearUnits(); // Enmpty lister
    UnitMap units = um.getUnits(); // Call Unitmap class to get unit
    for (String s : units.keySet() )
    lister.addUnit(units.get(s));
    
}
    
}
