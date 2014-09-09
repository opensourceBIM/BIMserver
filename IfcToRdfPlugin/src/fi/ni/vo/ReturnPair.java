
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

import fi.ni.Thing;

public class ReturnPair {
    Thing  t;
    public double difference;
    
    public ReturnPair(Thing t, double difference) {
	super();
	this.t = t;
	this.difference = difference;
    }
    public Thing getT() {
        return t;
    }

    public void setT(Thing t) {
        this.t = t;
    }
    public double getDifference() {
        return difference;
    }
    public void setDifference(double difference) {
        this.difference = difference;
    }
    
    @Override
    public String toString() {
	return "ReturnPair [t=" + t + ", difference=" + difference + "]";
    }
    

}
