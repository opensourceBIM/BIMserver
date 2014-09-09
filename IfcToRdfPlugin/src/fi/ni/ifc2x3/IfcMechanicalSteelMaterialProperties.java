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

public class IfcMechanicalSteelMaterialProperties extends IfcMechanicalMaterialProperties 
{
 // The property attributes
 Double yieldStress;
 Double ultimateStress;
 Double ultimateStrain;
 Double hardeningModule;
 Double proportionalStress;
 Double plasticStrain;
 List<IfcRelaxation> relaxations = new IfcSet<IfcRelaxation>();


 // Getters and setters of properties

 public Double getYieldStress() {
   return yieldStress;
 }
 public void setYieldStress(String txt){
   Double value = i.toDouble(txt);
   this.yieldStress=value;

 }

 public Double getUltimateStress() {
   return ultimateStress;
 }
 public void setUltimateStress(String txt){
   Double value = i.toDouble(txt);
   this.ultimateStress=value;

 }

 public Double getUltimateStrain() {
   return ultimateStrain;
 }
 public void setUltimateStrain(String txt){
   Double value = i.toDouble(txt);
   this.ultimateStrain=value;

 }

 public Double getHardeningModule() {
   return hardeningModule;
 }
 public void setHardeningModule(String txt){
   Double value = i.toDouble(txt);
   this.hardeningModule=value;

 }

 public Double getProportionalStress() {
   return proportionalStress;
 }
 public void setProportionalStress(String txt){
   Double value = i.toDouble(txt);
   this.proportionalStress=value;

 }

 public Double getPlasticStrain() {
   return plasticStrain;
 }
 public void setPlasticStrain(String txt){
   Double value = i.toDouble(txt);
   this.plasticStrain=value;

 }

 public List<IfcRelaxation> getRelaxations() {
   return relaxations;

 }
 public void setRelaxations(IfcRelaxation value){
   this.relaxations.add(value);

 }

}
