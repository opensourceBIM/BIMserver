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

public class IfcAppliedValue extends Thing implements IfcObjectReferenceSelect
{
 // The property attributes
 String name;
 String description;
IfcAppliedValueSelect appliedValue;
 IfcMeasureWithUnit   unitBasis;
IfcDateTimeSelect applicableDate;
IfcDateTimeSelect fixedUntilDate;
 // The inverse attributes

 InverseLinksList<IfcReferencesValueDocument> valuesReferenced= new InverseLinksList<IfcReferencesValueDocument>();
 InverseLinksList<IfcAppliedValueRelationship> valueOfComponents= new InverseLinksList<IfcAppliedValueRelationship>();
 InverseLinksList<IfcAppliedValueRelationship> isComponentIn= new InverseLinksList<IfcAppliedValueRelationship>();


 // Getters and setters of properties

 public String getName() {
   return name;
 }
 public void setName(String value){
   this.name=value;

 }

 public String getDescription() {
   return description;
 }
 public void setDescription(String value){
   this.description=value;

 }

 public IfcAppliedValueSelect getAppliedValue() {
   return appliedValue;
 }
 public void setAppliedValue(IfcAppliedValueSelect value){
   this.appliedValue=value;

 }

 public IfcMeasureWithUnit getUnitBasis() {
   return unitBasis;

 }
 public void setUnitBasis(IfcMeasureWithUnit value){
   this.unitBasis=value;

 }

 public IfcDateTimeSelect getApplicableDate() {
   return applicableDate;
 }
 public void setApplicableDate(IfcDateTimeSelect value){
   this.applicableDate=value;

 }

 public IfcDateTimeSelect getFixedUntilDate() {
   return fixedUntilDate;
 }
 public void setFixedUntilDate(IfcDateTimeSelect value){
   this.fixedUntilDate=value;

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcReferencesValueDocument> getValuesReferenced() {
   return valuesReferenced;

 }
 public void setValuesReferenced(IfcReferencesValueDocument value){
   this.valuesReferenced.add(value);

 }

 public InverseLinksList<IfcAppliedValueRelationship> getValueOfComponents() {
   return valueOfComponents;

 }
 public void setValueOfComponents(IfcAppliedValueRelationship value){
   this.valueOfComponents.add(value);

 }

 public InverseLinksList<IfcAppliedValueRelationship> getIsComponentIn() {
   return isComponentIn;

 }
 public void setIsComponentIn(IfcAppliedValueRelationship value){
   this.isComponentIn.add(value);

 }

}
