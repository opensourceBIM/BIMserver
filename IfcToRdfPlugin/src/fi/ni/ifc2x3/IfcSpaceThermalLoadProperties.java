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

public class IfcSpaceThermalLoadProperties extends IfcPropertySetDefinition 
{
 // The property attributes
 Double applicableValueRatio;
 String thermalLoadSource;
 String propertySource;
 String sourceDescription;
 Double maximumValue;
 Double minimumValue;
 IfcTimeSeries   thermalLoadTimeSeriesValues;
 String userDefinedThermalLoadSource;
 String userDefinedPropertySource;
 String thermalLoadType;


 // Getters and setters of properties

 public Double getApplicableValueRatio() {
   return applicableValueRatio;
 }
 public void setApplicableValueRatio(String txt){
   Double value = i.toDouble(txt);
   this.applicableValueRatio=value;

 }

 public String getThermalLoadSource() {
   return thermalLoadSource;
 }
 public void setThermalLoadSource(String value){
   this.thermalLoadSource=value;

 }

 public String getPropertySource() {
   return propertySource;
 }
 public void setPropertySource(String value){
   this.propertySource=value;

 }

 public String getSourceDescription() {
   return sourceDescription;
 }
 public void setSourceDescription(String value){
   this.sourceDescription=value;

 }

 public Double getMaximumValue() {
   return maximumValue;
 }
 public void setMaximumValue(String txt){
   Double value = i.toDouble(txt);
   this.maximumValue=value;

 }

 public Double getMinimumValue() {
   return minimumValue;
 }
 public void setMinimumValue(String txt){
   Double value = i.toDouble(txt);
   this.minimumValue=value;

 }

 public IfcTimeSeries getThermalLoadTimeSeriesValues() {
   return thermalLoadTimeSeriesValues;

 }
 public void setThermalLoadTimeSeriesValues(IfcTimeSeries value){
   this.thermalLoadTimeSeriesValues=value;

 }

 public String getUserDefinedThermalLoadSource() {
   return userDefinedThermalLoadSource;
 }
 public void setUserDefinedThermalLoadSource(String value){
   this.userDefinedThermalLoadSource=value;

 }

 public String getUserDefinedPropertySource() {
   return userDefinedPropertySource;
 }
 public void setUserDefinedPropertySource(String value){
   this.userDefinedPropertySource=value;

 }

 public String getThermalLoadType() {
   return thermalLoadType;
 }
 public void setThermalLoadType(String value){
   this.thermalLoadType=value;

 }

}
