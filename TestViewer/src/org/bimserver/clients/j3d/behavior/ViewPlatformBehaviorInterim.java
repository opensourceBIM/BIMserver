package org.bimserver.clients.j3d.behavior;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import javax.media.j3d.Behavior;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;

/**
 * Abstract class which provides the target TransformGroup and a home transform.
 * 
 * @since Java 3D 1.2.1   
 */
abstract public class ViewPlatformBehaviorInterim extends Behavior {

    /**
     * The target TransformGroup for this behavior.
     */
    protected TransformGroup targetTG = null;

    /**
     * The "home" transform for this behavior. This is a transform used to
     * position and orient the ViewingPlatform to a known point of interest.
     * The default transform is the identity matrix (since 1.1).
     *
     * @since Java 3D 1.3
     */
    protected Transform3D homeTransform = new Transform3D();
    
    /**
     * The "home" rotation center for this behavior. The default center is (0, 0, 0).
     * @since Version 1.1
     */
    protected Point3d homeRotCenter = new Point3d();


    /**
     * Sets the ViewPlatform's TransformGroup for this behavior.  
     * If a subclass overrides this method, it must
     * call super.setViewingTransformGroup(tg).<p>
     *      
     * @param tg the target TransformGroup for this behavior
     */
    public void setViewingTransformGroup(TransformGroup tg) {        
        targetTG = tg;
    }
    /**
     * Returns the target TransformGroup of this behavior.
     * 
     * @return The target TransformGroup
     */
    public TransformGroup getViewingTransformGroup() {
        return targetTG;
    }
    
    /**
     * Copies the given Transform3D into the "home" transform, used to
     * position and reorient the ViewingPlatform to a known point of interest.
     * 
     * @param home source transform to be copied, 
     * if home is null the home transform is set to the identity matrix (since 1.1)
     * @since Java 3D 1.3
     */
    public void setHomeTransform(Transform3D home) {
		if (home == null)
		    homeTransform = new Transform3D();
		else
		    homeTransform.set(home);
    }

    /**
     * Returns the behaviors "home" transform.
     * The default transform is the identity matrix (since Version 1.1).
     * 
     * @param home transform to be returned
     * @since Java 3D 1.3
     */
    public void getHomeTransform(Transform3D home ) {
        home.set(homeTransform);
    }
    
    /**
     * Places the value of the "home" center around which the View rotates
     * into the Point3d. The default center is (0, 0, 0).
     * @param homeCenter The Point3d
     * @since Version 1.1
     */
    public void getHomeRotationCenter(Point3d homeCenter) {
    	homeCenter.x = homeRotCenter.x;
    	homeCenter.y = homeRotCenter.y;
    	homeCenter.z = homeRotCenter.z;
    }
    /**
     * Sets the "home" rotation center.
     * @param homeCenter The Point3d to set the "home" center of rotation to,
     * if null center is set to the default value (0, 0, 0)
     * @since Version 1.1
     */
    public void setHomeRotationCenter(Point3d homeCenter) {
    	if (homeCenter == null)
    		homeRotCenter.set(0, 0, 0);
    	else
    		homeRotCenter.set(homeCenter);
    }

    /**
     * Positions and reorients the ViewingPlatform to its "home" transform.
     * @since Java 3D 1.3
     */
    public abstract void goHome(); // abstract since 1.1
    
    /**
     * Positions and reorients the ViewingPlatform to its "home" transform 
     * and the current rotation center is set to the "home" rotation center if desired.
     * @param aroundHomeCenter if true the current roation center is set 
     * to the 'home' rotation center, otherwise the center remains unchanged
     * @since Java 3D 1.3
     * @since Version 1.1
     */
    public abstract void goHome(boolean aroundHomeCenter);
}
