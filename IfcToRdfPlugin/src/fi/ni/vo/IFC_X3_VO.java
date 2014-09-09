package fi.ni.vo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * JavaBean value object class used at IFC_MODEL
 * 
 * @author Jyrki Oraskari

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

public class IFC_X3_VO {
        public Long line_num ;	
	public String name=null;
	public LinkedList<Object> list =new LinkedList<Object>();
	
	public Map<String,LinkedList<IFC_X3_VO>> inverse_pointer_sets =new HashMap<String,LinkedList<IFC_X3_VO>>();
	int maxlevel=0;
	
	boolean touched=false;
	
	public boolean is_touched() {
		if(!touched)
		{
			touched=true;
			return false;
		}
		return true;
	}
	public void reset_touched() {
		touched=false;
	}
	String gid=null;
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public Long getLine_num() {
		return line_num;
	}
	public void setLine_num(Long line_num) {
		this.line_num = line_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkedList<Object> getList() {
		return list;
	}
	public void setList(LinkedList<Object> list) {
		this.list = list;
	}
	public int getMaxlevel() {
		return maxlevel;
	}
	public void setMaxlevel(int maxlevel) {
		this.maxlevel = maxlevel;
	}
	@Override
	public String toString() {
	    return "IFC_X3_VO [line_num=" + line_num + ", name=" + name + ", list=" + list + ", inverse_pointer_sets=" + inverse_pointer_sets + ", maxlevel=" + maxlevel + ", touched=" + touched
		    + ", gid=" + gid + "]";
	}
	
	
}
