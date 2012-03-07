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

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.media.j3d.BadTransformException;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Bounds;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.CapabilityNotSetException;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.View;
import javax.vecmath.Matrix3d;
import javax.vecmath.Point3d;
import javax.vecmath.SingularMatrixException;
import javax.vecmath.Vector3d;

/**
 * Moves the View around a point of interest when the mouse is dragged with
 * a mouse button pressed.  Includes rotation, zoom, and translation
 * actions. Zooming can also be obtained by using mouse wheel.
 * <p>
 * The rotate action rotates the ViewPlatform around the point of interest
 * when the mouse is moved with the main mouse button pressed.  The
 * rotation is in the direction of the mouse movement, with a default
 * rotation of 0.01 radians for each pixel of mouse movement.
 * <p>
 * The zoom action moves the ViewPlatform closer to or further from the
 * point of interest when the mouse is moved with the middle mouse button
 * pressed (or Alt-main mouse button on systems without a middle mouse button).
 * The default zoom action is to translate the ViewPlatform 0.01 units for each
 * pixel of mouse movement.  Moving the mouse up moves the ViewPlatform closer,
 * moving the mouse down moves the ViewPlatform further away.
 * <p>
 * By default, the zoom action allows the ViewPlatform to move through
 * the center of rotation to orbit at a negative radius.
 * The <code>STOP_ZOOM</code> constructor flag will stop the ViewPlatform at
 * a minimum radius from the center.  The default minimum radius is 0.0
 * and can be set using the <code>setMinRadius</code> method.
 * <p>
 * The <code>PROPORTIONAL_ZOOM</code> constructor flag changes the zoom action
 * to move the ViewPlatform proportional to its distance from the center
 * of rotation.  For this mode, the default action is to move the ViewPlatform
 * by 1% of its distance from the center of rotation for each pixel of
 * mouse movement.
 * <p>
 * The translate action translates the ViewPlatform when the mouse is moved
 * with the right mouse button pressed (Shift-main mouse button on systems
 * without a right mouse button).  The translation is in the direction of the
 * mouse movement, with a default translation of 0.01 units for each pixel
 * of mouse movement.
 * <p>
 * The sensitivity of the actions can be scaled using the
 * <code>set</code><i>Action</i><code>Factor()</code> methods which scale
 * the default movement by the factor. The rotate and translate actions
 * have separate factors for x and y.
 * <p>
 * The actions can be reversed using the <code>REVERSE_</code><i>ACTION</i>
 * constructor flags.  The default action moves the ViewPlatform around the
 * objects in the scene.  The <code>REVERSE_</code><i>ACTION</i> flags can
 * make the objects in the scene appear to be moving in the direction
 * of the mouse movement.
 * <p>
 * The actions can be disabled by either using the
 * <code>DISABLE_</code><i>ACTION</i> constructor flags or the
 * <code>set</code><i>Action</i><code>Enable</code> methods.
 * <p>
 * The default center of rotation is (0, 0, 0) and can be set using the
 * <code>setRotationCenter()</code> method.
 *
 * @since Java 3D 1.2.1
 * 
 */
public class OrbitBehaviorInterim extends ViewPlatformAWTBehaviorInterim {

    private Transform3D longditudeTransform = new Transform3D();
    private Transform3D latitudeTransform = new Transform3D();
    private Transform3D rotateTransform = new Transform3D();

    // needed for integrateTransforms but don't want to new every time
    private Transform3D temp1 = new Transform3D();
    private Transform3D temp2 = new Transform3D();
    private Transform3D translation = new Transform3D();
    private Vector3d transVector = new Vector3d();
    private Vector3d distanceVector = new Vector3d();
    private Vector3d centerVector = new Vector3d();
    private Vector3d invertCenterVector = new Vector3d();

    private double longditude = 0.0;
    private double latitude = 0.0;
    private double startDistanceFromCenter = 20.0;
    private double distanceFromCenter = 20.0;
    private Point3d rotationCenter = new Point3d();
    private Matrix3d rotMatrix = new Matrix3d();
    
    private int mouseX = 0;
    private int mouseY = 0;

    private double rotXFactor = 1.0;
    private double rotYFactor = 1.0;
    private double transXFactor = 1.0;
    private double transYFactor = 1.0;
    private double zoomFactor = 1.0;

    private double xtrans = 0.0;
    private double ytrans = 0.0;
    private double ztrans = 0.0;

    private boolean zoomEnabled = true;
    private boolean rotateEnabled = true;
    private boolean translateEnabled = true;
    private boolean reverseRotate = false;
    private boolean reverseTrans = false;
    private boolean reverseZoom = false;
    private boolean stopZoom = false;
    private boolean proportionalZoom = false;
    private double minRadius = 0.0;
    private int leftButton = ROTATE;
    private int rightButton = TRANSLATE;
    private int middleButton = ZOOM;

    // the factor to be applied to wheel zooming so that it does not 
    // look much different with mouse movement zooming. 
    // This is a totally subjective factor.
    private float wheelZoomFactor = 50.0f;
    
    /**
     * Constructor flag to reverse the rotate behavior
     */
    public static final int REVERSE_ROTATE = 0x010;

    /**
     * Constructor flag to reverse the translate behavior
     */
    public static final int REVERSE_TRANSLATE = 0x020;

    /**
     * Constructor flag to reverse the zoom behavior
     */
    public static final int REVERSE_ZOOM = 0x040;

    /**
     * Constructor flag to reverse all the behaviors
     */
    public static final int REVERSE_ALL = (REVERSE_ROTATE | REVERSE_TRANSLATE | REVERSE_ZOOM);

    /**
     * Constructor flag that indicates zoom should stop when it reaches
     * the minimum orbit radius set by setMinRadius().  The minimus
     * radius default is 0.0.
     */
    public static final int STOP_ZOOM = 0x100;
    
    /**
     * Constructor flag to disable rotate
     */
    public static final int DISABLE_ROTATE = 0x200;

    /**
     * Constructor flag to disable translate
     */
    public static final int DISABLE_TRANSLATE = 0x400;

    /**
     * Constructor flag to disable zoom
     */
    public static final int DISABLE_ZOOM = 0x800;

    /**
     * Constructor flag to use proportional zoom, which determines
     * how much you zoom based on view's distance from the center of
     * rotation.  The percentage of distance that the viewer zooms
     * is determined by the zoom factor.
     */
    public static final int PROPORTIONAL_ZOOM = 0x1000;
    
    /**
     * Used to set the fuction for a mouse button to Rotate 
     */
    private static final int ROTATE = 0;

    /**
     * Used to set the function for a mouse button to Translate
     */
    private static final int TRANSLATE = 1;

    /**
     * Used to set the function for a mouse button to Zoom
     */
    private static final int ZOOM = 2;

    private static final double NOMINAL_ZOOM_FACTOR = .01;
    private static final double NOMINAL_PZOOM_FACTOR = 1.0;
    private static final double NOMINAL_ROT_FACTOR = .01;
    private static final double NOMINAL_TRANS_FACTOR = .01;

    private double rotXMul = NOMINAL_ROT_FACTOR * rotXFactor;
    private double rotYMul = NOMINAL_ROT_FACTOR * rotYFactor;
    private double transXMul = NOMINAL_TRANS_FACTOR * transXFactor;
    private double transYMul = NOMINAL_TRANS_FACTOR * transYFactor;
    private double zoomMul = NOMINAL_ZOOM_FACTOR * zoomFactor;
    //
    // Version 2.0 : Parallel Projection & Clipping
    //
	private double parallelScale = 1.0;   
	private double parallelScaleFactor = 1.0; 
	private double parallelScalePure = 1.0; 
	private boolean isPureParallelProjection = false;
	
	private boolean isClippingUpdate = false;
    /**
     * The target View for this behavior.
 	 * @since Version 2.0
     */
	protected View view = null;
    /**
     * Projection mode: View.PARALLEL_PROJECTION or View.PERSPECTIVE_PROJECTION. 
     * Default mode is View.PERSPECTIVE_PROJECTION;
 	 * @since Version 2.0
     */
	protected int projection = View.PERSPECTIVE_PROJECTION;
	
    /**
     * Bounding sphere of the scene as base for clipping distances calculation.
	 * @since Version 2.0
     */
	protected BoundingSphere sceneSphere = null; 
    /**
     * Center of the scene bounding sphere.
	 * @since Version 2.0
     */
	protected Point3d sceneCenter = new Point3d();
    /**
     * Radius of the scene bounding sphere.
	 * @since Version 2.0
     */
	protected double sceneRadius = 0; 
    /**
     * Factor to scale the scene radius.
	 * @since Version 2.0
     */
	protected double radiusFactor = 1.2;  // add 10%-20% 		
    /**
     * Maximum ratio of back and front clip distances.
	 * @since Version 2.0
     */
	protected double maxClipRatio = 1000; // recommended	
    /**
     * Minimum back clip distance.
	 * @since Version 2.0
     */
	protected double minBackClipDistance = 1.0E-5;

    /**
     * Constructs a OrbitBehaviorInterim with a null source of Component, 
     * a null targets of TransformGroup and View, and no constructor flags.
     * 
     */
    public OrbitBehaviorInterim() {
    	super(MOUSE_LISTENER | MOUSE_MOTION_LISTENER | MOUSE_WHEEL_LISTENER);
    }
    
    /**
     * Constructs a OrbitBehaviorInterim with a null source of Component, 
     * null targets of TransformGroup and View, and specified constructor flags.
     *
     * @param flags The option flags
     */
    public OrbitBehaviorInterim(int flags) {
        super(MOUSE_LISTENER | MOUSE_MOTION_LISTENER | MOUSE_WHEEL_LISTENER | flags);
        
        // since 1.1 
        updateFlags(flags);
    }
    /**
     * Constructs a OrbitBehaviorInterim with a specified source of Component, 
     * a specified target of TransformGroup, a null target of View, and no constructor flags.
     *
     * @param c The Component to add the behavior to
     * @param tg The target TransformGroup for this behavior     
     * @throws NullPointerException If the Component or TransformGroup are null.
     */
    public OrbitBehaviorInterim(Component c, TransformGroup tg) { 
    	this(c, tg, 0);
    }
    /**
     * Constructs a OrbitBehaviorInterim with a specified source of Component, 
     * specified targets of TransformGroup and View, and no constructor flags.
     * The projection policy for this View is set to View.PERSPECTIVE_PROJECTION.
	 *
     * @param c The Component to add the behavior to
     * @param tg The target TransformGroup for this behavior
     * @param view The target View for this behavior
	 * @since Version 2.0
     */
	public OrbitBehaviorInterim(Component c, TransformGroup tg, View view) { 
		this(c, tg, view, 0);
	}

    /**
     * Constructs a OrbitBehaviorInterim with a specified source of Component, a 
     * specified target of TransformGroup, a null target of View, and specified constructor flags.
     *
     * @param c The Component to add the behavior to
     * @param tg The target TransformGroup for this behavior     
     * @param flags The option flags
     * @throws NullPointerException If the Component or TransformGroup are null.
     */
    public OrbitBehaviorInterim(Component c, TransformGroup tg, int flags) {
    	
    	super(MOUSE_LISTENER | MOUSE_MOTION_LISTENER | MOUSE_WHEEL_LISTENER | flags );
        
        if (c == null)
            throw new NullPointerException("Component is null !");
        if (tg == null)
            throw new NullPointerException("TransformGroup is null !");

        // since 1.1
        updateFlags(flags);
        
        setAWTComponent(c);
        setViewingTransformGroup(tg);
    }
    /**
     * Constructs a OrbitBehaviorInterim with a specified source of Component, 
     * specified targets of TransformGroup and View, and specified constructor flags.
	 * The projection policy for this View is set to View.PERSPECTIVE_PROJECTION.
	 *      
     * @param c The Component to add the behavior to
     * @param tg The target TransformGroup for this behavior
     * @param view The target View for this behavior
     * @param flags The option flags
     * @throws NullPointerException If the Component, TransformGroup, or View are null.
	 * @since Version 2.0
     */
	public OrbitBehaviorInterim(Component c, TransformGroup tg, View view, int flags) {
		this(c, tg, flags);
        if (view == null)
            throw new NullPointerException("View is null !");
		this.view = view;
		view.setProjectionPolicy(View.PERSPECTIVE_PROJECTION);
	}
    
    // since 1.1
    private void updateFlags(int flags) {
    	if ((flags & DISABLE_ROTATE) != 0) rotateEnabled = false;
    	if ((flags & DISABLE_ZOOM) != 0) zoomEnabled = false;
    	if ((flags & DISABLE_TRANSLATE) != 0) translateEnabled = false;
        if ((flags & REVERSE_TRANSLATE) != 0) reverseTrans = true;	
        if ((flags & REVERSE_ROTATE) != 0)  reverseRotate = true;
        if ((flags & REVERSE_ZOOM) != 0) reverseZoom = true;
        if ((flags & STOP_ZOOM) != 0) stopZoom = true;
        if ((flags & PROPORTIONAL_ZOOM) !=0) {
        	proportionalZoom = true;
        	zoomMul = NOMINAL_PZOOM_FACTOR * zoomFactor;
        }
    }
    
    /**
     * Sets the Component used to listen for mouse,
     * mouse motion, and mouse wheel events.
     * If a subclass overrides this method, it must
     * call super.setViewingTransformGroup(tg).<p>
     *
     * @param c the source Component for this behavior
     */
    @Override
    public void setAWTComponent(Component c) { 
        super.setAWTComponent(c);

        if (component != null && targetTG != null) {
        	resetView();
        	integrateTransforms();
        }
    }
     /**
     * Sets the ViewPlatform's TransformGroup for this behavior.  
     * If a subclass overrides this method, it must
     * call super.setViewingTransformGroup(tg).<p>
     *      
     * @param tg the target TransformGroup for this behavior
     */
    @Override
    public void setViewingTransformGroup(TransformGroup tg) {        
        super.setViewingTransformGroup(tg);
        
        if (component != null && targetTG != null) {            
        	resetView();
        	integrateTransforms();
        }
    } 
    /**
     * Returns the ViewPlatform's View for this behavior.
     * 
     * @return The target View
	 * @since Version 2.0
     */
	public View getVpView() {
		return view;
	}
	/**
	 * Sets the ViewPlatform's View for this behavior.
	 * If clipping is enabled the back and front clip policies are set to View.VIRTUAL_EYE.
	 * If projection mode is View.PARALLEL_PROJECTION the screen scale policy is set to
	 * View.SCALE_EXPLICIT.
	 * 
	 * @param view the target View for this behavior
	 * @since Version 2.0
	 */
	public void setVpView(View view) {
		this.view = view;
		if (view != null) {
			if (isClippingUpdate) {
				view.setBackClipPolicy(View.VIRTUAL_EYE);
				view.setFrontClipPolicy(View.VIRTUAL_EYE);
			}
			
			if (projection == View.PARALLEL_PROJECTION) {
				view.setScreenScalePolicy(View.SCALE_EXPLICIT);
			}
		}
		// ??
	    if (component != null && targetTG != null && 
	    	(view != null && (isClippingUpdate || projection == View.PARALLEL_PROJECTION)) ) {            
	    	resetView();
	    	integrateTransforms();
	    }
	}
	//
	// Parallel / perspective projection
	//
	/**
	 * Returns the current projection mode.
	 * 
	 * @return one of View.PARALLEL_PROJECTION or View.PERSPECTIVE_PROJECTION
	 * @since Version 2.0
	 */
	public int getProjectionMode() {
		return projection;
	}
	/**
	 * Sets the projection mode for this OrbitBehaviorInterim to parallel or 
	 * perspective projection. The projection mode can be changed at any time.
	 * <p>
	 * The target View's projection policy is set to this mode value, too. 
	 * If mode is View.PARALLEL_PROJECTION the target View's screen scale policy 
	 * is set to View.SCALE_EXPLICIT. If mode is View.PERSPECTIVE_PROJECTION 
	 * the target View's screen scale policy is set to View.SCALE_SCREEN_SIZE.
	 * </p>
	 * <p>
	 * The default projection mode is View.PERSPECTIVE_PROJECTION.	 
	 * </p>
	 * @param mode projection mode, one of View.PARALLEL_PROJECTION or View.PERSPECTIVE_PROJECTION
	 * @throws IllegalArgumentException if mode is a value other than View.PARALLEL_PROJECTION or View.PERSPECTIVE_PROJECTION
	 * @throws IllegalStateException if no View object is set for this behavior
	 * @throws IllegalStateException if mode is View.PARALLEL_PROJECTION and the View object holds no Canvas3D instance
	 * @since Version 2.0
	 * @see #setPureParallelEnabled(boolean)
	*/
	public void setProjectionMode(int mode) {
		
		if (mode != View.PARALLEL_PROJECTION && mode != View.PERSPECTIVE_PROJECTION)
			throw new IllegalArgumentException("");
		if (view == null)
			throw new IllegalStateException("No View object set !");
	
		projection = mode;

		if (projection == View.PARALLEL_PROJECTION) {		
			setParScFacAccToFoV(view.getFieldOfView());			
			view.setScreenScalePolicy(View.SCALE_EXPLICIT);
		}
		else if (projection == View.PERSPECTIVE_PROJECTION) {
			view.setScreenScalePolicy(View.SCALE_SCREEN_SIZE);
		}
		
		view.setProjectionPolicy(projection);
	
		if (targetTG != null) {
			this.resetView();
			this.integrateTransforms();
		}
		// ??
		else if (projection == View.PARALLEL_PROJECTION) {
			parallelScale = distanceFromCenter * parallelScaleFactor;
			if (parallelScale > 0) {
				view.setScreenScale(1/parallelScale);
			}
		}
	}
	/**
	 * Retrieves a flag indicating whether pure parallel projection is enabled.
	 * 
	 * @return <code>true</code> if parallel projection isn't synchronized with 
	 * perspective projection, <code>false</code> otherwise
	 * @since Version 2.0
	 */
	public boolean isPureParallelEnabled() {
		return isPureParallelProjection;
	}	
	/**
	 * The pure parallel flag has to be set if this OrbitBeahviorInterim is used
	 * only or mainly in parallel projection mode to ensure that all its features
	 * are adjusted to parallel projection. 
	 * 
	 * @param enable <code>true</code> if only parallel projection mode is used
	 * @since Version 2.0
	 * @see #setProjectionMode(int)
	 */
	public void setPureParallelEnabled(boolean enable) {
		isPureParallelProjection = enable;
		parallelScalePure = 1.0; 
	}
	/**
	 * Returns the current field of view of the View object.
	 * @return the current field of view in radians
	 * @throws IllegalStateException if no View object is set for this behavior
	 * @since Version 2.0
	 */
	public double getFieldOfView() {
		if (view == null)
			throw new IllegalStateException("No View object set !");
		return view.getFieldOfView();
	}
	/**
	 * Sets the field of view of the View object.
	 * <p>
	 * In case of parallel projection the field of view value determines
	 * the parallel scaling rate. 
	 * </p>
	 * @param angle the new field of view in radians
	 * @throws IllegalStateException if no View object is set for this behavior
	 * @throws IllegalStateException if mode is View.PARALLEL_PROJECTION and the View object holds no Canvas3D instance
	 * @throws IllegalArgumentException if angle <= 0
	 * @since Version 2.0
	 */
	public void setFieldOfView(double angle) {
		if (view == null)
			throw new IllegalStateException("No View object set !");
		if (angle <= 0)
			throw new IllegalStateException("FieldOfView <= 0 :" + angle + " !");
		
		view.setFieldOfView(angle);
		
		if (projection == View.PARALLEL_PROJECTION) {
			
			setParScFacAccToFoV(angle);
			
			if (targetTG != null) {
				this.resetView();
				this.integrateTransforms();
			}
			// ??
			else {
				parallelScale = distanceFromCenter * parallelScaleFactor;
				if (parallelScale > 0) {
					view.setScreenScale(1/parallelScale);
				}
			}
		}
	}
	/**
	 * Set parallel scale factor according to the field of view and physical screen width.
	 * 
	 * @param fov field of view 
	 * @since Version 2.0
	 */
	private void setParScFacAccToFoV(double fov) {
		int num = 0;
		if ((num = view.numCanvas3Ds()) < 1)
			throw new IllegalStateException("View holds no Canvas3D !");
		
		double tanFoVHalf = Math.tan(fov/2);
		
		double physicalScreenWidth = 1;
		Canvas3D canvas3D = null;
		for (int i=0; i < num; i++) {
			if ((canvas3D = view.getCanvas3D(i)) != null) {
				physicalScreenWidth = canvas3D.getScreen3D().getPhysicalScreenWidth();
				break;
			}
		}
		if (canvas3D == null)
			throw new IllegalStateException("View holds no Canvas3D !");
			
		// perspective width: tanFoVHalf
		// default screen scale: physicalScreenWidth/2.0
		// parallel scale factor: perspective width / default screen scale
		parallelScaleFactor = tanFoVHalf * 2.0 / physicalScreenWidth;
		
	}
	//
	// View's Back-/FrontClipping
	//
	/** 
	 * Retrieves a flag indicating whether clip distances will be updated.
	 * 
	 * @return <code>true</code> if clip distances will be updated, <code>false</code> otherwise 
	 * @since Version 2.0
	 */
	public boolean isClippingEnabled() {
		return isClippingUpdate;
	}
	/** 
	 * This OrbitBehaviorInterim updates the front and back clip distances 
	 * of the View object if this clipping flag is set. Depending on the scene bounds 
	 * and the current center of rotation these distances are calculated to achieve 
	 * a minimal clipping extent and an optimized back/front ratio.
	 * <p>
	 * By default clipping update is not enabled.
	 * </p>
	 * @param enable <code>true</code> if clip distances should be updated
	 * @since Version 2.0
	 */
	public void setClippingEnabled(boolean enable) {
		isClippingUpdate = enable;
		if (view != null && isClippingUpdate) {
			view.setBackClipPolicy(View.VIRTUAL_EYE);
			view.setFrontClipPolicy(View.VIRTUAL_EYE);
			
			setClippingDistances();
		}
	}
	/**
	 * Returns the bounding object for clipping distances calculation.
	 * @return a copy of the bounding object
	 * @since Version 2.0
	 */
	public Bounds getClippingBounds() {
		return (Bounds)sceneSphere.clone();
	}
	/**
	 * Sets the bounding object for clipping distances calculation. 
	 * The passed Bounds instance is converted into a BoundingSphere object.
	 * @param sceneBounds typically the sphere bounds of the scene or an arbitrary bounding object
	 * @since Version 2.0
	 */
	public void setClippingBounds(Bounds sceneBounds) {		
		if (sceneBounds == null || sceneBounds.isEmpty()) {
			// sceneSphere.isEmpty()
			sceneCenter.set(0, 0, 0);
			sceneRadius = -1;
			sceneSphere = new BoundingSphere(sceneCenter, sceneRadius);
			return;
		}
	
		if (sceneBounds instanceof BoundingSphere) 
			sceneSphere = (BoundingSphere)sceneBounds.clone();
		else
			sceneSphere = new BoundingSphere(sceneBounds);
	
		sceneSphere.getCenter(sceneCenter);
		sceneRadius = sceneSphere.getRadius() * radiusFactor;
	
		setClippingDistances();
	}
	/**
	 * Calculates and sets the back and front clip distances for the target View object
	 * if clipping bounds and View objects are set.
	 * This method is repeatedly called during the navigation if clipping is enabled.
	 * <p>
	 * Override this method for individual calculation of the clipping distances.
	 * </p>
	 * @since Version 2.0
	 */
	protected void setClippingDistances() {
	    if (sceneSphere == null || sceneSphere.isEmpty() || view == null)
	        return; // alternative ??

	    // For parallel and perspective projection!
	    // Compensation if rotationCenter != sceneCenter
	    //   ensures that clipping distances cover the entire scene 
	    //   even if center of rotation is at its border
	    double radius = sceneRadius + rotationCenter.distance(sceneCenter);
	
	    double backClipDistance = Math.max(minBackClipDistance, distanceFromCenter + radius);
	    double frontClipDistance = Math.max(backClipDistance - 2*radius, 
	                                        backClipDistance/maxClipRatio);
	    view.setBackClipDistance(backClipDistance);
	    view.setFrontClipDistance(frontClipDistance);
	}
	//
	//
	//
	/**
	 * Process AWTEvents
	 */
    protected synchronized void processAWTEvents( final AWTEvent[] events ) {
        motion = false;
        for(int i=0; i<events.length; i++)
            if (events[i] instanceof MouseEvent) 
                processMouseEvent( (MouseEvent)events[i] );
    }

    void processMouseEvent( final MouseEvent evt ) {
        
        if (evt.getID()==MouseEvent.MOUSE_PRESSED) {
            mouseX = evt.getX();
            mouseY = evt.getY();
            motion=true;
        } 
        else if (evt.getID()==MouseEvent.MOUSE_DRAGGED) {	    
            int xchange = evt.getX() - mouseX;
            int ychange = evt.getY() - mouseY;
            // rotate
            if (rotate(evt)) {
            	if (reverseRotate) {
            		longditude -= xchange * rotXMul;
            		latitude -= ychange * rotYMul;
            	}
            	else {
            		longditude += xchange * rotXMul;
            		latitude += ychange * rotYMul;
            	}
            }
            // translate
            else if (translate(evt)) {
            	if (reverseTrans) {
            		xtrans -= xchange * transXMul;
            		ytrans += ychange * transYMul;
            	}
            	else {
            		xtrans += xchange * transXMul;
            		ytrans -= ychange * transYMul;
            	}
            }
            // zoom
            else if (zoom(evt)) {
            	doZoomOperations( ychange );
            }
            mouseX = evt.getX();
            mouseY = evt.getY();
            motion = true;
        } 
        else if (evt.getID()==MouseEvent.MOUSE_RELEASED ) {
        } 
        else if (evt.getID()==MouseEvent.MOUSE_WHEEL ) {
        	if (zoom(evt)) {
        		// if zooming is done through mouse wheel, 
        		// the amount of increments the wheel changed, 
        		// multiplied with wheelZoomFactor is used, 
        		// so that zooming speed looks natural compared to mouse movement zoom.
        		if ( evt instanceof java.awt.event.MouseWheelEvent){
        			// I/O differenciation is made between 
        			// java.awt.event.MouseWheelEvent.WHEEL_UNIT_SCROLL or 
        			// java.awt.event.MouseWheelEvent.WHEEL_BLOCK_SCROLL so 
        			// that behavior remains stable and not dependent on OS settings.
        			// If getWheelRotation() was used for calculating the zoom, 
        			// the zooming speed could act differently on different platforms, 
        			// if, for example, the user sets his mouse wheel to jump 10 lines 
        			// or a block.
        			int zoom = ((int)(((java.awt.event.MouseWheelEvent)evt).getWheelRotation() * wheelZoomFactor));
        			doZoomOperations( zoom );
        			motion = true;
        		}
        	}
        }
   }
    
    /*extraction of the zoom algorithms so that there is no code duplication or source 'uglyfication'.
     */
    private void doZoomOperations( int ychange ) {    	
    	if (proportionalZoom) {
    		if (reverseZoom) {
    			if ((distanceFromCenter - (zoomMul*ychange*distanceFromCenter/100.0)) > minRadius) {
    				distanceFromCenter -= (zoomMul*ychange*distanceFromCenter/100.0);
    			}
    			else {
    				distanceFromCenter = minRadius;
    			}			    
    		}
    		else {
    			if ((distanceFromCenter + (zoomMul*ychange*distanceFromCenter/100.0)) > minRadius) {
    				distanceFromCenter += (zoomMul*ychange*distanceFromCenter/100.0);
    			}
    			else {
    				distanceFromCenter = minRadius;
    			}
    		}
    	}
    	else {
    		if (stopZoom) {
    			if (reverseZoom) {
    				if ((distanceFromCenter - ychange*zoomMul) > minRadius) {
    					distanceFromCenter -= ychange*zoomMul;
    				}
    				else {
    					distanceFromCenter = minRadius;
    				}
    			}
    			else {
    				if ((distanceFromCenter + ychange*zoomMul) > minRadius) {
    					distanceFromCenter += ychange*zoomMul;
    				}
    				else {
    					distanceFromCenter = minRadius;
    				}
    			}
	    	}
	    	else {
	    		if (reverseZoom) {
	    			distanceFromCenter -= ychange*zoomMul;
	    		}
	    		else {
	    			distanceFromCenter += ychange*zoomMul;
	    		}
	    	}
		}
    }

    /**
     * Reset the orientation and distance of this behavior to the current
     * values in the ViewPlatform Transform Group
     */
    // Parallel / perspective projection
    protected void resetView() {
    	Vector3d centerToView = new Vector3d();

        targetTransform.get(rotMatrix, transVector);
        
        centerToView.sub(transVector, rotationCenter);
        distanceFromCenter = centerToView.length();
        startDistanceFromCenter = distanceFromCenter;

        //targetTransform.get( rotMatrix ); it's done already
        rotateTransform.set( rotMatrix );
	
        // compute the initial x/y/z offset
        temp1.set(centerToView);
        rotateTransform.invert();
		rotateTransform.mul(temp1);
		rotateTransform.get(centerToView);
		xtrans = centerToView.x;
		ytrans = centerToView.y;
		ztrans = centerToView.z;
		
		// reset rotMatrix
		rotateTransform.set( rotMatrix );
    }
    /**
     * Reset the orientation and distance/scaling of this OrbitBehaviorInterim 
     * if the center of rotation has changed in (pure) parallel projection mode.
	 *
	 * @since Version 2.0
     */
    protected void resetViewParallelLookAtRotCenter() {
    	Vector3d centerToView = new Vector3d();

        targetTransform.get(rotMatrix, transVector);
        
		// ??? here is the change to 'normalize' pure parallel projection      
		if (isPureParallelProjection) {
			distanceFromCenter = distanceFromCenter * parallelScalePure;
			parallelScalePure = 1.0;
		}
        
        centerToView.sub(transVector, rotationCenter);

        rotateTransform.set( rotMatrix );
        // compute the initial x/y/z offset
        temp1.set(centerToView);
        rotateTransform.invert();
		rotateTransform.mul(temp1);
		rotateTransform.get(centerToView);
		xtrans = 0;						// centerToView.x;
		ytrans = 0;						// centerToView.y;
		ztrans = distanceFromCenter;	// centerToView.z;

		startDistanceFromCenter = distanceFromCenter;
		
		// reset rotMatrix
		rotateTransform.set( rotMatrix );
    }
    /**
     * Reset the orientation and distance/scaling of this OrbitBehaviorInterim 
     * if the center of rotation has changed in pure parallel projection mode.
     *
	 * @since Version 2.0
     */
    // 
    protected void resetViewPureParallelRotCenter() {
    	Vector3d centerToView = new Vector3d();

        targetTransform.get(rotMatrix, transVector);
        
        double distanceOld = distanceFromCenter;        

        centerToView.sub( transVector, rotationCenter );
        distanceFromCenter = centerToView.length();
        startDistanceFromCenter = distanceFromCenter;
                
        double distanceNew = distanceFromCenter;        
  
		double distanceRatio = 1; 
		if (distanceOld > 0)
			distanceRatio = distanceOld/distanceNew;

		parallelScalePure *= distanceRatio; 
		
        rotateTransform.set( rotMatrix );	
        // compute the initial x/y/z offset
        temp1.set(centerToView);
        rotateTransform.invert();
		rotateTransform.mul(temp1);
		rotateTransform.get(centerToView);
		
		xtrans = centerToView.x;
		ytrans = centerToView.y;
		ztrans = centerToView.z;

		// reset rotMatrix
		rotateTransform.set( rotMatrix );
    }
    /**
     * Compound transformations
     */
    protected synchronized void integrateTransforms() {
    	// No longer: Check if the transform has been changed by another behavior
    	//targetTG.getTransform(currentXfm) ;
    	//if (! targetTransform.equals(currentXfm))
    	//	resetView() ;
            
    	longditudeTransform.rotY( longditude );            
    	latitudeTransform.rotX( latitude );
    	rotateTransform.mul(rotateTransform, latitudeTransform);
    	rotateTransform.mul(rotateTransform, longditudeTransform);

    	// Change of distance since last resetView
    	// distanceFromCenter = startDistanceFromCenter; +/-= ychange*zoomMul
    	distanceVector.z = distanceFromCenter - startDistanceFromCenter;
    	
    	temp1.set(distanceVector);
    	temp1.mul(rotateTransform, temp1);

    	// want to look at rotationCenter
    	transVector.x = rotationCenter.x + xtrans; // xtrans = centerToView.x; +/-= xchange * transXMul
    	transVector.y = rotationCenter.y + ytrans; // ytrans = centerToView.y; +/-= zchange * transYMul;
    	transVector.z = rotationCenter.z + ztrans; // ztrans = centerToView.z; fix while dragging

    	translation.set(transVector);
    	targetTransform.mul(temp1, translation);

    	// handle rotationCenter
    	temp1.set(centerVector);
    	temp1.mul(targetTransform);
           
    	invertCenterVector.x = -centerVector.x;
    	invertCenterVector.y = -centerVector.y;
    	invertCenterVector.z = -centerVector.z;
            
    	temp2.set(invertCenterVector);
    	targetTransform.mul(temp1, temp2);

		// Version 2.0
    	//
		// perspective width: tanFoVHalf
		// default screen scale: physicalScreenWidth/2
		// parallel scale factor: perspective width / default screen scale
		// --> parallelScaleFactor = tanFoVHalf * 2.0 / physicalScreenWidth;
    	//
    	// scale in inversely proportion to distance 'Viewplatform <-> RotationCenter'
    	// --> screenScale = 1 / (distanceFromCenter * parallelScaleFactor)

		if (projection == View.PARALLEL_PROJECTION) {
			
			if (isPureParallelProjection) {
				parallelScale = distanceFromCenter * parallelScaleFactor * parallelScalePure;
			}
			else {							
				parallelScale = distanceFromCenter * parallelScaleFactor;
			}
			
			if (parallelScale > 0) {
				view.setScreenScale(1/parallelScale);
			}
		}

    	targetTG.setTransform(targetTransform);

    	// Version 2.0
    	if (isClippingUpdate) 
    		setClippingDistances();
   
    	// reset yaw and pitch angles
    	longditude = 0.0;
		latitude = 0.0;        
    }
    
    @Override
    public void goHome() {
    	goHome(false);
    }

    @Override
    public void goHome(boolean aroundHomeCenter) {    	
    	if (aroundHomeCenter) 
    		setViewingTransform(homeTransform, homeRotCenter);
    	else
    		setViewingTransform(homeTransform);    	
    }
    /**    
     * Copies the viewing transform of this OrbitBehaviorInterim 
     * into the passed transform object.
     * 
     * @param transform the transform object to be copied into
     * @throws NullPointerException if the passed transform object is null
     * @since Version 2.1
     */
    public void getViewingTransform(Transform3D transform) {
    	if (transform == null)
    		throw new NullPointerException("Transform3D is null !");
    	
    	transform.set(targetTransform);
    }
    /**
     * Sets the viewing transform of this OrbitBehaviorInterim and 
     * the transform component of the viewing TransformGroup object 
     * to the value of the passed transform.
     * 
     * @param transform the transform to be copied
     * @throws NullPointerException if the passed transform object is null
     * @throws IllegalStateException if no viewing TransformGroup object is set for this behavior
     * @throws CapabilityNotSetException if appropriate capability is not set 
     * to the viewing TransformGroup object and this is part of live or compiled scene graph
     * @throws BadTransformException if the transform is not congruent or non-uniform scaling
     * @since Version 2.1
     */
    public void setViewingTransform(Transform3D transform) {
    	if (transform == null)
    		throw new NullPointerException("Transform3D is null !");
    	if (targetTG == null) 
    		throw new IllegalStateException("No TransformGroup object set !");
    	
    	parallelScalePure = 1.0;
    	targetTransform.set(transform);
    	
		resetView();
		integrateTransforms();		
    }
    /**
     * Sets the viewing transform of this OrbitBehaviorInterim and 
     * the transform component of the viewing TransformGroup object 
     * to the value of the passed transform and 
     * sets the center of rotation.
     * 
     * @param transform the transform to be copied
     * @param rotationCenter the center of rotation
     * @throws NullPointerException if the passed transform object is null
     * @throws NullPointerException if the passed center of rotation object is null
     * @throws IllegalStateException if no viewing TransformGroup object is set for this behavior
     * @throws CapabilityNotSetException if appropriate capability is not set 
     * to the viewing TransformGroup object and this is part of live or compiled scene graph
     * @throws BadTransformException if the transform is not congruent or non-uniform scaling
     * @since Version 2.1
     */
    public void setViewingTransform(Transform3D transform, Point3d rotationCenter) {
    	if (transform == null)
    		throw new NullPointerException("Transform3D is null !");
    	if (rotationCenter == null)
    		throw new NullPointerException("Point3d is null !");
    	if (targetTG == null) 
    		throw new IllegalStateException("No TransformGroup object set !");
    	
    	parallelScalePure = 1.0;
    	targetTransform.set(transform);
    	
		resetView();
		integrateTransforms();        	
		
		if (projection == View.PARALLEL_PROJECTION && isPureParallelProjection) 
			distanceFromCenter = 0; // -> distanceOld !> 0;
		setRotationCenter(rotationCenter, false);
    }
    /**
     * Sets the viewing transform of this OrbitBehaviorInterim and 
     * the transform component of the viewing TransformGroup object 
     * according to the values of the passed objects and 
     * sets the center of view to the center of rotation if desired.
	 * <p>
	 * From the passed values a viewing transform is derived based on
	 * <code>transform.lookAt(eye, viewCenter, up)</code>.
	 * </p>
     * @param eye the location of the ViewPlatform
     * @param viewCenter a point in the virtual world where the View is looking
     * @param up an up vector specifying the frustum's up direction
     * @param rotateAtViewCenter if <code>true</code> the center of rotation is set to <code>viewCenter</code>, 
     * if <code>false</code> the current center of rotation is used
     * @throws NullPointerException if the passed eye object is null
     * @throws NullPointerException if the passed center of view object is null
     * @throws NullPointerException if the passed up vector object is null
     * @throws IllegalStateException if no viewing TransformGroup object is set for this behavior
     * @throws CapabilityNotSetException if appropriate capability is not set 
     * to the viewing TransformGroup object and this is part of live or compiled scene graph
     * @throws SingularMatrixException if this transform is not invertible
     * @throws BadTransformException if the transform is not congruent or non-uniform scaling
     * @since Version 2.1
     */
    public void setViewingTransform(Point3d eye, Point3d viewCenter, Vector3d up, boolean rotateAtViewCenter) {
    	if (eye == null)
    		throw new NullPointerException("Point3d eye is null !");
    	if (viewCenter == null)
    		throw new NullPointerException("Point3d viewCenter is null !");
    	if (up == null)
    		throw new NullPointerException("Vector3d up is null !");
    	if (targetTG == null) 
    		throw new IllegalStateException("No TransformGroup object set !");

    	Transform3D transform = new Transform3D();
    	transform.lookAt(eye, viewCenter, up);
    	transform.invert();
    	
    	if (rotateAtViewCenter)
    		setViewingTransform(transform, viewCenter);
    	else
    		setViewingTransform(transform);
    }
    /**
     * Sets the viewing transform of this OrbitBehaviorInterim and 
     * the transform component of the viewing TransformGroup object 
     * according to the values of the passed objects and 
     * sets the center of rotation.
	 * <p>
	 * From the passed values a viewing transform is derived based on
	 * <code>transform.lookAt(eye, viewCenter, up)</code>.
	 * </p>
     * @param eye the location of the ViewPlatform
     * @param viewCenter a point in the virtual world where the View is looking
     * @param up an up vector specifying the frustum's up direction
     * @param rotationCenter the center of rotation
     * @throws NullPointerException if the passed eye object is null
     * @throws NullPointerException if the passed center of view object is null
     * @throws NullPointerException if the passed up vector object is null
     * @throws NullPointerException if the passed center of rotation object is null
     * @throws IllegalStateException if no viewing TransformGroup object is set for this behavior
     * @throws CapabilityNotSetException if appropriate capability is not set 
     * to the viewing TransformGroup object and this is part of live or compiled scene graph
     * @throws SingularMatrixException if this transform is not invertible
     * @throws BadTransformException if the transform is not congruent or non-uniform scaling
     * @since Version 2.1
     */
    public void setViewingTransform(Point3d eye, Point3d viewCenter, Vector3d up, Point3d rotationCenter) {
    	if (eye == null)
    		throw new NullPointerException("Point3d eye is null !");
    	if (viewCenter == null)
    		throw new NullPointerException("Point3d viewCenter is null !");
    	if (up == null)
    		throw new NullPointerException("Vector3d up is null !");
    	if (rotationCenter == null)
    		throw new NullPointerException("Point3d rotationCenter is null !");
    	if (targetTG == null) 
    		throw new IllegalStateException("No TransformGroup object set !");

    	Transform3D transform = new Transform3D();
    	transform.lookAt(eye, viewCenter, up);
    	transform.invert();
    	
    	setViewingTransform(transform, rotationCenter);
    }
    /** 
     * Sets the center around which the View rotates. 
     * If the viewing TransformGroup isn't set the center is updated, 
     * but rotation may not behave as expected.
     * The default center is (0,0,0).
     * @param center the Point3d to set the center of rotation to
     */
    public void setRotationCenter(Point3d center) {    	
    	setRotationCenter(center, false);
    }
    /**
     * Sets the center around which the View rotates and moves the View to this center if desired.
     * If the viewing TransformGroup isn't set only the center is updated, 
     * but rotation may not behave as expected.
     * The default center is (0,0,0). 
     * @param center The Point3d to set the center of rotation to
     * @param lookAtRotCenter if <code>true</code> the View is moved to the center of rotation, otherwise the View is unchanged
     * @since Version 1.1
     */
    public void setRotationCenter(Point3d center, boolean lookAtRotCenter) {
    	/*
    	 * OrbitBehavior (original)
    	 * Revision: 1.6 
    	 * Date: 2007/10/08 
    	 *     	   
    	 *    	
    	Point3d centerDelta = new Point3d();
    	centerDelta.sub(centerVector, center);
    	Transform3D invRot = new Transform3D(rotateTransform);
    	invRot.invert();
    	invRot.transform(centerDelta);
    	xtrans += centerDelta.x;
    	ytrans += centerDelta.y;
    	ztrans += centerDelta.z;
    	*/ 

    	rotationCenter.x = center.x;
		rotationCenter.y = center.y;
		rotationCenter.z = center.z;
		centerVector.set(rotationCenter);
        	
		if (targetTG == null)
			return;
		
    	if (projection == View.PARALLEL_PROJECTION) {    	
    		if (lookAtRotCenter) {
    			// For pure and non pure parallel projection
    			resetViewParallelLookAtRotCenter();
    		}
    		else {
    			if (isPureParallelProjection)
    				resetViewPureParallelRotCenter();
    			else 
    				resetView();
    		}
    	}
    	else {
    		resetView();
            if (lookAtRotCenter) {
            	xtrans = 0;
            	ytrans = 0;
            }
    	}
    	
        integrateTransforms();
    }
    /**
     * Moves the View to the current center of rotation. 
     * This method has no effect if the viewing TransformGroup isn't set.
     * @since Version 1.1
     */
    public void lookAtRotationCenter() {
        if (targetTG != null) {        	
        	resetView();
        	xtrans = 0;
        	ytrans = 0;            
            integrateTransforms();
        }
    }

    /**
     * Places the value of the center around which the View rotates
     * into the Point3d.
     * @param center The Point3d
     */
    public void getRotationCenter(Point3d center) {
		center.x = rotationCenter.x;
		center.y = rotationCenter.y;
		center.z = rotationCenter.z;
    }

    // 
    // Need to add key factors for Rotate, Translate and Zoom
    // Method calls should just update MAX_KEY_ANGLE, KEY_TRANSLATE and
    // KEY_ZOOM
    //
    // Methods also need to correctly set sign of variables depending on
    // the Reverse settings.
    
    /**
     * Sets the rotation x and y factors.  The factors are used to determine
     * how many radians to rotate the view for each pixel of mouse movement.
     * The view is rotated factor * 0.01 radians for each pixel of mouse
     * movement.  The default factor is 1.0.
     * @param xfactor The x movement multiplier
     * @param yfactor The y movement multiplier
     **/   
    public synchronized void setRotFactors(double xfactor, double yfactor) {
		rotXFactor = xfactor;
		rotYFactor = yfactor;
		rotXMul = NOMINAL_ROT_FACTOR * xfactor;
		rotYMul = NOMINAL_ROT_FACTOR * yfactor;
    }
    
    /**
     * Sets the rotation x factor.  The factors are used to determine
     * how many radians to rotate the view for each pixel of mouse movement.
     * The view is rotated factor * 0.01 radians for each pixel of mouse
     * movement.  The default factor is 1.0.
     * @param xfactor The x movement multiplier
     **/   
    public synchronized void setRotXFactor(double xfactor) {
		rotXFactor = xfactor;
		rotXMul = NOMINAL_ROT_FACTOR * xfactor;
    }

    /**
     * Sets the rotation y factor.  The factors are used to determine
     * how many radians to rotate the view for each pixel of mouse movement.
     * The view is rotated factor * 0.01 radians for each pixel of mouse
     * movement.  The default factor is 1.0.
     * @param yfactor The y movement multiplier
     **/   
    public synchronized void setRotYFactor(double yfactor) {
		rotYFactor = yfactor;
		rotYMul = NOMINAL_ROT_FACTOR * yfactor;
    }
    
    /**
     * Sets the translation x and y factors.  The factors are used to determine
     * how many units to translate the view for each pixel of mouse movement.
     * The view is translated factor * 0.01 units for each pixel of mouse
     * movement.  The default factor is 1.0.
     * @param xfactor The x movement multiplier
     * @param yfactor The y movement multiplier
     **/   
    public synchronized void setTransFactors(double xfactor, double yfactor) {
		transXFactor = xfactor;
		transYFactor = yfactor;
		transXMul = NOMINAL_TRANS_FACTOR * xfactor;
		transYMul = NOMINAL_TRANS_FACTOR * yfactor;
    }

    /**
     * Sets the translation x factor.  The factors are used to determine
     * how many units to translate the view for each pixel of mouse movement.
     * The view is translated factor * 0.01 units for each pixel of mouse
     * movement.  The default factor is 1.0.
     * @param xfactor The x movement multiplier
     **/   
    public synchronized void setTransXFactor(double xfactor) {
		transXFactor = xfactor;
		transXMul = NOMINAL_TRANS_FACTOR * xfactor;
    }
    
    /**
     * Sets the translation y factor.  The factors are used to determine
     * how many units to translate the view for each pixel of mouse movement.
     * The view is translated factor * 0.01 units for each pixel of mouse
     * movement.  The default factor is 1.0.
     * @param yfactor The y movement multiplier
     **/   
    public synchronized void setTransYFactor(double yfactor) {
		transYFactor = yfactor;
		transYMul = NOMINAL_TRANS_FACTOR * yfactor;
    }
    
    /**
     * Sets the zoom factor.  The factor is used to determine how many
     * units to zoom the view for each pixel of mouse movement.
     * The view is zoomed factor * 0.01 units for each pixel of mouse
     * movement.  For proportional zoom, the view is zoomed factor * 1%
     * of the distance from the center of rotation for each pixel of
     * mouse movement.  The default factor is 1.0.
     * @param zfactor The movement multiplier
     */
    public synchronized void setZoomFactor(double zfactor) {
    	zoomFactor = zfactor;
    	if (proportionalZoom) {
    		zoomMul = NOMINAL_PZOOM_FACTOR * zfactor;
    	}
    	else {
    		zoomMul = NOMINAL_ZOOM_FACTOR * zfactor;
    	}
    }
    
    /**
     * Returns the x rotation movement multiplier
     * @return The movement multiplier for x rotation
     */
    public double getRotXFactor() {
    	return rotXFactor;
    }

    /**
     * Returns the y rotation movement multiplier
     * @return The movement multiplier for y rotation
     */
    public double getRotYFactor() {
    	return rotYFactor;
    }

    /**
     * Returns the x translation movement multiplier
     * @return The movement multiplier for x translation
     */
    public double getTransXFactor() {
    	return transXFactor;
    }

    /**
     * Returns the y translation movement multiplier
     * @return The movement multiplier for y translation
     */
    public double getTransYFactor() {
    	return transYFactor;
    }

    /**
     * Returns the zoom movement multiplier
     * @return The movement multiplier for zoom
     */
    public double getZoomFactor() {
    	return zoomFactor;
    }

    /**
     * Enables or disables rotation.  The default is true.
     * @param enabled true or false to enable or disable rotate
     */
    public synchronized void setRotateEnable(boolean enabled) {
    	rotateEnabled = enabled;
    }
    
    /**
     * Enables or disables zoom. The default is true.
     * @param enabled true or false to enable or disable zoom
     */
    public synchronized void setZoomEnable(boolean enabled) {
    	zoomEnabled = enabled;
    }
    
    /**
     * Enables or disables translate. The default is true.
     * @param enabled true or false to enable or disable translate
     */
    public synchronized void setTranslateEnable(boolean enabled) {
    	translateEnabled = enabled;
    }
    
    /**
     * Retrieves the state of rotate enabled
     * @return the rotate enable state
     */
    public boolean getRotateEnable() {
    	return rotateEnabled;
    }

    /**
     * Retrieves the state of zoom enabled
     * @return the zoom enable state
     */
    public boolean getZoomEnable() {
    	return zoomEnabled;
    }

    /**
     * Retrieves the state of translate enabled
     * @return the translate enable state
     */
    public boolean getTranslateEnable() {
    	return translateEnabled;
    }

    boolean rotate(MouseEvent evt) {
    	if (rotateEnabled) {
    		if ((leftButton == ROTATE) &&
    				(!evt.isAltDown() && !evt.isMetaDown())) {
    			return true;
    		}
    		if ((middleButton == ROTATE) &&
    				(evt.isAltDown() && !evt.isMetaDown())) {
    			return true;
    		}
    		if ((rightButton == ROTATE) &&
    				(!evt.isAltDown() && evt.isMetaDown())) {
    			return true;
    		}
    	}
    	return false;
    }

    boolean zoom(MouseEvent evt) {
    	if (zoomEnabled) {
    		if (evt instanceof java.awt.event.MouseWheelEvent) {
    			return true;
    		}
    		if ((leftButton == ZOOM) &&
    				(!evt.isAltDown() && !evt.isMetaDown())) {
    			return true;
    		}
    		if ((middleButton == ZOOM) &&
    				(evt.isAltDown() && !evt.isMetaDown())) {
    			return true;
    		}
	    	if ((rightButton == ZOOM) &&
	    			(!evt.isAltDown() && evt.isMetaDown())) {
	    		return true;
	    	}
    	}
    	return false;
    }

    boolean translate(MouseEvent evt) {
    	if (translateEnabled) {
    		if ((leftButton == TRANSLATE) &&
    				(!evt.isAltDown() && !evt.isMetaDown())) {
    			return true;
    		}
    		if ((middleButton == TRANSLATE) &&
    				(evt.isAltDown() && !evt.isMetaDown())) {
    			return true;
    		}
    		if ((rightButton == TRANSLATE) &&
    				(!evt.isAltDown() && evt.isMetaDown())) {
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * Sets the minimum radius for the OrbitBehavior.  The zoom will
     * stop at this distance from the center of rotation.  The default
     * is 0.0.  The minimum will have no affect if the STOP_ZOOM constructor
     * flag is not set.
     * @param r the minimum radius
     * @exception IllegalArgumentException if the radius is less than 0.0
     */
    public synchronized void setMinRadius(double r) {
    	if (r < 0.0) {
    		throw new IllegalArgumentException("OrbitBehavior MinRadius < 0.0 !!");
    	}
    	minRadius = r;
    }
    
    /**
     * Returns the minimum orbit radius.  The zoom will stop at this distance
     * from the center of rotation if the STOP_ZOOM constructor flag is set.
     * @return the minimum radius
     */
    public double getMinRadius() {
    	return minRadius;
    }

    /**
     * Set reverse translate behavior.  The default is false.
     * @param state if true, reverse translate behavior
     * @since Java 3D 1.3
     */
    public void setReverseTranslate(boolean state) {
    	reverseTrans = state;
    }
    
    /**
     * Set reverse rotate behavior.  The default is false.
     * @param state if true, reverse rotate behavior
     * @since Java 3D 1.3
     */
    public void setReverseRotate(boolean state) {
    	reverseRotate = state;
    }
    
    /**
     * Set reverse zoom behavior.  The default is false.
     * @param state if true, reverse zoom behavior
     * @since Java 3D 1.3
     */
    public void setReverseZoom(boolean state) {
    	reverseZoom = state;
    }
    
    /**
     * Set proportional zoom behavior.  The default is false.
     * @param state if true, use proportional zoom behavior
     * @since Java 3D 1.3
     */
    public synchronized void setProportionalZoom(boolean state) {
    	proportionalZoom = state;

    	if (state) {
    		zoomMul = NOMINAL_PZOOM_FACTOR * zoomFactor;
    	}
    	else {
    		zoomMul = NOMINAL_ZOOM_FACTOR * zoomFactor;
    	}
    }
}

