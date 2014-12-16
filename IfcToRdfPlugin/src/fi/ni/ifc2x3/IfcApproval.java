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

public class IfcApproval extends Thing 
{
 // The property attributes
 String description;
IfcDateTimeSelect approvalDateTime;
 String approvalStatus;
 String approvalLevel;
 String approvalQualifier;
 String name;
 String identifier;
 // The inverse attributes

 InverseLinksList<IfcApprovalActorRelationship> actors= new InverseLinksList<IfcApprovalActorRelationship>();
 InverseLinksList<IfcApprovalRelationship> isRelatedWith= new InverseLinksList<IfcApprovalRelationship>();
 InverseLinksList<IfcApprovalRelationship> relates= new InverseLinksList<IfcApprovalRelationship>();


 // Getters and setters of properties

 public String getDescription() {
   return description;
 }
 public void setDescription(String value){
   this.description=value;

 }

 public IfcDateTimeSelect getApprovalDateTime() {
   return approvalDateTime;
 }
 public void setApprovalDateTime(IfcDateTimeSelect value){
   this.approvalDateTime=value;

 }

 public String getApprovalStatus() {
   return approvalStatus;
 }
 public void setApprovalStatus(String value){
   this.approvalStatus=value;

 }

 public String getApprovalLevel() {
   return approvalLevel;
 }
 public void setApprovalLevel(String value){
   this.approvalLevel=value;

 }

 public String getApprovalQualifier() {
   return approvalQualifier;
 }
 public void setApprovalQualifier(String value){
   this.approvalQualifier=value;

 }

 public String getName() {
   return name;
 }
 public void setName(String value){
   this.name=value;

 }

 public String getIdentifier() {
   return identifier;
 }
 public void setIdentifier(String value){
   this.identifier=value;

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcApprovalActorRelationship> getActors() {
   return actors;

 }
 public void setActors(IfcApprovalActorRelationship value){
   this.actors.add(value);

 }

 public InverseLinksList<IfcApprovalRelationship> getIsRelatedWith() {
   return isRelatedWith;

 }
 public void setIsRelatedWith(IfcApprovalRelationship value){
   this.isRelatedWith.add(value);

 }

 public InverseLinksList<IfcApprovalRelationship> getRelates() {
   return relates;

 }
 public void setRelates(IfcApprovalRelationship value){
   this.relates.add(value);

 }

}
