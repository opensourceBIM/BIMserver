package fi.ni.ifc2x3;
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

public class IfcDimensionalExponents extends Thing 
{
 // The property attributes
 Long lengthExponent;
 Long massExponent;
 Long timeExponent;
 Long electricCurrentExponent;
 Long thermodynamicTemperatureExponent;
 Long amountOfSubstanceExponent;
 Long luminousIntensityExponent;


 // Getters and setters of properties

 public Long getLengthExponent() {
   return lengthExponent;
 }
 public void setLengthExponent(String txt){
   Long value = i.toLong(txt);
   this.lengthExponent=value;

 }

 public Long getMassExponent() {
   return massExponent;
 }
 public void setMassExponent(String txt){
   Long value = i.toLong(txt);
   this.massExponent=value;

 }

 public Long getTimeExponent() {
   return timeExponent;
 }
 public void setTimeExponent(String txt){
   Long value = i.toLong(txt);
   this.timeExponent=value;

 }

 public Long getElectricCurrentExponent() {
   return electricCurrentExponent;
 }
 public void setElectricCurrentExponent(String txt){
   Long value = i.toLong(txt);
   this.electricCurrentExponent=value;

 }

 public Long getThermodynamicTemperatureExponent() {
   return thermodynamicTemperatureExponent;
 }
 public void setThermodynamicTemperatureExponent(String txt){
   Long value = i.toLong(txt);
   this.thermodynamicTemperatureExponent=value;

 }

 public Long getAmountOfSubstanceExponent() {
   return amountOfSubstanceExponent;
 }
 public void setAmountOfSubstanceExponent(String txt){
   Long value = i.toLong(txt);
   this.amountOfSubstanceExponent=value;

 }

 public Long getLuminousIntensityExponent() {
   return luminousIntensityExponent;
 }
 public void setLuminousIntensityExponent(String txt){
   Long value = i.toLong(txt);
   this.luminousIntensityExponent=value;

 }

}
