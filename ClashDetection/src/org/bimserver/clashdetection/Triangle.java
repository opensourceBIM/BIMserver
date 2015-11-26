package org.bimserver.clashdetection;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.bimserver.geometry.Matrix;

/*
 * 
 * Most of the code has been ported from http://webee.technion.ac.il/labs/cgm/Computer-Graphics-Multimedia/Software/TriangleIntersection/code.cpp
 * 
 */
public class Triangle {
	private float[] vertex1;
	private float[] vertex2;
	private float[] vertex3;
	
	private static final boolean useEpsilonTest = true;
	private static final float epsilon = 1f; 

	public Triangle(IntBuffer indices, FloatBuffer vertices, int i, float[] transformation) {
		int index1 = indices.get(i);
		int index2 = indices.get(i + 1);
		int index3 = indices.get(i + 2);

		vertex1 = Matrix.multiplyV(transformation, new float[]{vertices.get(index1 * 3), vertices.get(index1 * 3 + 1), vertices.get(index1 * 3 + 2)});
		vertex2 = Matrix.multiplyV(transformation, new float[]{vertices.get(index2 * 3), vertices.get(index2 * 3 + 1), vertices.get(index2 * 3 + 2)});
		vertex3 = Matrix.multiplyV(transformation, new float[]{vertices.get(index3 * 3), vertices.get(index3 * 3 + 1), vertices.get(index3 * 3 + 2)});
	}
	
	public float[] NEWCOMPUTE_INTERVALS(float VV0, float VV1, float VV2, float D0, float D1, float D2, float D0D1, float D0D2) {
		float A;
		float B;
		float C;
		float X0;
		float X1;
        if(D0D1>0.0f) 
        { 
                /* here we know that D0D2<=0.0 */ 
            /* that is D0, D1 are on the same side, D2 on the other or on the plane */ 
                A=VV2; B=(VV0-VV2)*D2; C=(VV1-VV2)*D2; X0=D2-D0; X1=D2-D1; 
        } 
        else if(D0D2>0.0f)
        { 
                /* here we know that d0d1<=0.0 */ 
            A=VV1; B=(VV0-VV1)*D1; C=(VV2-VV1)*D1; X0=D1-D0; X1=D1-D2; 
        } 
        else if(D1*D2>0.0f || D0!=0.0f) 
        { 
                /* here we know that d0d1<=0.0 or that D0!=0.0 */ 
                A=VV0; B=(VV1-VV0)*D0; C=(VV2-VV0)*D0; X0=D0-D1; X1=D0-D2; 
        } 
        else if(D1!=0.0f) 
        { 
                A=VV1; B=(VV0-VV1)*D1; C=(VV2-VV1)*D1; X0=D1-D0; X1=D1-D2; 
        } 
        else if(D2!=0.0f)
        { 
                A=VV2; B=(VV0-VV2)*D2; C=(VV1-VV2)*D2; X0=D2-D0; X1=D2-D1; 
        } 
        else 
        {
                /* triangles are coplanar */
                return null;
        } 
        return new float[]{A, B, C, X0, X1};
	}

	private boolean POINT_IN_TRI(float V0[], float U0[], float U1[], float U2[], int i0, int i1) {                                           
	  float a,b,c,d0,d1,d2;                     
	  /* is T1 completly inside T2? */          
	  /* check if V0 is inside tri(U0,U1,U2) */ 
	  a=U1[i1]-U0[i1];                          
	  b=-(U1[i0]-U0[i0]);                       
	  c=-a*U0[i0]-b*U0[i1];                     
	  d0=a*V0[i0]+b*V0[i1]+c;                   
	                                            
	  a=U2[i1]-U1[i1];                          
	  b=-(U2[i0]-U1[i0]);                       
	  c=-a*U1[i0]-b*U1[i1];                     
	  d1=a*V0[i0]+b*V0[i1]+c;                   
	                                            
	  a=U0[i1]-U2[i1];                          
	  b=-(U0[i0]-U2[i0]);                       
	  c=-a*U2[i0]-b*U2[i1];                     
	  d2=a*V0[i0]+b*V0[i1]+c;                   
	  if(d0*d1>0.0)                             
	  {                                         
	    if(d0*d2>0.0) return true;                 
	  }                          
	  return false;
	}
	
	public boolean coplanar_tri_tri(float N[], float V0[], float V1[], float V2[], float U0[], float U1[], float U2[]) {
		float A[] = new float[3];
		short i0,i1;
		/* first project onto an axis-aligned plane, that maximizes the area */
		/* of the triangles, compute indices: i0,i1. */
		A[0]=Math.abs(N[0]);
		A[1]=Math.abs(N[1]);
		A[2]=Math.abs(N[2]);
		if(A[0]>A[1])
		{
		if(A[0]>A[2])
		{
		 i0=1;      /* A[0] is greatest */
		 i1=2;
		}
		else
		{
		 i0=0;      /* A[2] is greatest */
		 i1=1;
		}
		}
		else   /* A[0]<=A[1] */
		{
		if(A[2]>A[1])
		{
		 i0=0;      /* A[2] is greatest */
		 i1=1;
		}
		else
		{
		 i0=0;      /* A[1] is greatest */
		 i1=2;
		}
		}
		
		/* test all edges of triangle 1 against the edges of triangle 2 */
		
		if (EDGE_AGAINST_TRI_EDGES(V0,V1,U0,U1,U2, i0, i1)) {
			return true;
		}
		if (EDGE_AGAINST_TRI_EDGES(V1,V2,U0,U1,U2, i0, i1)) {
			return true;
		}
		if (EDGE_AGAINST_TRI_EDGES(V2,V0,U0,U1,U2, i0, i1)) {
			return true;
		}
		
		/* finally, test if tri1 is totally contained in tri2 or vice versa */
		if (POINT_IN_TRI(V0,U0,U1,U2, i0, i1)) {
			return true;
		}
		if (POINT_IN_TRI(U0,V0,V1,V2, i0, i1)) {
			return true;
		}
		
		return false;
	}
	
	private boolean EDGE_EDGE_TEST(float V0[], float U0[], float U1[], int i0, int i1, double Ax, double Ay) {
	 double Bx,By,Cx,Cy,e,d,f;
	  Bx=U0[i0]-U1[i0];                                   
	  By=U0[i1]-U1[i1];                                   
	  Cx=V0[i0]-U0[i0];                                   
	  Cy=V0[i1]-U0[i1];                                   
	  f=Ay*Bx-Ax*By;                                      
	  d=By*Cx-Bx*Cy;                                      
	  if((f>0 && d>=0 && d<=f) || (f<0 && d<=0 && d>=f))  
	  {                                                   
	    e=Ax*Cy-Ay*Cx;                                    
	    if(f>0)                                           
	    {                                                 
	      if(e>=0 && e<=f) return true;                      
	    }                                                 
	    else                                              
	    {                                                 
	      if(e<=0 && e>=f) return true;                      
	    }                                                 
	  }
	  return false;
	}
	  
	 private boolean EDGE_AGAINST_TRI_EDGES(float[] V0, float[] V1, float[] U0, float[] U1, float[] U2, int i0, int i1) 
	  {                                              
	    double Ax,Ay;               
	    Ax=V1[i0]-V0[i0];                            
	    Ay=V1[i1]-V0[i1];                            
	    /* test edge U0,U1 against V0,V1 */          
	    if (EDGE_EDGE_TEST(V0,U0,U1,i0, i1, Ax, Ay)) {
	    	return true;
	    }
	    /* test edge U1,U2 against V0,V1 */          
	    if (EDGE_EDGE_TEST(V0,U1,U2, i0, i1, Ax, Ay)) {
	    	return true;
	    }
	    /* test edge U2,U1 against V0,V1 */          
	    if (EDGE_EDGE_TEST(V0,U2,U0, i0, i1, Ax, Ay)) {
	    	return true;
	    }
	    return false;
	  }
	  
	public boolean intersects(Triangle triangle2) {
		float []E1 = new float[3];
		float []E2 = new float[3];
		float []N1 = new float[3];
		float []N2 = new float[3];
		float d1;
		float d2;
		float du0,du1,du2,dv0,dv1,dv2;
		float []D = new float[3];
		float []isect1 = new float[2];
		float []isect2 = new float[2];
		float du0du1,du0du2,dv0dv1,dv0dv2;
		short index;
		float vp0,vp1,vp2;
		float up0,up1,up2;
		float bb,cc,max;
		
		/* compute plane equation of triangle(V0,V1,V2) */
		E1 = Vector.minus(vertex2, vertex1);
		E2 = Vector.minus(vertex3, vertex1);
		N1 = Vector.crossProduct(E1, E2);
		d1= -Vector.dot(N1, vertex1);
		/* plane equation 1: N1.X+d1=0 */
		
		/* put U0,U1,U2 into plane equation 1 to compute signed distances to the plane*/
		du0 = Vector.dot(N1, triangle2.vertex1) + d1;
		du1 = Vector.dot(N1, triangle2.vertex2) + d1;
		du2 = Vector.dot(N1, triangle2.vertex3) + d1;
		
		if (useEpsilonTest) {
			if(Math.abs(du0)<epsilon) du0=0.0f;
			if(Math.abs(du1)<epsilon) du1=0.0f;
			if(Math.abs(du2)<epsilon) du2=0.0f;
		}

		du0du1=du0*du1;
		du0du2=du0*du2;
		
		if(du0du1>0.0f && du0du2>0.0f) /* same sign on all of them + not equal 0 ? */
		return false;                    /* no intersection occurs */
		
		/* compute plane of triangle (U0,U1,U2) */
		E1 = Vector.minus(triangle2.vertex2, triangle2.vertex1);
		E2 = Vector.minus(triangle2.vertex3, triangle2.vertex1);
		N2 = Vector.crossProduct(E1, E2);
		d2 = -Vector.dot(N2, triangle2.vertex1);
		/* plane equation 2: N2.X+d2=0 */
		
		/* put V0,V1,V2 into plane equation 2 */
		dv0 = Vector.dot(N2, vertex1) + d2;
		dv1 = Vector.dot(N2, vertex2) + d2;
		dv2 = Vector.dot(N2, vertex3) + d2;
		
		if (useEpsilonTest) {
			if(Math.abs(dv0)<epsilon) dv0=0.0f;
			if(Math.abs(dv1)<epsilon) dv1=0.0f;
			if(Math.abs(dv2)<epsilon) dv2=0.0f;
		}
		
		dv0dv1=dv0*dv1;
		dv0dv2=dv0*dv2;
		
		if(dv0dv1>0.0f && dv0dv2>0.0f) /* same sign on all of them + not equal 0 ? */
		return false;                    /* no intersection occurs */
		
		/* compute direction of intersection line */
		D = Vector.crossProduct(N1, N2);
		
		/* compute and index to the largest component of D */
		max=(float)Math.abs(D[0]);
		index=0;
		bb=(float)Math.abs(D[1]);
		cc=(float)Math.abs(D[2]);
		if(bb>max) { max=bb; index=1;}
		if(cc>max) { max=cc; index=2;};
		
		/* this is the simplified projection onto L*/
		vp0=vertex1[index];
		vp1=vertex2[index];
		vp2=vertex3[index];
		
		up0=triangle2.vertex1[index];
		up1=triangle2.vertex2[index];
		up2=triangle2.vertex3[index];
		
		/* compute interval for triangle 1 */
		float[] nci1 = NEWCOMPUTE_INTERVALS(vp0,vp1,vp2,dv0,dv1,dv2,dv0dv1,dv0dv2);
		if (nci1 == null) {
            if (coplanar_tri_tri(N1,vertex1,vertex2,vertex3,triangle2.vertex1,triangle2.vertex2,triangle2.vertex3)) {
            	return true;
            }
            return false;
		}
		float a = nci1[0];
		float b = nci1[1];
		float c = nci1[2];
		float x0 = nci1[3];
		float x1 = nci1[4];
		
		/* compute interval for triangle 2 */
		float[] nci2 = NEWCOMPUTE_INTERVALS(up0,up1,up2,du0,du1,du2,du0du1,du0du2);
		if (nci2 == null) {
            if (coplanar_tri_tri(N1,vertex1,vertex2,vertex3,triangle2.vertex1,triangle2.vertex2,triangle2.vertex3)) {
            	return true;
            }
            return false;
		}
		float d = nci2[0];
		float e = nci2[1];
		float f = nci2[2];
		float y0 = nci2[3];
		float y1 = nci2[4];
		
		float xx,yy,xxyy,tmp;
		xx=x0*x1;
		yy=y0*y1;
		xxyy=xx*yy;
		
		tmp=a*xxyy;
		isect1[0]=tmp+b*x1*yy;
		isect1[1]=tmp+c*x0*yy;
		
		tmp=d*xxyy;
		isect2[0]=tmp+e*xx*y1;
		isect2[1]=tmp+f*xx*y0;
		
		if (isect1[0] > isect1[1]) {
			float x = isect1[0];
			isect1[0] = isect1[1];
			isect1[1] = x;
		}
		if (isect2[0] > isect2[1]) {
			float x = isect2[0];
			isect2[0] = isect2[1];
			isect2[1] = x;
		}
		
		if(isect1[1] < isect2[0] || isect2[1] < isect1[0]) return false;
		return true;
	}
}