package org.bimserver.plugins.schema;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectType extends DefinedType implements ConstructedType {

	
	private HashMap <String, NamedType> selectionsBN = new HashMap<String,NamedType>();
	private ArrayList <NamedType> selections = new ArrayList<NamedType>();
	
	
	public SelectType(String name, UnderlyingType domain) {
		super(name, domain);
		// TODO Auto-generated constructor stub
	}
	
	/** Copy constructor (shallow copy)
	 * @param old
	 */
	public SelectType (SelectType old){
		super(old.getName(),old.getDomain() );
		this.setSelections(old.getSelections());
		this.setSelectionsBN(old.getSelectionsBN());
	}

	public SelectType(String name){
		
		super(name);
		
		super.setDomain(new StringType());
	
	}



	public boolean addSelection(NamedType type){
		selectionsBN.put(type.getName(), type);
		selections.add(type);	
		return true;
	}
	
	public NamedType getSelectionBN(String name){
		return selectionsBN.get(name);
	}

	public ArrayList<NamedType> getSelections() {
		return selections;
	}

	public void setSelections(ArrayList<NamedType> selections) {
		this.selections = selections;
	}

	public HashMap<String, NamedType> getSelectionsBN() {
		return selectionsBN;
	}

	public void setSelectionsBN(HashMap<String, NamedType> selectionsBN) {
		this.selectionsBN = selectionsBN;
	}
	
}
