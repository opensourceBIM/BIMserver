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

public class InOutLinks implements Comparable<InOutLinks>
{
	int in;
	int out;
	public InOutLinks(int in, int out) {
	    super();
	    this.in = in;
	    this.out = out;
	}
		
	private String f(int n)
	{
	    return String.format("%06d", n);
	}
	public String toString() {
	    return f(out)+","+f(in);
	}
	
    public boolean equals(Object obj) {
        InOutLinks i=(InOutLinks)obj;
        if((i.in==this.in)&&(i.out==this.out))
    	    return true;
        else
    	     return false;
    }
    
	public int compareTo(InOutLinks o) {
        return -o.toString().compareTo(this.toString());
	}
	
	public int distance(InOutLinks o)
	{
	    return Math.abs(o.in-this.in) + Math.abs(o.out - this.out);
	}
}
