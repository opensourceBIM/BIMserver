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

public class IfcMechanicalConcreteMaterialProperties extends IfcMechanicalMaterialProperties 
{
 // The property attributes
 Double compressiveStrength;
 Double maxAggregateSize;
 String admixturesDescription;
 String workability;
 Double protectivePoreRatio;
 String waterImpermeability;


 // Getters and setters of properties

 public Double getCompressiveStrength() {
   return compressiveStrength;
 }
 public void setCompressiveStrength(String txt){
   Double value = i.toDouble(txt);
   this.compressiveStrength=value;

 }

 public Double getMaxAggregateSize() {
   return maxAggregateSize;
 }
 public void setMaxAggregateSize(String txt){
   Double value = i.toDouble(txt);
   this.maxAggregateSize=value;

 }

 public String getAdmixturesDescription() {
   return admixturesDescription;
 }
 public void setAdmixturesDescription(String value){
   this.admixturesDescription=value;

 }

 public String getWorkability() {
   return workability;
 }
 public void setWorkability(String value){
   this.workability=value;

 }

 public Double getProtectivePoreRatio() {
   return protectivePoreRatio;
 }
 public void setProtectivePoreRatio(String txt){
   Double value = i.toDouble(txt);
   this.protectivePoreRatio=value;

 }

 public String getWaterImpermeability() {
   return waterImpermeability;
 }
 public void setWaterImpermeability(String value){
   this.waterImpermeability=value;

 }

}
