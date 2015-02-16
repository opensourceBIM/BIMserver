package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcList;
import fi.ni.InverseLinksList;
import fi.ni.Thing;
import fi.ni.ifc2x3.interfaces.IfcActorSelect;
import fi.ni.ifc2x3.interfaces.IfcObjectReferenceSelect;

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

public class IfcPerson extends Thing implements IfcActorSelect, IfcObjectReferenceSelect
{
 // The property attributes
 String id;
 String familyName;
 String givenName;
 List<String> middleNames = new IfcList<String>();
 List<String> prefixTitles = new IfcList<String>();
 List<String> suffixTitles = new IfcList<String>();
 List<IfcActorRole> roles = new IfcList<IfcActorRole>();
 List<IfcAddress> addresses = new IfcList<IfcAddress>();
 // The inverse attributes

 InverseLinksList<IfcPersonAndOrganization> engagedIn= new InverseLinksList<IfcPersonAndOrganization>();


 // Getters and setters of properties

 public String getId() {
   return id;
 }
 public void setId(String value){
   this.id=value;

 }

 public String getFamilyName() {
   return familyName;
 }
 public void setFamilyName(String value){
   this.familyName=value;

 }

 public String getGivenName() {
   return givenName;
 }
 public void setGivenName(String value){
   this.givenName=value;

 }

 public List<String> getMiddleNames() {
   return middleNames;
 }
 public void setMiddleNames(String value){
   this.middleNames.add(value);

 }

 public List<String> getPrefixTitles() {
   return prefixTitles;
 }
 public void setPrefixTitles(String value){
   this.prefixTitles.add(value);

 }

 public List<String> getSuffixTitles() {
   return suffixTitles;
 }
 public void setSuffixTitles(String value){
   this.suffixTitles.add(value);

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

 public InverseLinksList<IfcPersonAndOrganization> getEngagedIn() {
   return engagedIn;

 }
 public void setEngagedIn(IfcPersonAndOrganization value){
   this.engagedIn.add(value);

 }

}
