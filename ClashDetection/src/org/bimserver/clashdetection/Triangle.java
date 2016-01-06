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
	private double[] vertex1;
	private double[] vertex2;
	private double[] vertex3;
	
	public Triangle(IntBuffer indices, FloatBuffer vertices, int i, double[] transformation) {
		int index1 = indices.get(i) * 3;
		int index2 = indices.get(i + 1) * 3;
		int index3 = indices.get(i + 2) * 3;

		vertex1 = Matrix.multiplyV(transformation, new double[]{vertices.get(index1), vertices.get(index1 + 1), vertices.get(index1 + 2)});
		vertex2 = Matrix.multiplyV(transformation, new double[]{vertices.get(index2), vertices.get(index2 + 1), vertices.get(index2 + 2)});
		vertex3 = Matrix.multiplyV(transformation, new double[]{vertices.get(index3), vertices.get(index3 + 1), vertices.get(index3 + 2)});
	}
	
	public double[] NEWCOMPUTE_INTERVALS(double VV0, double VV1, double VV2, double D0, double D1, double D2, double D0D1, double D0D2) {
		double A;
		double B;
		double C;
		double X0;
		double X1;
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
        return new double[]{A, B, C, X0, X1};
	}

	private boolean POINT_IN_TRI(double V0[], double U0[], double U1[], double U2[], int i0, int i1) {                                           
	  double a,b,c,d0,d1,d2;                     
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
	
	public int coplanar_tri_tri(double N[], double V0[], double V1[], double V2[], double U0[], double U1[], double U2[]) {
		double A[] = new double[3];
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
			return 1;
		}
		if (EDGE_AGAINST_TRI_EDGES(V1,V2,U0,U1,U2, i0, i1)) {
			return 1;
		}
		if (EDGE_AGAINST_TRI_EDGES(V2,V0,U0,U1,U2, i0, i1)) {
			return 1;
		}
		
		/* finally, test if tri1 is totally contained in tri2 or vice versa */
		if (POINT_IN_TRI(V0,U0,U1,U2, i0, i1)) {
			return 1;
		}
		if (POINT_IN_TRI(U0,V0,V1,V2, i0, i1)) {
			return 1;
		}
		
		return 0;
	}
	
	private boolean EDGE_EDGE_TEST(double V0[], double U0[], double U1[], int i0, int i1, double Ax, double Ay) {
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
	  
	 private boolean EDGE_AGAINST_TRI_EDGES(double[] V0, double[] V1, double[] U0, double[] U1, double[] U2, int i0, int i1) 
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
	 
//	 public void myVmV(double[] g, double[] v2, double[] v1) {
//	 	g[0] = v2[0]-v1[0];
//	 	g[1] = v2[1]-v1[1];
//	 	g[2] = v2[2]-v1[2];
//	}
//	 
//	 public void myVpV(double[]g, double[]v2, double[] v1) {
//	 	g[0] = v2[0]+v1[0];
//	 	g[1] = v2[1]+v1[1];
//	 	g[2] = v2[2]+v1[2];
//	 }
//	 
//	 public void sVpsV_2( double[] Vr, double s1,  double[] V1, double s2, double[]V2) {
//	  Vr[0] = s1*V1[0] + s2*V2[0];
//	  Vr[1] = s1*V1[1] + s2*V2[1];
//	}
//	 
//	 public int tr_tri_intersect3D (double[] C1, double[] P1, double[] P2, double[] D1, double[] Q1, double[] Q2) {
//		double t[] = new double[3];
//		double p1[] = new double[3];
//		double p2[] = new double[3];
//		double r[] = new double[3];
//		double r4[] = new double[3];
//		double beta1, beta2, beta3;
//		double gama1, gama2, gama3;
//		double det1, det2, det3;
//		double dp0, dp1, dp2;
//		double dq1,dq2,dq3,dr, dr3;
//		double alpha1, alpha2;
//		boolean alpha1_legal, alpha2_legal;
//		double  SF = 0.0;
//		boolean beta1_legal, beta2_legal;
//				
//		myVmV(r,D1,C1);
//		// determinant computation	
//		dp0 = P1[1]*P2[2]-P2[1]*P1[2];
//		dp1 = P1[0]*P2[2]-P2[0]*P1[2];
//		dp2 = P1[0]*P2[1]-P2[0]*P1[1];
//		dq1 = Q1[0]*dp0 - Q1[1]*dp1 + Q1[2]*dp2;
//		dq2 = Q2[0]*dp0 - Q2[1]*dp1 + Q2[2]*dp2;
//		dr  = -r[0]*dp0  + r[1]*dp1  - r[2]*dp2;
//
//		
//		
//		beta1 = dr*dq2;  // beta1, beta2 are scaled so that beta_i=beta_i*dq1*dq2
//		beta2 = dr*dq1;
//		beta1_legal = (beta2>=0) && (beta2 <=dq1*dq1) && (dq1 != 0);
//		beta2_legal = (beta1>=0) && (beta1 <=dq2*dq2) && (dq2 != 0);
//			
//		dq3=dq2-dq1;
//		dr3=+dr-dq1;   // actually this is -dr3
//		
//
//		if ((dq1 == 0) && (dq2 == 0))
//		{
//			if (dr!=0) return 0;  // triangles are on parallel planes
//			else
//			{						// triangles are on the same plane
//				double C2[] = new double[3];
//				double C3[] = new double[3];
//				double D2[] = new double[3];
//				double D3[] = new double[3];
//				double N1[] = new double[3];
//				// We use the coplanar test of Moller which takes the 6 vertices and 2 normals  
//				//as input.
//				myVpV(C2,C1,P1);
//				myVpV(C3,C1,P2);
//				myVpV(D2,D1,Q1);
//				myVpV(D3,D1,Q2);
//				N1 = Vector.crossProduct(P1,P2);
//				return coplanar_tri_tri(N1,C1, C2,C3,D1,D2,D3);
//			}
//		}
//
//		else if (!beta2_legal && !beta1_legal) return 0;// fast reject-all vertices are on
//														// the same side of the triangle plane
//
//		else if (beta2_legal && beta1_legal)    //beta1, beta2
//		{
//			SF = dq1*dq2;
//			sVpsV_2(t,beta2,Q2, (-beta1),Q1);
//		}
//		
//		else if (beta1_legal && !beta2_legal)   //beta1, beta3
//		{
//			SF = dq1*dq3;
//			beta1 =beta1-beta2;   // all betas are multiplied by a positive SF
//			beta3 =dr3*dq1;
//			sVpsV_2(t,(SF-beta3-beta1),Q1,beta3,Q2);
//		}
//		
//		else if (beta2_legal && !beta1_legal) //beta2, beta3
//		{
//			SF = dq2*dq3;
//			beta2 =beta1-beta2;   // all betas are multiplied by a positive SF
//			beta3 =dr3*dq2;
//			sVpsV_2(t,(SF-beta3),Q1,(beta3-beta2),Q2);
//			Q1=Q2;
//			beta1=beta2;
//		}
//		sVpsV_2(r4,SF,r,beta1,Q1);
//		
//		
//		
//		
//		
////		seg_collide3(t,r4);  // calculates the 2D intersection
//		
//		{
//			double[] q = t;
//			double[] r2 = r4;
//			
//			p1[0]=SF*P1[0];
//			p1[1]=SF*P1[1];
//			p2[0]=SF*P2[0];
//			p2[1]=SF*P2[1];
//			det1 = p1[0]*q[1]-q[0]*p1[1];
//			gama1 = (p1[0]*r2[1]-r2[0]*p1[1])*det1;
//			alpha1 = (r2[0]*q[1] - q[0]*r2[1])*det1;
//			alpha1_legal = (alpha1>=0) && (alpha1<=(det1*det1)  && (det1!=0));
//			det2 = p2[0]*q[1] - q[0]*p2[1];
//			alpha2 = (r2[0]*q[1] - q[0]*r2[1]) *det2;
//			gama2 = (p2[0]*r2[1] - r2[0]*p2[1]) * det2;
//			alpha2_legal = (alpha2>=0) && (alpha2<=(det2*det2) && (det2 !=0));
//			det3=det2-det1;
//			gama3=((p2[0]-p1[0])*(r2[1]-p1[1]) - (r2[0]-p1[0])*(p2[1]-p1[1]))*det3;
//			if (alpha1_legal)
//			{
//				if (alpha2_legal)
//				{
//					if ( ((gama1<=0) && (gama1>=-(det1*det1))) || ((gama2<=0) && (gama2>=-(det2*det2))) || (gama1*gama2<0)) return 12;
//				}
//				else
//				{
//					if ( ((gama1<=0) && (gama1>=-(det1*det1))) || ((gama3<=0) && (gama3>=-(det3*det3))) || (gama1*gama3<0)) return 13;
//				}
//			}
//			else
//				if (alpha2_legal)
//				{
//					if ( ((gama2<=0) && (gama2>=-(det2*det2))) || ((gama3<=0) && (gama3>=-(det3*det3))) || (gama2*gama3<0)) return 23;
//				}
//			return 0;
//		}
//	}

	public boolean intersects(Triangle triangle2, double epsilon) {
		double []E1 = new double[3];
		double []E2 = new double[3];
		double []N1 = new double[3];
		double []N2 = new double[3];
		double d1;
		double d2;
		double du0,du1,du2,dv0,dv1,dv2;
		double []D = new double[3];
		double []isect1 = new double[2];
		double []isect2 = new double[2];
		double du0du1,du0du2,dv0dv1,dv0dv2;
		short index;
		double vp0,vp1,vp2;
		double up0,up1,up2;
		double bb,cc,max;
		
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
		
		if(Math.abs(du0)<epsilon) du0=0.0;
		if(Math.abs(du1)<epsilon) du1=0.0;
		if(Math.abs(du2)<epsilon) du2=0.0;

		du0du1=du0*du1;
		du0du2=du0*du2;
		
		if(du0du1>0.0 && du0du2>0.0) /* same sign on all of them + not equal 0 ? */
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
		
		if(Math.abs(dv0)<epsilon) dv0=0.0;
		if(Math.abs(dv1)<epsilon) dv1=0.0;
		if(Math.abs(dv2)<epsilon) dv2=0.0;
		
		dv0dv1=dv0*dv1;
		dv0dv2=dv0*dv2;
		
		if(dv0dv1>0.0 && dv0dv2>0.0) /* same sign on all of them + not equal 0 ? */
		return false;                    /* no intersection occurs */
		
		/* compute direction of intersection line */
		D = Vector.crossProduct(N1, N2);
		
		/* compute and index to the largest component of D */
		max=(double)Math.abs(D[0]);
		index=0;
		bb=(double)Math.abs(D[1]);
		cc=(double)Math.abs(D[2]);
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
		double[] nci1 = NEWCOMPUTE_INTERVALS(vp0,vp1,vp2,dv0,dv1,dv2,dv0dv1,dv0dv2);
		if (nci1 == null) {
           return coplanar_tri_tri(N1,vertex1,vertex2,vertex3,triangle2.vertex1,triangle2.vertex2,triangle2.vertex3) == 1;
		}
		double a = nci1[0];
		double b = nci1[1];
		double c = nci1[2];
		double x0 = nci1[3];
		double x1 = nci1[4];
		
		/* compute interval for triangle 2 */
		double[] nci2 = NEWCOMPUTE_INTERVALS(up0,up1,up2,du0,du1,du2,du0du1,du0du2);
		if (nci2 == null) {
            return coplanar_tri_tri(N1,vertex1,vertex2,vertex3,triangle2.vertex1,triangle2.vertex2,triangle2.vertex3) == 1;
		}
		double d = nci2[0];
		double e = nci2[1];
		double f = nci2[2];
		double y0 = nci2[3];
		double y1 = nci2[4];
		
		double xx,yy,xxyy,tmp;
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
			double x = isect1[0];
			isect1[0] = isect1[1];
			isect1[1] = x;
		}
		if (isect2[0] > isect2[1]) {
			double x = isect2[0];
			isect2[0] = isect2[1];
			isect2[1] = x;
		}
		
		if(isect1[1] < isect2[0] || isect2[1] < isect1[0]) return false;
		return true;
	}
}