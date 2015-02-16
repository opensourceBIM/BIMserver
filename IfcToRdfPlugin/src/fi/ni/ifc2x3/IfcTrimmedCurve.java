package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcSet;
import fi.ni.ifc2x3.interfaces.IfcTrimmingSelect;

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

public class IfcTrimmedCurve extends IfcBoundedCurve 
{
 // The property attributes
 IfcCurve   basisCurve;
 List<IfcTrimmingSelect> trim1 = new IfcSet<IfcTrimmingSelect>();
 List<IfcTrimmingSelect> trim2 = new IfcSet<IfcTrimmingSelect>();
 String senseAgreement;
 String masterRepresentation;


 // Getters and setters of properties

 public IfcCurve getBasisCurve() {
   return basisCurve;

 }
 public void setBasisCurve(IfcCurve value){
   this.basisCurve=value;

 }

 public List<IfcTrimmingSelect> getTrim1() {
   return trim1;
 }
 public void setTrim1(IfcTrimmingSelect value){
   this.trim1.add(value);

 }

 public List<IfcTrimmingSelect> getTrim2() {
   return trim2;
 }
 public void setTrim2(IfcTrimmingSelect value){
   this.trim2.add(value);

 }

 public String getSenseAgreement() {
   return senseAgreement;
 }
 public void setSenseAgreement(String value){
   this.senseAgreement=value;

 }

 public String getMasterRepresentation() {
   return masterRepresentation;
 }
 public void setMasterRepresentation(String value){
   this.masterRepresentation=value;

 }

}
