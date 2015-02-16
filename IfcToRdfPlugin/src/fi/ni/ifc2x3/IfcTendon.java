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

public class IfcTendon extends IfcReinforcingElement 
{
 // The property attributes
 String predefinedType;
 Double nominalDiameter;
 Double crossSectionArea;
 Double tensionForce;
 Double preStress;
 Double frictionCoefficient;
 Double anchorageSlip;
 Double minCurvatureRadius;


 // Getters and setters of properties

 public String getPredefinedType() {
   return predefinedType;
 }
 public void setPredefinedType(String value){
   this.predefinedType=value;

 }

 public Double getNominalDiameter() {
   return nominalDiameter;
 }
 public void setNominalDiameter(String txt){
   Double value = i.toDouble(txt);
   this.nominalDiameter=value;

 }

 public Double getCrossSectionArea() {
   return crossSectionArea;
 }
 public void setCrossSectionArea(String txt){
   Double value = i.toDouble(txt);
   this.crossSectionArea=value;

 }

 public Double getTensionForce() {
   return tensionForce;
 }
 public void setTensionForce(String txt){
   Double value = i.toDouble(txt);
   this.tensionForce=value;

 }

 public Double getPreStress() {
   return preStress;
 }
 public void setPreStress(String txt){
   Double value = i.toDouble(txt);
   this.preStress=value;

 }

 public Double getFrictionCoefficient() {
   return frictionCoefficient;
 }
 public void setFrictionCoefficient(String txt){
   Double value = i.toDouble(txt);
   this.frictionCoefficient=value;

 }

 public Double getAnchorageSlip() {
   return anchorageSlip;
 }
 public void setAnchorageSlip(String txt){
   Double value = i.toDouble(txt);
   this.anchorageSlip=value;

 }

 public Double getMinCurvatureRadius() {
   return minCurvatureRadius;
 }
 public void setMinCurvatureRadius(String txt){
   Double value = i.toDouble(txt);
   this.minCurvatureRadius=value;

 }

}
