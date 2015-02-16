package fi.ni.ifc2x3;
import java.util.Date;

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

public class IfcOwnerHistory extends Thing 
{
 // The property attributes
 IfcPersonAndOrganization   owningUser;
 IfcApplication   owningApplication;
 String state;
 String changeAction;
 Date lastModifiedDate;
 IfcPersonAndOrganization   lastModifyingUser;
 IfcApplication   lastModifyingApplication;
 Date creationDate;


 // Getters and setters of properties

 public IfcPersonAndOrganization getOwningUser() {
   return owningUser;

 }
 public void setOwningUser(IfcPersonAndOrganization value){
   this.owningUser=value;

 }

 public IfcApplication getOwningApplication() {
   return owningApplication;

 }
 public void setOwningApplication(IfcApplication value){
   this.owningApplication=value;

 }

 public String getState() {
   return state;
 }
 public void setState(String value){
   this.state=value;

 }

 public String getChangeAction() {
   return changeAction;
 }
 public void setChangeAction(String value){
   this.changeAction=value;

 }

 public Date getLastModifiedDate() {
   return lastModifiedDate;
 }
 public void setLastModifiedDate(String txt){
   Date value = new Date(1000l * i.toLong(txt) );
   this.lastModifiedDate=value;

 }

 public IfcPersonAndOrganization getLastModifyingUser() {
   return lastModifyingUser;

 }
 public void setLastModifyingUser(IfcPersonAndOrganization value){
   this.lastModifyingUser=value;

 }

 public IfcApplication getLastModifyingApplication() {
   return lastModifyingApplication;

 }
 public void setLastModifyingApplication(IfcApplication value){
   this.lastModifyingApplication=value;

 }

 public Date getCreationDate() {
   return creationDate;
 }
 public void setCreationDate(String txt){
   Date value = new Date(1000l * i.toLong(txt) );
   this.creationDate=value;

 }

}
