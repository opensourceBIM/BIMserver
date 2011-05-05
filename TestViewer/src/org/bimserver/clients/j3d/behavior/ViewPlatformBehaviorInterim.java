package org.bimserver.clients.j3d.behavior;
/*
 * $RCSfile: ViewPlatformBehavior.java,v $
 *
 * Copyright (c) 2007 Sun Microsystems, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistribution of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in
 *   the documentation and/or other materials provided with the
 *   distribution.
 *
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
 * EXCLUDED. SUN MICROSYSTEMS, INC. ("SUN") AND ITS LICENSORS SHALL
 * NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR
 * ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL,
 * CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND
 * REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF THE USE OF OR
 * INABILITY TO USE THIS SOFTWARE, EVEN IF SUN HAS BEEN ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or
 * intended for use in the design, construction, operation or
 * maintenance of any nuclear facility.
 *
 * $Revision: 1.4 $
 * $Date: 2007/02/09 17:20:15 $
 * $State: Exp $
 */

/*
 * ViewPlatformBehaviorInterim is based on "com.sun.j3d.utils.behaviors.vp.ViewPlatformBehavior".
 *
 * Redistribution and use are permitted according to the copyrigth notice above mentioned.
 *
 * Author: August Lammersdorf, www.InteractiveMesh.com/org
 * Version: 1.1
 * Date: June 26, 2007 
 * 
 */

/*
 * Release notes: see OrbitBehaviorInterim 
 * 
 */

//package com.sun.j3d.utils.behaviors.vp;

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
