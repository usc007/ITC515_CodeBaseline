package datamanagement;

import java.util.List;
import org.jdom.*;
/**
 *
 * @author Prakash
 */
public class UnitManager {

	private static UnitManager self = null;

	private UnitMap UM;

	public static UnitManager UM() {
		if (self == null)
			self = new UnitManager();
		return self;
	}

	private UnitManager() {
		UM = new UnitMap();
	}

	public IUnit getUnit(String uc) {
		IUnit iu = UM.get(uc);
		return iu != null ? iu : createUnit(uc);

	}
        //Create new unit by provided unit code
	private IUnit createUnit(String unitCode) {

		IUnit iu;
                //For each element with tab <unit>
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("unitTable").getChildren("unit"))
			if (unitCode.equals(el.getAttributeValue("uid"))) {
				StudentUnitRecordList slist;

				slist = null;
                                
                                //add attribute to Unit objectF
				iu = new Unit(el.getAttributeValue("uid"),
						el.getAttributeValue("name"), Float.valueOf(
								el.getAttributeValue("ps")).floatValue(), Float
								.valueOf(el.getAttributeValue("cr"))
								.floatValue(), Float.valueOf(
								el.getAttributeValue("di")).floatValue(), Float
								.valueOf(el.getAttributeValue("hd"))
								.floatValue(), Float.valueOf(
								el.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(el.getAttributeValue("asg1wgt"))
								.intValue(), Integer.valueOf(
								el.getAttributeValue("asg2wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("examwgt"))
								.intValue(), StudentUnitRecordManager
								.instance().getRecordsByUnit(unitCode));
				UM.put(iu.getUnitCode(), iu);
				return iu;
			}

		throw new RuntimeException("DBMD: createUnit : unit not in file");
	}

        //Get Unit
	public UnitMap getUnits() {

		UnitMap uM;
		IUnit iu;

                //int UnitMap
		uM = new UnitMap();
                
                //for each element with tab <unit>
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("unitTable").getChildren("unit")) {
                         //init new UnitProxy by Unit ID and Unit Name    
			iu = new UnitProxy(el.getAttributeValue("uid"),
					el.getAttributeValue("name"));
                        //add to Map
			uM.put(iu.getUnitCode(), iu);
		} // unit maps are filled with PROXY units
		return uM;
	}

}
