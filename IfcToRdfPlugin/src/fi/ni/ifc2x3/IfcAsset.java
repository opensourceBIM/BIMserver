package fi.ni.ifc2x3;
import fi.ni.ifc2x3.interfaces.IfcActorSelect;

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

public class IfcAsset extends IfcGroup 
{
 // The property attributes
 String assetID;
 IfcCostValue   originalValue;
 IfcCostValue   currentValue;
 IfcCostValue   totalReplacementCost;
IfcActorSelect owner;
IfcActorSelect user;
 IfcPerson   responsiblePerson;
 IfcCalendarDate   incorporationDate;
 IfcCostValue   depreciatedValue;


 // Getters and setters of properties

 public String getAssetID() {
   return assetID;
 }
 public void setAssetID(String value){
   this.assetID=value;

 }

 public IfcCostValue getOriginalValue() {
   return originalValue;

 }
 public void setOriginalValue(IfcCostValue value){
   this.originalValue=value;

 }

 public IfcCostValue getCurrentValue() {
   return currentValue;

 }
 public void setCurrentValue(IfcCostValue value){
   this.currentValue=value;

 }

 public IfcCostValue getTotalReplacementCost() {
   return totalReplacementCost;

 }
 public void setTotalReplacementCost(IfcCostValue value){
   this.totalReplacementCost=value;

 }

 public IfcActorSelect getOwner() {
   return owner;
 }
 public void setOwner(IfcActorSelect value){
   this.owner=value;

 }

 public IfcActorSelect getUser() {
   return user;
 }
 public void setUser(IfcActorSelect value){
   this.user=value;

 }

 public IfcPerson getResponsiblePerson() {
   return responsiblePerson;

 }
 public void setResponsiblePerson(IfcPerson value){
   this.responsiblePerson=value;

 }

 public IfcCalendarDate getIncorporationDate() {
   return incorporationDate;

 }
 public void setIncorporationDate(IfcCalendarDate value){
   this.incorporationDate=value;

 }

 public IfcCostValue getDepreciatedValue() {
   return depreciatedValue;

 }
 public void setDepreciatedValue(IfcCostValue value){
   this.depreciatedValue=value;

 }

}
