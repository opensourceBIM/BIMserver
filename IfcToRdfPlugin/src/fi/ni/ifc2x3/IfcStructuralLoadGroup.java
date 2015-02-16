package fi.ni.ifc2x3;
import fi.ni.InverseLinksList;

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

public class IfcStructuralLoadGroup extends IfcGroup 
{
 // The property attributes
 String predefinedType;
 String actionType;
 String actionSource;
 Double coefficient;
 String purpose;
 // The inverse attributes

 InverseLinksList<IfcStructuralResultGroup> sourceOfResultGroup= new InverseLinksList<IfcStructuralResultGroup>();
 InverseLinksList<IfcStructuralAnalysisModel> loadGroupFor= new InverseLinksList<IfcStructuralAnalysisModel>();


 // Getters and setters of properties

 public String getPredefinedType() {
   return predefinedType;
 }
 public void setPredefinedType(String value){
   this.predefinedType=value;

 }

 public String getActionType() {
   return actionType;
 }
 public void setActionType(String value){
   this.actionType=value;

 }

 public String getActionSource() {
   return actionSource;
 }
 public void setActionSource(String value){
   this.actionSource=value;

 }

 public Double getCoefficient() {
   return coefficient;
 }
 public void setCoefficient(String txt){
   Double value = i.toDouble(txt);
   this.coefficient=value;

 }

 public String getPurpose() {
   return purpose;
 }
 public void setPurpose(String value){
   this.purpose=value;

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcStructuralResultGroup> getSourceOfResultGroup() {
   return sourceOfResultGroup;

 }
 public void setSourceOfResultGroup(IfcStructuralResultGroup value){
   this.sourceOfResultGroup.add(value);

 }

 public InverseLinksList<IfcStructuralAnalysisModel> getLoadGroupFor() {
   return loadGroupFor;

 }
 public void setLoadGroupFor(IfcStructuralAnalysisModel value){
   this.loadGroupFor.add(value);

 }

}
