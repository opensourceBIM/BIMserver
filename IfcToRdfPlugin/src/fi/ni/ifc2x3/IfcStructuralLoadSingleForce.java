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

public class IfcStructuralLoadSingleForce extends IfcStructuralLoadStatic 
{
 // The property attributes
 Double forceX;
 Double forceY;
 Double forceZ;
 Double momentX;
 Double momentY;
 Double momentZ;


 // Getters and setters of properties

 public Double getForceX() {
   return forceX;
 }
 public void setForceX(String txt){
   Double value = i.toDouble(txt);
   this.forceX=value;

 }

 public Double getForceY() {
   return forceY;
 }
 public void setForceY(String txt){
   Double value = i.toDouble(txt);
   this.forceY=value;

 }

 public Double getForceZ() {
   return forceZ;
 }
 public void setForceZ(String txt){
   Double value = i.toDouble(txt);
   this.forceZ=value;

 }

 public Double getMomentX() {
   return momentX;
 }
 public void setMomentX(String txt){
   Double value = i.toDouble(txt);
   this.momentX=value;

 }

 public Double getMomentY() {
   return momentY;
 }
 public void setMomentY(String txt){
   Double value = i.toDouble(txt);
   this.momentY=value;

 }

 public Double getMomentZ() {
   return momentZ;
 }
 public void setMomentZ(String txt){
   Double value = i.toDouble(txt);
   this.momentZ=value;

 }

}
