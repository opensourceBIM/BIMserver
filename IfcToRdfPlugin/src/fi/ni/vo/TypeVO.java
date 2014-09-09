
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

import java.util.LinkedList;
import java.util.List;

public class TypeVO {
  private String name;
  private String primarytype;
  private List<String>    selected_entities=new LinkedList<String>();
  private List<String>    enum_entities=new LinkedList<String>();
  
public TypeVO(String name) {
	super();
	this.name = name;
	this.primarytype = name;
}



public TypeVO(String name, String primarytype) {
    super();
    this.name = name;
    this.primarytype = primarytype;
}



public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public List<String> getSelected_entities() {
    return selected_entities;
}

public void setSelected_entities(List<String> selected_entities) {
    this.selected_entities = selected_entities;
}

public String getPrimarytype() {
    return primarytype;
}

public void setPrimarytype(String primarytype) {
    this.primarytype = primarytype;
}



public List<String> getEnum_entities() {
    return enum_entities;
}



public void setEnum_entities(List<String> enum_entities) {
    this.enum_entities = enum_entities;
}



}
