package fi.ni.vo;


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

public class AttributeVO {
  private String name;
  private TypeVO type;
  boolean unique=false;
  private boolean reverse_pointer;   // defined in another class
  boolean isOne2One=false;

  private InverseVO points_from;
  private boolean set=false;
  private boolean list=false;
  
public AttributeVO(String name, TypeVO type, boolean is_set,boolean is_list) {
    super();
    this.name = name;
    this.type = type;
    this.reverse_pointer = false;
    this.set = is_set;
    this.list = is_list;
}



public boolean isSet() {
    return set;
}




public void setSet(boolean set) {
    this.set = set;
}


public boolean isList() {
    return list;
}



public void setList(boolean list) {
    this.list = list;
}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



public TypeVO getType() {
    return type;
}


public void setType(TypeVO type) {
    this.type = type;
}


public boolean isReverse_pointer() {
	return reverse_pointer;
}
public void setReverse_pointer(boolean reverse_pointer) {
	this.reverse_pointer = reverse_pointer;
}
public InverseVO getPoints_from() {
	return points_from;
}
public void setPoints_from(InverseVO points_from) {
	this.points_from = points_from;
}




public boolean isUnique() {
    return unique;
}



public void setUnique(boolean unique) {
    this.unique = unique;
}






public boolean isOne2One() {
    return isOne2One;
}



public void setOne2One(boolean isOne2One) {
    this.isOne2One = isOne2One;
}



@Override
public String toString() {
    return "AttributeVO [name=" + name + ", type=" + type + ", reverse_pointer=" + reverse_pointer + ", points_from=" + points_from + ", set=" + set + "]";
}

 
  
}
