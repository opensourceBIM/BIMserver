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

public class IfcElectricalBaseProperties extends IfcEnergyProperties 
{
 // The property attributes
 String electricCurrentType;
 Double inputVoltage;
 Double inputFrequency;
 Double fullLoadCurrent;
 Double minimumCircuitCurrent;
 Double maximumPowerInput;
 Double ratedPowerInput;
 Long inputPhase;


 // Getters and setters of properties

 public String getElectricCurrentType() {
   return electricCurrentType;
 }
 public void setElectricCurrentType(String value){
   this.electricCurrentType=value;

 }

 public Double getInputVoltage() {
   return inputVoltage;
 }
 public void setInputVoltage(String txt){
   Double value = i.toDouble(txt);
   this.inputVoltage=value;

 }

 public Double getInputFrequency() {
   return inputFrequency;
 }
 public void setInputFrequency(String txt){
   Double value = i.toDouble(txt);
   this.inputFrequency=value;

 }

 public Double getFullLoadCurrent() {
   return fullLoadCurrent;
 }
 public void setFullLoadCurrent(String txt){
   Double value = i.toDouble(txt);
   this.fullLoadCurrent=value;

 }

 public Double getMinimumCircuitCurrent() {
   return minimumCircuitCurrent;
 }
 public void setMinimumCircuitCurrent(String txt){
   Double value = i.toDouble(txt);
   this.minimumCircuitCurrent=value;

 }

 public Double getMaximumPowerInput() {
   return maximumPowerInput;
 }
 public void setMaximumPowerInput(String txt){
   Double value = i.toDouble(txt);
   this.maximumPowerInput=value;

 }

 public Double getRatedPowerInput() {
   return ratedPowerInput;
 }
 public void setRatedPowerInput(String txt){
   Double value = i.toDouble(txt);
   this.ratedPowerInput=value;

 }

 public Long getInputPhase() {
   return inputPhase;
 }
 public void setInputPhase(String txt){
   Long value = i.toLong(txt);
   this.inputPhase=value;

 }

}
