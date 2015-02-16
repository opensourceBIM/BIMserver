package fi.ni.ifc2x3;

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

public class IfcWindowLiningProperties extends IfcPropertySetDefinition 
{
 // The property attributes
 Double liningDepth;
 Double liningThickness;
 Double transomThickness;
 Double mullionThickness;
 Double firstTransomOffset;
 Double secondTransomOffset;
 Double firstMullionOffset;
 Double secondMullionOffset;
 IfcShapeAspect   shapeAspectStyle;


 // Getters and setters of properties

 public Double getLiningDepth() {
   return liningDepth;
 }
 public void setLiningDepth(String txt){
   Double value = i.toDouble(txt);
   this.liningDepth=value;

 }

 public Double getLiningThickness() {
   return liningThickness;
 }
 public void setLiningThickness(String txt){
   Double value = i.toDouble(txt);
   this.liningThickness=value;

 }

 public Double getTransomThickness() {
   return transomThickness;
 }
 public void setTransomThickness(String txt){
   Double value = i.toDouble(txt);
   this.transomThickness=value;

 }

 public Double getMullionThickness() {
   return mullionThickness;
 }
 public void setMullionThickness(String txt){
   Double value = i.toDouble(txt);
   this.mullionThickness=value;

 }

 public Double getFirstTransomOffset() {
   return firstTransomOffset;
 }
 public void setFirstTransomOffset(String txt){
   Double value = i.toDouble(txt);
   this.firstTransomOffset=value;

 }

 public Double getSecondTransomOffset() {
   return secondTransomOffset;
 }
 public void setSecondTransomOffset(String txt){
   Double value = i.toDouble(txt);
   this.secondTransomOffset=value;

 }

 public Double getFirstMullionOffset() {
   return firstMullionOffset;
 }
 public void setFirstMullionOffset(String txt){
   Double value = i.toDouble(txt);
   this.firstMullionOffset=value;

 }

 public Double getSecondMullionOffset() {
   return secondMullionOffset;
 }
 public void setSecondMullionOffset(String txt){
   Double value = i.toDouble(txt);
   this.secondMullionOffset=value;

 }

 public IfcShapeAspect getShapeAspectStyle() {
   return shapeAspectStyle;

 }
 public void setShapeAspectStyle(IfcShapeAspect value){
   this.shapeAspectStyle=value;

 }

}
