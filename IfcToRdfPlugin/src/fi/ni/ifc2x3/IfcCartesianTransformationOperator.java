package fi.ni.ifc2x3;
import fi.ni.ifc2x3.interfaces.*;
import fi.ni.*;
import java.util.*;

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

public class IfcCartesianTransformationOperator extends IfcGeometricRepresentationItem 
{
 // The property attributes
 IfcDirection   axis1;
 IfcDirection   axis2;
 IfcCartesianPoint   localOrigin;
 Double scale;


 // Getters and setters of properties

 public IfcDirection getAxis1() {
   return axis1;

 }
 public void setAxis1(IfcDirection value){
   this.axis1=value;

 }

 public IfcDirection getAxis2() {
   return axis2;

 }
 public void setAxis2(IfcDirection value){
   this.axis2=value;

 }

 public IfcCartesianPoint getLocalOrigin() {
   return localOrigin;

 }
 public void setLocalOrigin(IfcCartesianPoint value){
   this.localOrigin=value;

 }

 public Double getScale() {
   return scale;
 }
 public void setScale(String txt){
   Double value = i.toDouble(txt);
   this.scale=value;

 }

}
