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

public class IfcCurrencyRelationship extends Thing 
{
 // The property attributes
 IfcMonetaryUnit   relatingMonetaryUnit;
 IfcMonetaryUnit   relatedMonetaryUnit;
 Double exchangeRate;
 IfcDateAndTime   rateDateTime;
 IfcLibraryInformation   rateSource;


 // Getters and setters of properties

 public IfcMonetaryUnit getRelatingMonetaryUnit() {
   return relatingMonetaryUnit;

 }
 public void setRelatingMonetaryUnit(IfcMonetaryUnit value){
   this.relatingMonetaryUnit=value;

 }

 public IfcMonetaryUnit getRelatedMonetaryUnit() {
   return relatedMonetaryUnit;

 }
 public void setRelatedMonetaryUnit(IfcMonetaryUnit value){
   this.relatedMonetaryUnit=value;

 }

 public Double getExchangeRate() {
   return exchangeRate;
 }
 public void setExchangeRate(String txt){
   Double value = i.toDouble(txt);
   this.exchangeRate=value;

 }

 public IfcDateAndTime getRateDateTime() {
   return rateDateTime;

 }
 public void setRateDateTime(IfcDateAndTime value){
   this.rateDateTime=value;

 }

 public IfcLibraryInformation getRateSource() {
   return rateSource;

 }
 public void setRateSource(IfcLibraryInformation value){
   this.rateSource=value;

 }

}
