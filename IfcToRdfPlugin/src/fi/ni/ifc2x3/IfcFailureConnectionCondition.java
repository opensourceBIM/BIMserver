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

public class IfcFailureConnectionCondition extends IfcStructuralConnectionCondition 
{
 // The property attributes
 Double tensionFailureX;
 Double tensionFailureY;
 Double tensionFailureZ;
 Double compressionFailureX;
 Double compressionFailureY;
 Double compressionFailureZ;


 // Getters and setters of properties

 public Double getTensionFailureX() {
   return tensionFailureX;
 }
 public void setTensionFailureX(String txt){
   Double value = i.toDouble(txt);
   this.tensionFailureX=value;

 }

 public Double getTensionFailureY() {
   return tensionFailureY;
 }
 public void setTensionFailureY(String txt){
   Double value = i.toDouble(txt);
   this.tensionFailureY=value;

 }

 public Double getTensionFailureZ() {
   return tensionFailureZ;
 }
 public void setTensionFailureZ(String txt){
   Double value = i.toDouble(txt);
   this.tensionFailureZ=value;

 }

 public Double getCompressionFailureX() {
   return compressionFailureX;
 }
 public void setCompressionFailureX(String txt){
   Double value = i.toDouble(txt);
   this.compressionFailureX=value;

 }

 public Double getCompressionFailureY() {
   return compressionFailureY;
 }
 public void setCompressionFailureY(String txt){
   Double value = i.toDouble(txt);
   this.compressionFailureY=value;

 }

 public Double getCompressionFailureZ() {
   return compressionFailureZ;
 }
 public void setCompressionFailureZ(String txt){
   Double value = i.toDouble(txt);
   this.compressionFailureZ=value;

 }

}
