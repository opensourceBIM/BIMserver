package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcList;
import fi.ni.ifc2x3.interfaces.IfcUnit;

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

public class IfcPropertyTableValue extends IfcSimpleProperty 
{
 // The property attributes
 List<String> definingValues = new IfcList<String>();
 List<String> definedValues = new IfcList<String>();
 String expression;
IfcUnit definingUnit;
IfcUnit definedUnit;


 // Getters and setters of properties

 public List<String> getDefiningValues() {
   return definingValues;
 }
 public void setDefiningValues(String value){
   this.definingValues.add(value);

 }

 public List<String> getDefinedValues() {
   return definedValues;
 }
 public void setDefinedValues(String value){
   this.definedValues.add(value);

 }

 public String getExpression() {
   return expression;
 }
 public void setExpression(String value){
   this.expression=value;

 }

 public IfcUnit getDefiningUnit() {
   return definingUnit;
 }
 public void setDefiningUnit(IfcUnit value){
   this.definingUnit=value;

 }

 public IfcUnit getDefinedUnit() {
   return definedUnit;
 }
 public void setDefinedUnit(IfcUnit value){
   this.definedUnit=value;

 }

}
