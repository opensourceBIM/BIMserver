package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcSet;
import fi.ni.ifc2x3.interfaces.IfcActorSelect;
import fi.ni.ifc2x3.interfaces.IfcDateTimeSelect;

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

public class IfcCostSchedule extends IfcControl 
{
 // The property attributes
IfcActorSelect submittedBy;
IfcActorSelect preparedBy;
IfcDateTimeSelect submittedOn;
 String status;
 List<IfcActorSelect> targetUsers = new IfcSet<IfcActorSelect>();
IfcDateTimeSelect updateDate;
 String iD;
 String predefinedType;


 // Getters and setters of properties

 public IfcActorSelect getSubmittedBy() {
   return submittedBy;
 }
 public void setSubmittedBy(IfcActorSelect value){
   this.submittedBy=value;

 }

 public IfcActorSelect getPreparedBy() {
   return preparedBy;
 }
 public void setPreparedBy(IfcActorSelect value){
   this.preparedBy=value;

 }

 public IfcDateTimeSelect getSubmittedOn() {
   return submittedOn;
 }
 public void setSubmittedOn(IfcDateTimeSelect value){
   this.submittedOn=value;

 }

 public String getStatus() {
   return status;
 }
 public void setStatus(String value){
   this.status=value;

 }

 public List<IfcActorSelect> getTargetUsers() {
   return targetUsers;
 }
 public void setTargetUsers(IfcActorSelect value){
   this.targetUsers.add(value);

 }

 public IfcDateTimeSelect getUpdateDate() {
   return updateDate;
 }
 public void setUpdateDate(IfcDateTimeSelect value){
   this.updateDate=value;

 }

 public String getID() {
   return iD;
 }
 public void setID(String value){
   this.iD=value;

 }

 public String getPredefinedType() {
   return predefinedType;
 }
 public void setPredefinedType(String value){
   this.predefinedType=value;

 }

}
