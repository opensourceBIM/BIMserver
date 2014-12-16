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

public class IfcOrganization extends Thing implements IfcActorSelect, IfcObjectReferenceSelect
{
 // The property attributes
 String id;
 String name;
 String description;
 List<IfcActorRole> roles = new IfcList<IfcActorRole>();
 List<IfcAddress> addresses = new IfcList<IfcAddress>();
 // The inverse attributes

 InverseLinksList<IfcOrganizationRelationship> isRelatedBy= new InverseLinksList<IfcOrganizationRelationship>();
 InverseLinksList<IfcOrganizationRelationship> relates= new InverseLinksList<IfcOrganizationRelationship>();
 InverseLinksList<IfcPersonAndOrganization> engages= new InverseLinksList<IfcPersonAndOrganization>();


 // Getters and setters of properties

 public String getId() {
   return id;
 }
 public void setId(String value){
   this.id=value;

 }

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

 public List<IfcActorRole> getRoles() {
   return roles;

 }
 public void setRoles(IfcActorRole value){
   this.roles.add(value);

 }

 public List<IfcAddress> getAddresses() {
   return addresses;

 }
 public void setAddresses(IfcAddress value){
   this.addresses.add(value);

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcOrganizationRelationship> getIsRelatedBy() {
   return isRelatedBy;

 }
 public void setIsRelatedBy(IfcOrganizationRelationship value){
   this.isRelatedBy.add(value);

 }

 public InverseLinksList<IfcOrganizationRelationship> getRelates() {
   return relates;

 }
 public void setRelates(IfcOrganizationRelationship value){
   this.relates.add(value);

 }

 public InverseLinksList<IfcPersonAndOrganization> getEngages() {
   return engages;

 }
 public void setEngages(IfcPersonAndOrganization value){
   this.engages.add(value);

 }

}
