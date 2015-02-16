package fi.ni.ifc2x3;
import fi.ni.Thing;

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

public class IfcReinforcementBarProperties extends Thing 
{
 // The property attributes
 Double totalCrossSectionArea;
 String steelGrade;
 String barSurface;
 Double effectiveDepth;
 Double nominalBarDiameter;
 String barCount;


 // Getters and setters of properties

 public Double getTotalCrossSectionArea() {
   return totalCrossSectionArea;
 }
 public void setTotalCrossSectionArea(String txt){
   Double value = i.toDouble(txt);
   this.totalCrossSectionArea=value;

 }

 public String getSteelGrade() {
   return steelGrade;
 }
 public void setSteelGrade(String value){
   this.steelGrade=value;

 }

 public String getBarSurface() {
   return barSurface;
 }
 public void setBarSurface(String value){
   this.barSurface=value;

 }

 public Double getEffectiveDepth() {
   return effectiveDepth;
 }
 public void setEffectiveDepth(String txt){
   Double value = i.toDouble(txt);
   this.effectiveDepth=value;

 }

 public Double getNominalBarDiameter() {
   return nominalBarDiameter;
 }
 public void setNominalBarDiameter(String txt){
   Double value = i.toDouble(txt);
   this.nominalBarDiameter=value;

 }

 public String getBarCount() {
   return barCount;
 }
 public void setBarCount(String value){
   this.barCount=value;

 }

}
