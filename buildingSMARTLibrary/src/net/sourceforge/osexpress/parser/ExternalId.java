package net.sourceforge.osexpress.parser;

class ExternalId implements ExpressParserTokenTypes {

    /* may represent an id of a schema referenced or used by another schema
       with its new name if it exists/
       may also represent a couple id-type
    */

    public String schema; /* schema from which this element is referenced/used */
    public String id;
    public String rename; 
    public int type;

    public ExternalId(String id) {
	this.id=id;
    }
    
    public ExternalId(String id, int type) {
	this.id=id;
	this.type=type;
    }

    public void setSchema(String s) {
	schema=s;
    }

    public void setRename(String rename) {
	this.rename=rename;
    }
}
    
