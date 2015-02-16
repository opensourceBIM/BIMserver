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

public class IfcBoundaryEdgeCondition extends IfcBoundaryCondition 
{
 // The property attributes
 Double linearStiffnessByLengthX;
 Double linearStiffnessByLengthY;
 Double linearStiffnessByLengthZ;
 Double rotationalStiffnessByLengthX;
 Double rotationalStiffnessByLengthY;
 Double rotationalStiffnessByLengthZ;


 // Getters and setters of properties

 public Double getLinearStiffnessByLengthX() {
   return linearStiffnessByLengthX;
 }
 public void setLinearStiffnessByLengthX(String txt){
   Double value = i.toDouble(txt);
   this.linearStiffnessByLengthX=value;

 }

 public Double getLinearStiffnessByLengthY() {
   return linearStiffnessByLengthY;
 }
 public void setLinearStiffnessByLengthY(String txt){
   Double value = i.toDouble(txt);
   this.linearStiffnessByLengthY=value;

 }

 public Double getLinearStiffnessByLengthZ() {
   return linearStiffnessByLengthZ;
 }
 public void setLinearStiffnessByLengthZ(String txt){
   Double value = i.toDouble(txt);
   this.linearStiffnessByLengthZ=value;

 }

 public Double getRotationalStiffnessByLengthX() {
   return rotationalStiffnessByLengthX;
 }
 public void setRotationalStiffnessByLengthX(String txt){
   Double value = i.toDouble(txt);
   this.rotationalStiffnessByLengthX=value;

 }

 public Double getRotationalStiffnessByLengthY() {
   return rotationalStiffnessByLengthY;
 }
 public void setRotationalStiffnessByLengthY(String txt){
   Double value = i.toDouble(txt);
   this.rotationalStiffnessByLengthY=value;

 }

 public Double getRotationalStiffnessByLengthZ() {
   return rotationalStiffnessByLengthZ;
 }
 public void setRotationalStiffnessByLengthZ(String txt){
   Double value = i.toDouble(txt);
   this.rotationalStiffnessByLengthZ=value;

 }

}
