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

public class IfcBoundaryNodeCondition extends IfcBoundaryCondition 
{
 // The property attributes
 Double linearStiffnessX;
 Double linearStiffnessY;
 Double linearStiffnessZ;
 Double rotationalStiffnessX;
 Double rotationalStiffnessY;
 Double rotationalStiffnessZ;


 // Getters and setters of properties

 public Double getLinearStiffnessX() {
   return linearStiffnessX;
 }
 public void setLinearStiffnessX(String txt){
   Double value = i.toDouble(txt);
   this.linearStiffnessX=value;

 }

 public Double getLinearStiffnessY() {
   return linearStiffnessY;
 }
 public void setLinearStiffnessY(String txt){
   Double value = i.toDouble(txt);
   this.linearStiffnessY=value;

 }

 public Double getLinearStiffnessZ() {
   return linearStiffnessZ;
 }
 public void setLinearStiffnessZ(String txt){
   Double value = i.toDouble(txt);
   this.linearStiffnessZ=value;

 }

 public Double getRotationalStiffnessX() {
   return rotationalStiffnessX;
 }
 public void setRotationalStiffnessX(String txt){
   Double value = i.toDouble(txt);
   this.rotationalStiffnessX=value;

 }

 public Double getRotationalStiffnessY() {
   return rotationalStiffnessY;
 }
 public void setRotationalStiffnessY(String txt){
   Double value = i.toDouble(txt);
   this.rotationalStiffnessY=value;

 }

 public Double getRotationalStiffnessZ() {
   return rotationalStiffnessZ;
 }
 public void setRotationalStiffnessZ(String txt){
   Double value = i.toDouble(txt);
   this.rotationalStiffnessZ=value;

 }

}
