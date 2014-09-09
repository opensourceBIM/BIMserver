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

public class IfcConstraint extends Thing 
{
 // The property attributes
 String name;
 String description;
 String constraintGrade;
 String constraintSource;
IfcActorSelect creatingActor;
IfcDateTimeSelect creationTime;
 String userDefinedGrade;
 // The inverse attributes

 InverseLinksList<IfcConstraintClassificationRelationship> classifiedAs= new InverseLinksList<IfcConstraintClassificationRelationship>();
 InverseLinksList<IfcConstraintRelationship> relatesConstraints= new InverseLinksList<IfcConstraintRelationship>();
 InverseLinksList<IfcConstraintRelationship> isRelatedWith= new InverseLinksList<IfcConstraintRelationship>();
 InverseLinksList<IfcPropertyConstraintRelationship> propertiesForConstraint= new InverseLinksList<IfcPropertyConstraintRelationship>();
 InverseLinksList<IfcConstraintAggregationRelationship> aggregates= new InverseLinksList<IfcConstraintAggregationRelationship>();
 InverseLinksList<IfcConstraintAggregationRelationship> isAggregatedIn= new InverseLinksList<IfcConstraintAggregationRelationship>();


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

 public String getConstraintGrade() {
   return constraintGrade;
 }
 public void setConstraintGrade(String value){
   this.constraintGrade=value;

 }

 public String getConstraintSource() {
   return constraintSource;
 }
 public void setConstraintSource(String value){
   this.constraintSource=value;

 }

 public IfcActorSelect getCreatingActor() {
   return creatingActor;
 }
 public void setCreatingActor(IfcActorSelect value){
   this.creatingActor=value;

 }

 public IfcDateTimeSelect getCreationTime() {
   return creationTime;
 }
 public void setCreationTime(IfcDateTimeSelect value){
   this.creationTime=value;

 }

 public String getUserDefinedGrade() {
   return userDefinedGrade;
 }
 public void setUserDefinedGrade(String value){
   this.userDefinedGrade=value;

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcConstraintClassificationRelationship> getClassifiedAs() {
   return classifiedAs;

 }
 public void setClassifiedAs(IfcConstraintClassificationRelationship value){
   this.classifiedAs.add(value);

 }

 public InverseLinksList<IfcConstraintRelationship> getRelatesConstraints() {
   return relatesConstraints;

 }
 public void setRelatesConstraints(IfcConstraintRelationship value){
   this.relatesConstraints.add(value);

 }

 public InverseLinksList<IfcConstraintRelationship> getIsRelatedWith() {
   return isRelatedWith;

 }
 public void setIsRelatedWith(IfcConstraintRelationship value){
   this.isRelatedWith.add(value);

 }

 public InverseLinksList<IfcPropertyConstraintRelationship> getPropertiesForConstraint() {
   return propertiesForConstraint;

 }
 public void setPropertiesForConstraint(IfcPropertyConstraintRelationship value){
   this.propertiesForConstraint.add(value);

 }

 public InverseLinksList<IfcConstraintAggregationRelationship> getAggregates() {
   return aggregates;

 }
 public void setAggregates(IfcConstraintAggregationRelationship value){
   this.aggregates.add(value);

 }

 public InverseLinksList<IfcConstraintAggregationRelationship> getIsAggregatedIn() {
   return isAggregatedIn;

 }
 public void setIsAggregatedIn(IfcConstraintAggregationRelationship value){
   this.isAggregatedIn.add(value);

 }

}
