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

public class IfcStructuralProfileProperties extends IfcGeneralProfileProperties 
{
 // The property attributes
 Double torsionalConstantX;
 Double momentOfInertiaYZ;
 Double momentOfInertiaY;
 Double momentOfInertiaZ;
 Double warpingConstant;
 Double shearCentreZ;
 Double shearCentreY;
 Double shearDeformationAreaZ;
 Double shearDeformationAreaY;
 Double maximumSectionModulusY;
 Double minimumSectionModulusY;
 Double maximumSectionModulusZ;
 Double minimumSectionModulusZ;
 Double torsionalSectionModulus;
 Double centreOfGravityInX;
 Double centreOfGravityInY;


 // Getters and setters of properties

 public Double getTorsionalConstantX() {
   return torsionalConstantX;
 }
 public void setTorsionalConstantX(String txt){
   Double value = i.toDouble(txt);
   this.torsionalConstantX=value;

 }

 public Double getMomentOfInertiaYZ() {
   return momentOfInertiaYZ;
 }
 public void setMomentOfInertiaYZ(String txt){
   Double value = i.toDouble(txt);
   this.momentOfInertiaYZ=value;

 }

 public Double getMomentOfInertiaY() {
   return momentOfInertiaY;
 }
 public void setMomentOfInertiaY(String txt){
   Double value = i.toDouble(txt);
   this.momentOfInertiaY=value;

 }

 public Double getMomentOfInertiaZ() {
   return momentOfInertiaZ;
 }
 public void setMomentOfInertiaZ(String txt){
   Double value = i.toDouble(txt);
   this.momentOfInertiaZ=value;

 }

 public Double getWarpingConstant() {
   return warpingConstant;
 }
 public void setWarpingConstant(String txt){
   Double value = i.toDouble(txt);
   this.warpingConstant=value;

 }

 public Double getShearCentreZ() {
   return shearCentreZ;
 }
 public void setShearCentreZ(String txt){
   Double value = i.toDouble(txt);
   this.shearCentreZ=value;

 }

 public Double getShearCentreY() {
   return shearCentreY;
 }
 public void setShearCentreY(String txt){
   Double value = i.toDouble(txt);
   this.shearCentreY=value;

 }

 public Double getShearDeformationAreaZ() {
   return shearDeformationAreaZ;
 }
 public void setShearDeformationAreaZ(String txt){
   Double value = i.toDouble(txt);
   this.shearDeformationAreaZ=value;

 }

 public Double getShearDeformationAreaY() {
   return shearDeformationAreaY;
 }
 public void setShearDeformationAreaY(String txt){
   Double value = i.toDouble(txt);
   this.shearDeformationAreaY=value;

 }

 public Double getMaximumSectionModulusY() {
   return maximumSectionModulusY;
 }
 public void setMaximumSectionModulusY(String txt){
   Double value = i.toDouble(txt);
   this.maximumSectionModulusY=value;

 }

 public Double getMinimumSectionModulusY() {
   return minimumSectionModulusY;
 }
 public void setMinimumSectionModulusY(String txt){
   Double value = i.toDouble(txt);
   this.minimumSectionModulusY=value;

 }

 public Double getMaximumSectionModulusZ() {
   return maximumSectionModulusZ;
 }
 public void setMaximumSectionModulusZ(String txt){
   Double value = i.toDouble(txt);
   this.maximumSectionModulusZ=value;

 }

 public Double getMinimumSectionModulusZ() {
   return minimumSectionModulusZ;
 }
 public void setMinimumSectionModulusZ(String txt){
   Double value = i.toDouble(txt);
   this.minimumSectionModulusZ=value;

 }

 public Double getTorsionalSectionModulus() {
   return torsionalSectionModulus;
 }
 public void setTorsionalSectionModulus(String txt){
   Double value = i.toDouble(txt);
   this.torsionalSectionModulus=value;

 }

 public Double getCentreOfGravityInX() {
   return centreOfGravityInX;
 }
 public void setCentreOfGravityInX(String txt){
   Double value = i.toDouble(txt);
   this.centreOfGravityInX=value;

 }

 public Double getCentreOfGravityInY() {
   return centreOfGravityInY;
 }
 public void setCentreOfGravityInY(String txt){
   Double value = i.toDouble(txt);
   this.centreOfGravityInY=value;

 }

}
