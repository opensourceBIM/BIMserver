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

public class IfcStructuralLoadPlanarForce extends IfcStructuralLoadStatic 
{
 // The property attributes
 Double planarForceX;
 Double planarForceY;
 Double planarForceZ;


 // Getters and setters of properties

 public Double getPlanarForceX() {
   return planarForceX;
 }
 public void setPlanarForceX(String txt){
   Double value = i.toDouble(txt);
   this.planarForceX=value;

 }

 public Double getPlanarForceY() {
   return planarForceY;
 }
 public void setPlanarForceY(String txt){
   Double value = i.toDouble(txt);
   this.planarForceY=value;

 }

 public Double getPlanarForceZ() {
   return planarForceZ;
 }
 public void setPlanarForceZ(String txt){
   Double value = i.toDouble(txt);
   this.planarForceZ=value;

 }

}
