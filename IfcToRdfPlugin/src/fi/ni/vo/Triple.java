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

import java.util.HashSet;
import java.util.Set;

import fi.ni.Thing;

public class Triple {
    static Set<Thing> printed = new HashSet<Thing>();

    boolean used = false;
    public Thing  s;
    public Object o;
    public String p;
    
    public boolean literal=false;
    
    public Triple(Link l) {
	this.s = l.t1;
	this.p = l.property;
	this.o = l.t2;
    }

    public Triple(Thing subject, String property,Object object) {
	this.s = subject;
	this.p = property;
	this.o = object;
	literal=true;
    }


}
