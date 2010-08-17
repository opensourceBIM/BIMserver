package net.sourceforge.osexpress.parser;

import java.util.Vector;

class EnumerationType {

    private Vector ids;
    public boolean extensible;
    public String typename;
    public String basedOnName;

    public EnumerationType() {
	ids = new Vector();
    }

    public void setTypeName(String name) {
	typename=name;
    }

    public void setExtensible(boolean ext) {
	extensible=ext;
    }

    public void setBasedOn(String bo) {
	basedOnName=bo;
    }

    public void add(String eid) {
	ids.add(eid);
    }

    public void extendWith(EnumerationType et) {
	ids.addAll(et.ids);
    }

    public int getCount() {
	return ids.size();
    }

    public String getEnumerationId(int index) {
	return (String)ids.elementAt(index);
    }
}
