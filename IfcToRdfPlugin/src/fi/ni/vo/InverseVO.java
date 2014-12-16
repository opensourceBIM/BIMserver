

/*
The MIT License (MIT)

Copyright (c) 2014 Jyrki Oraskari

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package fi.ni.vo;

public class InverseVO {
  private String name;
  private String ifc_class;
  private String property;
  private boolean set=false;

  boolean unique=false;
  boolean one_valued=false;
  
  

public InverseVO(String name, String ifc_class, String property, boolean set, boolean one_valued) {
    super();
    this.name = name;
    this.ifc_class = ifc_class;
    this.property = property;
    this.set = set;
    this.one_valued = one_valued;
}




public boolean isSet() {
    return set;
}


public void setSet(boolean set) {
    this.set = set;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIfc_class() {
	return ifc_class;
}
public void setIfc_class(String ifc_class) {
	this.ifc_class = ifc_class;
}
public String getProperty() {
	return property;
}
public void setProperty(String property) {
	this.property = property;
}


public boolean isUnique() {
    return unique;
}



public void setUnique(boolean unique) {
    this.unique = unique;
}





public boolean isOne_valued() {
    return one_valued;
}



public void setOne_valued(boolean one_valued) {
    this.one_valued = one_valued;
}



@Override
public String toString() {
    return "InverseVO [name=" + name + ", ifc_class=" + ifc_class + ", property=" + property + ", set=" + set + "]";
}
 


}
