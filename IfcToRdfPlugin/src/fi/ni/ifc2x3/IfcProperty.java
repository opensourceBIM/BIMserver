package fi.ni.ifc2x3;
import fi.ni.InverseLinksList;
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

public class IfcProperty extends Thing 
{
 // The property attributes
 String name;
 String description;
 // The inverse attributes

 InverseLinksList<IfcPropertyDependencyRelationship> propertyForDependance= new InverseLinksList<IfcPropertyDependencyRelationship>();
 InverseLinksList<IfcPropertyDependencyRelationship> propertyDependsOn= new InverseLinksList<IfcPropertyDependencyRelationship>();
 InverseLinksList<IfcComplexProperty> partOfComplex= new InverseLinksList<IfcComplexProperty>();


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

 // Getters and setters of inverse values

 public InverseLinksList<IfcPropertyDependencyRelationship> getPropertyForDependance() {
   return propertyForDependance;

 }
 public void setPropertyForDependance(IfcPropertyDependencyRelationship value){
   this.propertyForDependance.add(value);

 }

 public InverseLinksList<IfcPropertyDependencyRelationship> getPropertyDependsOn() {
   return propertyDependsOn;

 }
 public void setPropertyDependsOn(IfcPropertyDependencyRelationship value){
   this.propertyDependsOn.add(value);

 }

 public InverseLinksList<IfcComplexProperty> getPartOfComplex() {
   return partOfComplex;

 }
 public void setPartOfComplex(IfcComplexProperty value){
   this.partOfComplex.add(value);

 }

}
