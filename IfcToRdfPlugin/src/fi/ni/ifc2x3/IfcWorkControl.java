package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcSet;
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

public class IfcWorkControl extends IfcControl 
{
 // The property attributes
 String identifier;
IfcDateTimeSelect creationDate;
 List<IfcPerson> creators = new IfcSet<IfcPerson>();
 String purpose;
 Double duration;
 Double totalFloat;
IfcDateTimeSelect startTime;
IfcDateTimeSelect finishTime;
 String workControlType;
 String userDefinedControlType;


 // Getters and setters of properties

 public String getIdentifier() {
   return identifier;
 }
 public void setIdentifier(String value){
   this.identifier=value;

 }

 public IfcDateTimeSelect getCreationDate() {
   return creationDate;
 }
 public void setCreationDate(IfcDateTimeSelect value){
   this.creationDate=value;

 }

 public List<IfcPerson> getCreators() {
   return creators;

 }
 public void setCreators(IfcPerson value){
   this.creators.add(value);

 }

 public String getPurpose() {
   return purpose;
 }
 public void setPurpose(String value){
   this.purpose=value;

 }

 public Double getDuration() {
   return duration;
 }
 public void setDuration(String txt){
   Double value = i.toDouble(txt);
   this.duration=value;

 }

 public Double getTotalFloat() {
   return totalFloat;
 }
 public void setTotalFloat(String txt){
   Double value = i.toDouble(txt);
   this.totalFloat=value;

 }

 public IfcDateTimeSelect getStartTime() {
   return startTime;
 }
 public void setStartTime(IfcDateTimeSelect value){
   this.startTime=value;

 }

 public IfcDateTimeSelect getFinishTime() {
   return finishTime;
 }
 public void setFinishTime(IfcDateTimeSelect value){
   this.finishTime=value;

 }

 public String getWorkControlType() {
   return workControlType;
 }
 public void setWorkControlType(String value){
   this.workControlType=value;

 }

 public String getUserDefinedControlType() {
   return userDefinedControlType;
 }
 public void setUserDefinedControlType(String value){
   this.userDefinedControlType=value;

 }

}
