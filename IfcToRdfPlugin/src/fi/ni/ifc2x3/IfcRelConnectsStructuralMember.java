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

public class IfcRelConnectsStructuralMember extends IfcRelConnects 
{
 // The property attributes
 IfcStructuralMember   relatingStructuralMember;
 IfcStructuralConnection   relatedStructuralConnection;
 IfcBoundaryCondition   appliedCondition;
 IfcStructuralConnectionCondition   additionalConditions;
 Double supportedLength;
 IfcAxis2Placement3D   conditionCoordinateSystem;


 // Getters and setters of properties

 public IfcStructuralMember getRelatingStructuralMember() {
   return relatingStructuralMember;

 }
 public void setRelatingStructuralMember(IfcStructuralMember value){
   this.relatingStructuralMember=value;

 }

 public IfcStructuralConnection getRelatedStructuralConnection() {
   return relatedStructuralConnection;

 }
 public void setRelatedStructuralConnection(IfcStructuralConnection value){
   this.relatedStructuralConnection=value;

 }

 public IfcBoundaryCondition getAppliedCondition() {
   return appliedCondition;

 }
 public void setAppliedCondition(IfcBoundaryCondition value){
   this.appliedCondition=value;

 }

 public IfcStructuralConnectionCondition getAdditionalConditions() {
   return additionalConditions;

 }
 public void setAdditionalConditions(IfcStructuralConnectionCondition value){
   this.additionalConditions=value;

 }

 public Double getSupportedLength() {
   return supportedLength;
 }
 public void setSupportedLength(String txt){
   Double value = i.toDouble(txt);
   this.supportedLength=value;

 }

 public IfcAxis2Placement3D getConditionCoordinateSystem() {
   return conditionCoordinateSystem;

 }
 public void setConditionCoordinateSystem(IfcAxis2Placement3D value){
   this.conditionCoordinateSystem=value;

 }

}
