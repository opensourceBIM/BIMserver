package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcSet;
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

public class IfcSectionReinforcementProperties extends Thing 
{
 // The property attributes
 Double longitudinalStartPosition;
 Double longitudinalEndPosition;
 Double transversePosition;
 String reinforcementRole;
 IfcSectionProperties   sectionDefinition;
 List<IfcReinforcementBarProperties> crossSectionReinforcementDefinitions = new IfcSet<IfcReinforcementBarProperties>();


 // Getters and setters of properties

 public Double getLongitudinalStartPosition() {
   return longitudinalStartPosition;
 }
 public void setLongitudinalStartPosition(String txt){
   Double value = i.toDouble(txt);
   this.longitudinalStartPosition=value;

 }

 public Double getLongitudinalEndPosition() {
   return longitudinalEndPosition;
 }
 public void setLongitudinalEndPosition(String txt){
   Double value = i.toDouble(txt);
   this.longitudinalEndPosition=value;

 }

 public Double getTransversePosition() {
   return transversePosition;
 }
 public void setTransversePosition(String txt){
   Double value = i.toDouble(txt);
   this.transversePosition=value;

 }

 public String getReinforcementRole() {
   return reinforcementRole;
 }
 public void setReinforcementRole(String value){
   this.reinforcementRole=value;

 }

 public IfcSectionProperties getSectionDefinition() {
   return sectionDefinition;

 }
 public void setSectionDefinition(IfcSectionProperties value){
   this.sectionDefinition=value;

 }

 public List<IfcReinforcementBarProperties> getCrossSectionReinforcementDefinitions() {
   return crossSectionReinforcementDefinitions;

 }
 public void setCrossSectionReinforcementDefinitions(IfcReinforcementBarProperties value){
   this.crossSectionReinforcementDefinitions.add(value);

 }

}
