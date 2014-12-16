package fi.ni.vo;


import java.util.ArrayList;
import java.util.List;


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

public class PropertyVO {
   String name;
   List<String> ifcClasses = new ArrayList<String>();
   public boolean isList=false;
   public boolean isEntity=false;
   String rawtype;
   public boolean isEnumeration=false;
   List<String> enumeration_list = null;
   



public PropertyVO(String name, boolean isList, boolean isEntity, String rawtype, boolean isEnumeration, List<String> enumeration_list) {
    super();
    this.name = name;
    this.isList = isList;
    this.isEntity = isEntity;
    this.rawtype = rawtype;
    this.isEnumeration = isEnumeration;
    this.enumeration_list = enumeration_list;
}

public PropertyVO(String name, boolean isList, boolean isEntity, String rawtype) {
    super();
    this.name = name;
    this.isList = isList;
    this.isEntity = isEntity;
    this.rawtype = rawtype;
}

public boolean containsIfcClass(Object o) {
    return ifcClasses.contains(o);
}

public boolean addIfcClass(String e) {
    return ifcClasses.add(e);
}

public List<String> getIfcClasses() {
    return ifcClasses;
}

public String getIfcClassesAsString() {
    StringBuffer sb=new StringBuffer();
    for(int n=0;n<ifcClasses.size();n++)
    {
	if(n>0)
	    sb.append(' ');
	sb.append("ifc:"+ifcClasses.get(n));
    }
    return sb.toString();
}

public boolean isList() {
    return isList;
}
public void setList(boolean isList) {
    this.isList = isList;
}
public String getRawtype() {
    return rawtype;
}
public void setRawtype(String rawtype) {
    this.rawtype = rawtype;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public boolean isEntity() {
    return isEntity;
}

public void setEntity(boolean isEntity) {
    this.isEntity = isEntity;
}

public void setIfcClasses(List<String> ifcClasses) {
    this.ifcClasses = ifcClasses;
}

public boolean isEnumeration() {
    return isEnumeration;
}

public void setEnumeration(boolean isEnumeration) {
    this.isEnumeration = isEnumeration;
}

public List<String> getEnumeration_list() {
    return enumeration_list;
}

public void setEnumeration_list(List<String> enumeration_list) {
    this.enumeration_list = enumeration_list;
}


public String getEnumerationsAsString() {
    StringBuffer sb=new StringBuffer();
    for(int n=0;n<enumeration_list.size();n++)
    {
	if(n>0)
	    sb.append(' ');
	sb.append("ifc:"+enumeration_list.get(n));
    }
    return sb.toString();
}
   
}
