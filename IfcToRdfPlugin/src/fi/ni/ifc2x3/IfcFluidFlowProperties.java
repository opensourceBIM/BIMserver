package fi.ni.ifc2x3;

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

public class IfcFluidFlowProperties extends IfcPropertySetDefinition 
{
 // The property attributes
 String propertySource;
 IfcTimeSeries   flowConditionTimeSeries;
 IfcTimeSeries   velocityTimeSeries;
 IfcTimeSeries   flowrateTimeSeries;
 IfcMaterial   fluid;
 IfcTimeSeries   pressureTimeSeries;
 String userDefinedPropertySource;
 Double temperatureSingleValue;
 Double wetBulbTemperatureSingleValue;
 IfcTimeSeries   wetBulbTemperatureTimeSeries;
 IfcTimeSeries   temperatureTimeSeries;
 String flowrateSingleValue;
 Double flowConditionSingleValue;
 Double velocitySingleValue;
 Double pressureSingleValue;


 // Getters and setters of properties

 public String getPropertySource() {
   return propertySource;
 }
 public void setPropertySource(String value){
   this.propertySource=value;

 }

 public IfcTimeSeries getFlowConditionTimeSeries() {
   return flowConditionTimeSeries;

 }
 public void setFlowConditionTimeSeries(IfcTimeSeries value){
   this.flowConditionTimeSeries=value;

 }

 public IfcTimeSeries getVelocityTimeSeries() {
   return velocityTimeSeries;

 }
 public void setVelocityTimeSeries(IfcTimeSeries value){
   this.velocityTimeSeries=value;

 }

 public IfcTimeSeries getFlowrateTimeSeries() {
   return flowrateTimeSeries;

 }
 public void setFlowrateTimeSeries(IfcTimeSeries value){
   this.flowrateTimeSeries=value;

 }

 public IfcMaterial getFluid() {
   return fluid;

 }
 public void setFluid(IfcMaterial value){
   this.fluid=value;

 }

 public IfcTimeSeries getPressureTimeSeries() {
   return pressureTimeSeries;

 }
 public void setPressureTimeSeries(IfcTimeSeries value){
   this.pressureTimeSeries=value;

 }

 public String getUserDefinedPropertySource() {
   return userDefinedPropertySource;
 }
 public void setUserDefinedPropertySource(String value){
   this.userDefinedPropertySource=value;

 }

 public Double getTemperatureSingleValue() {
   return temperatureSingleValue;
 }
 public void setTemperatureSingleValue(String txt){
   Double value = i.toDouble(txt);
   this.temperatureSingleValue=value;

 }

 public Double getWetBulbTemperatureSingleValue() {
   return wetBulbTemperatureSingleValue;
 }
 public void setWetBulbTemperatureSingleValue(String txt){
   Double value = i.toDouble(txt);
   this.wetBulbTemperatureSingleValue=value;

 }

 public IfcTimeSeries getWetBulbTemperatureTimeSeries() {
   return wetBulbTemperatureTimeSeries;

 }
 public void setWetBulbTemperatureTimeSeries(IfcTimeSeries value){
   this.wetBulbTemperatureTimeSeries=value;

 }

 public IfcTimeSeries getTemperatureTimeSeries() {
   return temperatureTimeSeries;

 }
 public void setTemperatureTimeSeries(IfcTimeSeries value){
   this.temperatureTimeSeries=value;

 }

 public String getFlowrateSingleValue() {
   return flowrateSingleValue;
 }
 public void setFlowrateSingleValue(String value){
   this.flowrateSingleValue=value;

 }

 public Double getFlowConditionSingleValue() {
   return flowConditionSingleValue;
 }
 public void setFlowConditionSingleValue(String txt){
   Double value = i.toDouble(txt);
   this.flowConditionSingleValue=value;

 }

 public Double getVelocitySingleValue() {
   return velocitySingleValue;
 }
 public void setVelocitySingleValue(String txt){
   Double value = i.toDouble(txt);
   this.velocitySingleValue=value;

 }

 public Double getPressureSingleValue() {
   return pressureSingleValue;
 }
 public void setPressureSingleValue(String txt){
   Double value = i.toDouble(txt);
   this.pressureSingleValue=value;

 }

}
