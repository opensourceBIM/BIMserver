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

public class IfcGeneralProfileProperties extends IfcProfileProperties 
{
 // The property attributes
 Double physicalWeight;
 Double perimeter;
 Double minimumPlateThickness;
 Double maximumPlateThickness;
 Double crossSectionArea;


 // Getters and setters of properties

 public Double getPhysicalWeight() {
   return physicalWeight;
 }
 public void setPhysicalWeight(String txt){
   Double value = i.toDouble(txt);
   this.physicalWeight=value;

 }

 public Double getPerimeter() {
   return perimeter;
 }
 public void setPerimeter(String txt){
   Double value = i.toDouble(txt);
   this.perimeter=value;

 }

 public Double getMinimumPlateThickness() {
   return minimumPlateThickness;
 }
 public void setMinimumPlateThickness(String txt){
   Double value = i.toDouble(txt);
   this.minimumPlateThickness=value;

 }

 public Double getMaximumPlateThickness() {
   return maximumPlateThickness;
 }
 public void setMaximumPlateThickness(String txt){
   Double value = i.toDouble(txt);
   this.maximumPlateThickness=value;

 }

 public Double getCrossSectionArea() {
   return crossSectionArea;
 }
 public void setCrossSectionArea(String txt){
   Double value = i.toDouble(txt);
   this.crossSectionArea=value;

 }

}
