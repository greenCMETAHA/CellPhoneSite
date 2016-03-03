package workset.beans.interfaces.base;

import workset.beans.interfaces.InterfaceManufacturer;

public interface InterfaceGood {
	
	int getId();				//add some later if the basket will be for many goods
	void setId(int id);
	
	String getName();
	void setName(String name);
	
	String getDescription();
	String getSpecification();
	
	InterfaceManufacturer getManufacturer();
}
