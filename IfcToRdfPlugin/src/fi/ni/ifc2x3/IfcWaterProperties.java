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

public class IfcWaterProperties extends IfcMaterialProperties 
{
 // The property attributes
 String isPotable;
 Double hardness;
 Double alkalinityConcentration;
 Double acidityConcentration;
 Double impuritiesContent;
 Double pHLevel;
 Double dissolvedSolidsContent;


 // Getters and setters of properties

 public String getIsPotable() {
   return isPotable;
 }
 public void setIsPotable(String value){
   this.isPotable=value;

 }

 public Double getHardness() {
   return hardness;
 }
 public void setHardness(String txt){
   Double value = i.toDouble(txt);
   this.hardness=value;

 }

 public Double getAlkalinityConcentration() {
   return alkalinityConcentration;
 }
 public void setAlkalinityConcentration(String txt){
   Double value = i.toDouble(txt);
   this.alkalinityConcentration=value;

 }

 public Double getAcidityConcentration() {
   return acidityConcentration;
 }
 public void setAcidityConcentration(String txt){
   Double value = i.toDouble(txt);
   this.acidityConcentration=value;

 }

 public Double getImpuritiesContent() {
   return impuritiesContent;
 }
 public void setImpuritiesContent(String txt){
   Double value = i.toDouble(txt);
   this.impuritiesContent=value;

 }

 public Double getPHLevel() {
   return pHLevel;
 }
 public void setPHLevel(String txt){
   Double value = i.toDouble(txt);
   this.pHLevel=value;

 }

 public Double getDissolvedSolidsContent() {
   return dissolvedSolidsContent;
 }
 public void setDissolvedSolidsContent(String txt){
   Double value = i.toDouble(txt);
   this.dissolvedSolidsContent=value;

 }

}
