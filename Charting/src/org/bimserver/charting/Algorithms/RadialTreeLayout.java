package org.bimserver.charting.Algorithms;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import prefuse.action.layout.graph.TreeLayout;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.Schema;
import prefuse.data.tuple.TupleSet;
import prefuse.util.ArrayLib;
import prefuse.util.MathLib;
import prefuse.visual.NodeItem;

/**
 * <p>
 * TreeLayout instance that computes a radial layout, laying out subsequent depth levels of a tree on circles of progressively increasing radius.
 * </p>
 * 
 * <p>
 * The algorithm used is that of Ka-Ping Yee, Danyel Fisher, Rachna Dhamija, and Marti Hearst in their research paper <a href="http://citeseer.ist.psu.edu/448292.html">Animated Exploration of Dynamic Graphs with Radial Layout</a>, InfoVis 2001. This algorithm computes a radial layout which factors in possible variation in sizes, and maintains both orientation and ordering constraints to facilitate smooth and understandable transitions between layout configurations.
 * </p>
 * 
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class RadialTreeLayout extends TreeLayout {

	public static final int DEFAULT_RADIUS = 50;
	private static final int MARGIN = 30;

	protected int m_maxDepth = 0;
	protected double m_radiusInc;
	protected double m_theta1, m_theta2;
	protected boolean m_setTheta = false;
	protected boolean m_autoScale = true;

	protected Point2D m_origin;
	protected NodeItem m_prevRoot;

	protected double m_thetaOffset = -MathLib.TWO_PI / 4.0;

	/**
	 * Creates a new RadialTreeLayout. Automatic scaling of the radius
	 * values to fit the layout bounds is enabled by default.
	 * 
	 * @param group
	 *            the data group to process. This should resolve to
	 *            either a Graph or Tree instance.
	 */
	public RadialTreeLayout(String group) {
		super(group);
		m_radiusInc = DEFAULT_RADIUS;
		m_prevRoot = null;
		m_theta1 = m_thetaOffset;
		m_theta2 = m_theta1 + MathLib.TWO_PI;
	}

	/**
	 * Creates a new RadialTreeLayout using the specified radius increment
	 * between levels of the layout. Automatic scaling of the radius values
	 * is disabled by default.
	 * 
	 * @param group
	 *            the data group to process. This should resolve to
	 *            either a Graph or Tree instance.
	 * @param radius
	 *            the radius increment to use between subsequent rings
	 *            in the layout.
	 */
	public RadialTreeLayout(String group, int radius) {
		this(group);
		m_radiusInc = radius;
		m_autoScale = false;
	}

	/**
	 * Set the radius increment to use between concentric circles. Note
	 * that this value is used only if auto-scaling is disabled.
	 * 
	 * @return the radius increment between subsequent rings of the layout
	 *         when auto-scaling is disabled
	 */
	public double getRadiusIncrement() {
		return m_radiusInc;
	}

	/**
	 * Set the radius increment to use between concentric circles. Note
	 * that this value is used only if auto-scaling is disabled.
	 * 
	 * @param inc
	 *            the radius increment between subsequent rings of the layout
	 * @see #setAutoScale(boolean)
	 */
	public void setRadiusIncrement(double inc) {
		m_radiusInc = inc;
	}

	/**
	 * Indicates if the layout automatically scales to fit the layout bounds.
	 * 
	 * @return true if auto-scaling is enabled, false otherwise
	 */
	public boolean getAutoScale() {
		return m_autoScale;
	}

	/**
	 * Set whether or not the layout should automatically scale itself
	 * to fit the layout bounds.
	 * 
	 * @param s
	 *            true to automatically scale to fit display, false otherwise
	 */
	public void setAutoScale(boolean s) {
		m_autoScale = s;
	}

	/**
	 * Constrains this layout to the specified angular sector
	 * 
	 * @param theta
	 *            the starting angle, in radians
	 * @param width
	 *            the angular width, in radians
	 */
	public void setAngularBounds(double theta, double width) {
		m_theta1 = theta;
		m_theta2 = theta + width;
		m_setTheta = true;
	}

	/**
	 * @see prefuse.action.Action#run(double)
	 */
	public void run(double frac) {
		Graph g = (Graph) m_vis.getGroup(m_group);
		initSchema(g.getNodes());

		m_origin = getLayoutAnchor();
		NodeItem n = getLayoutRoot();
		Params np = (Params) n.get(PARAMS);

		g.getSpanningTree(n);

		// calc relative widths and maximum tree depth
		// performs one pass over the tree
		m_maxDepth = 0;
		calcAngularWidth(n, 0);

		if (m_autoScale)
			setScale(getLayoutBounds());
		if (!m_setTheta)
			calcAngularBounds(n);

		// perform the layout
		if (m_maxDepth > 0)
			layout(n, m_radiusInc, m_theta1, m_theta2);

		// update properties of the root node
		setX(n, null, m_origin.getX());
		setY(n, null, m_origin.getY());
		np.angle = m_theta2 - m_theta1;
	}

	/**
	 * Clears references to graph tuples. The group and visualization are
	 * retained.
	 */
	public void reset() {
		super.reset();
		m_prevRoot = null;
	}

	protected void setScale(Rectangle2D bounds) {
		double r = Math.min(bounds.getWidth(), bounds.getHeight()) / 2.0;
		if (m_maxDepth > 0)
			m_radiusInc = (r - MARGIN) / m_maxDepth;
	}

	/**
	 * Calculates the angular bounds of the layout, attempting to
	 * preserve the angular orientation of the display across transitions.
	 */
	private void calcAngularBounds(NodeItem r) {
		if (m_prevRoot == null || !m_prevRoot.isValid() || r == m_prevRoot) {
			m_prevRoot = r;
			return;
		}

		// try to find previous parent of root
		NodeItem p = m_prevRoot;
		while (true) {
			NodeItem pp = (NodeItem) p.getParent();
			if (pp == r) {
				break;
			} else if (pp == null) {
				m_prevRoot = r;
				return;
			}
			p = pp;
		}

		// compute offset due to children's angular width
		double dt = 0;
		Iterator iter = sortedChildren(r);
		while (iter.hasNext()) {
			Node n = (Node) iter.next();
			if (n == p)
				break;
			dt += ((Params) n.get(PARAMS)).width;
		}
		double rw = ((Params) r.get(PARAMS)).width;
		double pw = ((Params) p.get(PARAMS)).width;
		dt = -MathLib.TWO_PI * (dt + pw / 2) / rw;

		// set angular bounds
		m_theta1 = m_thetaOffset + dt + Math.atan2(p.getY() - r.getY(), p.getX() - r.getX());
		m_theta2 = m_theta1 + MathLib.TWO_PI;
		m_prevRoot = r;
	}

	/**
	 * Computes relative measures of the angular widths of each
	 * expanded subtree. Node diameters are taken into account
	 * to improve space allocation for variable-sized nodes.
	 * 
	 * This method also updates the base angle value for nodes
	 * to ensure proper ordering of nodes.
	 */
	private double calcAngularWidth(NodeItem n, int d) {
		if (d > m_maxDepth)
			m_maxDepth = d;
		double aw = 0;

		Rectangle2D bounds = n.getBounds();
		double w = bounds.getWidth(), h = bounds.getHeight();
		double diameter = d == 0 ? 0 : Math.sqrt(w * w + h * h) / d;

		if (n.isExpanded() && n.getChildCount() > 0) {
			Iterator childIter = n.children();
			while (childIter.hasNext()) {
				NodeItem c = (NodeItem) childIter.next();
				aw += calcAngularWidth(c, d + 1);
			}
			aw = Math.max(diameter, aw);
		} else {
			aw = diameter;
		}
		((Params) n.get(PARAMS)).width = aw;
		return aw;
	}

	private static final double normalize(double angle) {
		while (angle > MathLib.TWO_PI) {
			angle -= MathLib.TWO_PI;
		}
		while (angle < 0) {
			angle += MathLib.TWO_PI;
		}
		return angle;
	}

	private Iterator sortedChildren(final NodeItem n) {
		double base = 0;
		// update base angle for node ordering
		NodeItem p = (NodeItem) n.getParent();
		if (p != null) {
			base = normalize(Math.atan2(p.getY() - n.getY(), p.getX() - n.getX()));
		}
		int cc = n.getChildCount();
		if (cc == 0)
			return null;

		NodeItem c = (NodeItem) n.getFirstChild();

		// TODO: this is hacky and will break when filtering
		// how to know that a branch is newly expanded?
		// is there an alternative property we should check?
		if (!c.isStartVisible()) {
			// use natural ordering for previously invisible nodes
			return n.children();
		}

		double angle[] = new double[cc];
		final int idx[] = new int[cc];
		for (int i = 0; i < cc; ++i, c = (NodeItem) c.getNextSibling()) {
			idx[i] = i;
			angle[i] = normalize(-base + Math.atan2(c.getY() - n.getY(), c.getX() - n.getX()));
		}
		ArrayLib.sort(angle, idx);

		// return iterator over sorted children
		return new Iterator() {
			int cur = 0;

			public Object next() {
				return n.getChild(idx[cur++]);
			}

			public boolean hasNext() {
				return cur < idx.length;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	/**
	 * Compute the layout.
	 * 
	 * @param n
	 *            the root of the current subtree under consideration
	 * @param r
	 *            the radius, current distance from the center
	 * @param theta1
	 *            the start (in radians) of this subtree's angular region
	 * @param theta2
	 *            the end (in radians) of this subtree's angular region
	 */
	protected void layout(NodeItem n, double r, double theta1, double theta2) {
		double dtheta = (theta2 - theta1);
		double dtheta2 = dtheta / 2.0;
		double width = ((Params) n.get(PARAMS)).width;
		double cfrac, nfrac = 0.0;

		Iterator childIter = sortedChildren(n);
		while (childIter != null && childIter.hasNext()) {
			NodeItem c = (NodeItem) childIter.next();
			Params cp = (Params) c.get(PARAMS);
			cfrac = cp.width / width;
			if (c.isExpanded() && c.getChildCount() > 0) {
				if (c.getDepth() < 2)
					layout(c, r + m_radiusInc, theta1 + nfrac * dtheta, theta1 + (nfrac + cfrac) * dtheta);
				// Realign children of depth 2 item (3rd nodes) so that they arc outward.
				else
					layout(c, r + m_radiusInc, theta1 + nfrac * dtheta - m_thetaOffset / 3.0, theta1 + (nfrac + cfrac) * dtheta);
			}
			setPolarLocation(c, n, r, theta1 + nfrac * dtheta + cfrac * dtheta2);
			cp.angle = cfrac * dtheta;
			nfrac += cfrac;
		}

	}

	/**
	 * Set the position of the given node, given in polar co-ordinates.
	 * 
	 * @param n
	 *            the NodeItem to set the position
	 * @param p
	 *            the referrer parent NodeItem
	 * @param r
	 *            the radius
	 * @param t
	 *            the angle theta
	 */
	protected void setPolarLocation(NodeItem n, NodeItem p, double r, double t) {
		setX(n, p, m_origin.getX() + r * Math.cos(t));
		setY(n, p, m_origin.getY() + r * Math.sin(t));
	}

	// ------------------------------------------------------------------------
	// Params

	/**
	 * The data field in which the parameters used by this layout are stored.
	 */
	public static final String PARAMS = "_radialTreeLayoutParams";
	/**
	 * The schema for the parameters used by this layout.
	 */
	public static final Schema PARAMS_SCHEMA = new Schema();
	static {
		PARAMS_SCHEMA.addColumn(PARAMS, Params.class, new Params());
	}

	protected void initSchema(TupleSet ts) {
		ts.addColumns(PARAMS_SCHEMA);
	}

	/**
	 * Wrapper class holding parameters used for each node in this layout.
	 */
	public static class Params implements Cloneable {
		public double width;
		public double angle;

		public Object clone() {
			Params p = new Params();
			p.width = this.width;
			p.angle = this.angle;
			return p;
		}

		public double getCosineOfAngle() {
			return Math.cos(angle);
		}

		public double getSineOfAngle() {
			return Math.sin(angle);
		}

		public Point2D.Double rotatePoint(double p1X, double p1Y, double aroundX, double aroundY) {
			return rotatePoint(new Point2D.Double(p1X, p1Y), new Point2D.Double(aroundX, aroundY));
		}

		public Point2D.Double rotatePoint(Point2D.Double p1, Point2D.Double around) {
			double cosTheta = getCosineOfAngle();
			double sinTheta = getSineOfAngle();
			return new Point2D.Double(
				cosTheta * (p1.x - around.x) - sinTheta * (p1.y - around.y) + around.x,
				sinTheta * (p1.x - around.x) + cosTheta * (p1.y - around.y) + around.y
			);
		}

		public static Point2D.Double rotatePoint(double angle, Point2D.Double p1, Point2D.Double around) {
			double cosTheta = Math.cos(angle);
			double sinTheta = Math.sin(angle);
			return new Point2D.Double(
				cosTheta * (p1.x - around.x) - sinTheta * (p1.y - around.y) + around.x,
				sinTheta * (p1.x - around.x) + cosTheta * (p1.y - around.y) + around.y
			);
		}

		public static double angle(double p1X, double p1Y, double aroundX, double aroundY) {
			return angle(new Point2D.Double(p1X, p1Y), new Point2D.Double(aroundX, aroundY));
		}

		public static double angle(Point2D.Double p1, Point2D.Double p2) {
			Point2D.Double delta = new Point2D.Double(p2.x - p1.x, p2.y - p1.y);
			return Math.atan2(delta.y, delta.x);
		}
	}

} // end of class RadialTreeLayout