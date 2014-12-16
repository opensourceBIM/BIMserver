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

public class IfcProductsOfCombustionProperties extends IfcMaterialProperties 
{
 // The property attributes
 Double specificHeatCapacity;
 Double n20Content;
 Double cOContent;
 Double cO2Content;


 // Getters and setters of properties

 public Double getSpecificHeatCapacity() {
   return specificHeatCapacity;
 }
 public void setSpecificHeatCapacity(String txt){
   Double value = i.toDouble(txt);
   this.specificHeatCapacity=value;

 }

 public Double getN20Content() {
   return n20Content;
 }
 public void setN20Content(String txt){
   Double value = i.toDouble(txt);
   this.n20Content=value;

 }

 public Double getCOContent() {
   return cOContent;
 }
 public void setCOContent(String txt){
   Double value = i.toDouble(txt);
   this.cOContent=value;

 }

 public Double getCO2Content() {
   return cO2Content;
 }
 public void setCO2Content(String txt){
   Double value = i.toDouble(txt);
   this.cO2Content=value;

 }

}
