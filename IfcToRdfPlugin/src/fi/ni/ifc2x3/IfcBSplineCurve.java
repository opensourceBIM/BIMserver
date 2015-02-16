package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcList;

/*
 * IFC Java class
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

public class IfcBSplineCurve extends IfcBoundedCurve 
{
 // The property attributes
 Long degree;
 List<IfcCartesianPoint> controlPointsList = new IfcList<IfcCartesianPoint>();
 String curveForm;
 String closedCurve;
 String selfIntersect;


 // Getters and setters of properties

 public Long getDegree() {
   return degree;
 }
 public void setDegree(String txt){
   Long value = i.toLong(txt);
   this.degree=value;

 }

 public List<IfcCartesianPoint> getControlPointsList() {
   return controlPointsList;

 }
 public void setControlPointsList(IfcCartesianPoint value){
   this.controlPointsList.add(value);

 }

 public String getCurveForm() {
   return curveForm;
 }
 public void setCurveForm(String value){
   this.curveForm=value;

 }

 public String getClosedCurve() {
   return closedCurve;
 }
 public void setClosedCurve(String value){
   this.closedCurve=value;

 }

 public String getSelfIntersect() {
   return selfIntersect;
 }
 public void setSelfIntersect(String value){
   this.selfIntersect=value;

 }

}
