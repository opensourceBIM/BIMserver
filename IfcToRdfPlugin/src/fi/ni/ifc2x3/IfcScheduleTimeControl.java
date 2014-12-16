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

public class IfcScheduleTimeControl extends IfcControl 
{
 // The property attributes
IfcDateTimeSelect actualStart;
IfcDateTimeSelect earlyStart;
IfcDateTimeSelect lateStart;
IfcDateTimeSelect scheduleStart;
IfcDateTimeSelect actualFinish;
IfcDateTimeSelect earlyFinish;
IfcDateTimeSelect lateFinish;
IfcDateTimeSelect scheduleFinish;
 Double scheduleDuration;
 Double actualDuration;
 Double remainingTime;
 Double freeFloat;
 Double totalFloat;
 String isCritical;
IfcDateTimeSelect statusTime;
 Double startFloat;
 Double finishFloat;
 Double completion;
 // The inverse attributes

 InverseLinksList<IfcRelAssignsTasks> scheduleTimeControlAssigned= new InverseLinksList<IfcRelAssignsTasks>();


 // Getters and setters of properties

 public IfcDateTimeSelect getActualStart() {
   return actualStart;
 }
 public void setActualStart(IfcDateTimeSelect value){
   this.actualStart=value;

 }

 public IfcDateTimeSelect getEarlyStart() {
   return earlyStart;
 }
 public void setEarlyStart(IfcDateTimeSelect value){
   this.earlyStart=value;

 }

 public IfcDateTimeSelect getLateStart() {
   return lateStart;
 }
 public void setLateStart(IfcDateTimeSelect value){
   this.lateStart=value;

 }

 public IfcDateTimeSelect getScheduleStart() {
   return scheduleStart;
 }
 public void setScheduleStart(IfcDateTimeSelect value){
   this.scheduleStart=value;

 }

 public IfcDateTimeSelect getActualFinish() {
   return actualFinish;
 }
 public void setActualFinish(IfcDateTimeSelect value){
   this.actualFinish=value;

 }

 public IfcDateTimeSelect getEarlyFinish() {
   return earlyFinish;
 }
 public void setEarlyFinish(IfcDateTimeSelect value){
   this.earlyFinish=value;

 }

 public IfcDateTimeSelect getLateFinish() {
   return lateFinish;
 }
 public void setLateFinish(IfcDateTimeSelect value){
   this.lateFinish=value;

 }

 public IfcDateTimeSelect getScheduleFinish() {
   return scheduleFinish;
 }
 public void setScheduleFinish(IfcDateTimeSelect value){
   this.scheduleFinish=value;

 }

 public Double getScheduleDuration() {
   return scheduleDuration;
 }
 public void setScheduleDuration(String txt){
   Double value = i.toDouble(txt);
   this.scheduleDuration=value;

 }

 public Double getActualDuration() {
   return actualDuration;
 }
 public void setActualDuration(String txt){
   Double value = i.toDouble(txt);
   this.actualDuration=value;

 }

 public Double getRemainingTime() {
   return remainingTime;
 }
 public void setRemainingTime(String txt){
   Double value = i.toDouble(txt);
   this.remainingTime=value;

 }

 public Double getFreeFloat() {
   return freeFloat;
 }
 public void setFreeFloat(String txt){
   Double value = i.toDouble(txt);
   this.freeFloat=value;

 }

 public Double getTotalFloat() {
   return totalFloat;
 }
 public void setTotalFloat(String txt){
   Double value = i.toDouble(txt);
   this.totalFloat=value;

 }

 public String getIsCritical() {
   return isCritical;
 }
 public void setIsCritical(String value){
   this.isCritical=value;

 }

 public IfcDateTimeSelect getStatusTime() {
   return statusTime;
 }
 public void setStatusTime(IfcDateTimeSelect value){
   this.statusTime=value;

 }

 public Double getStartFloat() {
   return startFloat;
 }
 public void setStartFloat(String txt){
   Double value = i.toDouble(txt);
   this.startFloat=value;

 }

 public Double getFinishFloat() {
   return finishFloat;
 }
 public void setFinishFloat(String txt){
   Double value = i.toDouble(txt);
   this.finishFloat=value;

 }

 public Double getCompletion() {
   return completion;
 }
 public void setCompletion(String txt){
   Double value = i.toDouble(txt);
   this.completion=value;

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcRelAssignsTasks> getScheduleTimeControlAssigned() {
   return scheduleTimeControlAssigned;

 }
 public void setScheduleTimeControlAssigned(IfcRelAssignsTasks value){
   this.scheduleTimeControlAssigned.add(value);

 }

}
