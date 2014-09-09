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

public class IfcOpticalMaterialProperties extends IfcMaterialProperties 
{
 // The property attributes
 Double visibleTransmittance;
 Double solarTransmittance;
 Double thermalIrTransmittance;
 Double thermalIrEmissivityBack;
 Double thermalIrEmissivityFront;
 Double visibleReflectanceBack;
 Double visibleReflectanceFront;
 Double solarReflectanceFront;
 Double solarReflectanceBack;


 // Getters and setters of properties

 public Double getVisibleTransmittance() {
   return visibleTransmittance;
 }
 public void setVisibleTransmittance(String txt){
   Double value = i.toDouble(txt);
   this.visibleTransmittance=value;

 }

 public Double getSolarTransmittance() {
   return solarTransmittance;
 }
 public void setSolarTransmittance(String txt){
   Double value = i.toDouble(txt);
   this.solarTransmittance=value;

 }

 public Double getThermalIrTransmittance() {
   return thermalIrTransmittance;
 }
 public void setThermalIrTransmittance(String txt){
   Double value = i.toDouble(txt);
   this.thermalIrTransmittance=value;

 }

 public Double getThermalIrEmissivityBack() {
   return thermalIrEmissivityBack;
 }
 public void setThermalIrEmissivityBack(String txt){
   Double value = i.toDouble(txt);
   this.thermalIrEmissivityBack=value;

 }

 public Double getThermalIrEmissivityFront() {
   return thermalIrEmissivityFront;
 }
 public void setThermalIrEmissivityFront(String txt){
   Double value = i.toDouble(txt);
   this.thermalIrEmissivityFront=value;

 }

 public Double getVisibleReflectanceBack() {
   return visibleReflectanceBack;
 }
 public void setVisibleReflectanceBack(String txt){
   Double value = i.toDouble(txt);
   this.visibleReflectanceBack=value;

 }

 public Double getVisibleReflectanceFront() {
   return visibleReflectanceFront;
 }
 public void setVisibleReflectanceFront(String txt){
   Double value = i.toDouble(txt);
   this.visibleReflectanceFront=value;

 }

 public Double getSolarReflectanceFront() {
   return solarReflectanceFront;
 }
 public void setSolarReflectanceFront(String txt){
   Double value = i.toDouble(txt);
   this.solarReflectanceFront=value;

 }

 public Double getSolarReflectanceBack() {
   return solarReflectanceBack;
 }
 public void setSolarReflectanceBack(String txt){
   Double value = i.toDouble(txt);
   this.solarReflectanceBack=value;

 }

}
