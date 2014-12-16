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

public class IfcRectangularTrimmedSurface extends IfcBoundedSurface 
{
 // The property attributes
 IfcSurface   basisSurface;
 Double u1;
 Double v1;
 Double u2;
 Double v2;
 String usense;
 String vsense;


 // Getters and setters of properties

 public IfcSurface getBasisSurface() {
   return basisSurface;

 }
 public void setBasisSurface(IfcSurface value){
   this.basisSurface=value;

 }

 public Double getU1() {
   return u1;
 }
 public void setU1(String txt){
   Double value = i.toDouble(txt);
   this.u1=value;

 }

 public Double getV1() {
   return v1;
 }
 public void setV1(String txt){
   Double value = i.toDouble(txt);
   this.v1=value;

 }

 public Double getU2() {
   return u2;
 }
 public void setU2(String txt){
   Double value = i.toDouble(txt);
   this.u2=value;

 }

 public Double getV2() {
   return v2;
 }
 public void setV2(String txt){
   Double value = i.toDouble(txt);
   this.v2=value;

 }

 public String getUsense() {
   return usense;
 }
 public void setUsense(String value){
   this.usense=value;

 }

 public String getVsense() {
   return vsense;
 }
 public void setVsense(String value){
   this.vsense=value;

 }

}
