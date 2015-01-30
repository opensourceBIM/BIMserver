package org.bimserver.charting.Algorithms;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import prefuse.action.layout.graph.TreeLayout;
import prefuse.data.Graph;
import prefuse.data.Schema;
import prefuse.data.tuple.TupleSet;
import prefuse.data.util.TreeNodeIterator;
import prefuse.visual.NodeItem;
import prefuse.visual.VisualItem;

/**
 * <p>
 * TreeLayout instance computing a TreeMap layout that optimizes for low aspect ratios of visualized tree nodes. TreeMaps are a form of space-filling layout that represents nodes as boxes on the display, with children nodes represented as boxes placed within their parent's box.
 * </p>
 * <p>
 * This particular algorithm is taken from Bruls, D.M., C. Huizing, and J.J. van Wijk, "Squarified Treemaps" In <i>Data Visualization 2000, Proceedings of the Joint Eurographics and IEEE TCVG Sumposium on Visualization</i>, 2000, pp. 33-42. Available online at: <a href="http://www.win.tue.nl/~vanwijk/stm.pdf"> http://www.win.tue.nl/~vanwijk/stm.pdf</a>.
 * </p>
 * <p>
 * For more information on TreeMaps in general, see <a href="http://www.cs.umd.edu/hcil/treemap-history/"> http://www.cs.umd.edu/hcil/treemap-history/</a>.
 * </p>
 *
 * @version 1.0
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class SizeBasedSquarifiedTreeMapLayout extends TreeLayout {

	// column value in which layout stores area information
	public static final String AREA = "_area";
	public static final Schema AREA_SCHEMA = new Schema();
	static {
		AREA_SCHEMA.addColumn(AREA, double.class);
	}

	private static Comparator s_cmp = new Comparator() {
		public int compare(Object o1, Object o2) {
			double s1 = ((VisualItem) o1).getDouble(AREA);
			double s2 = ((VisualItem) o2).getDouble(AREA);
			return (s1 > s2 ? 1 : (s1 < s2 ? -1 : 0));
		}
	};
	private ArrayList m_kids = new ArrayList();
	private ArrayList m_row = new ArrayList();
	private Rectangle2D m_r = new Rectangle2D.Double();

	private double m_frame; // space between parents border and children

	/**
	 * Creates a new SquarifiedTreeMapLayout with no spacing between
	 * parent areas and their enclosed children.
	 * 
	 * @param group
	 *            the data group to layout. Must resolve to a Graph instance.
	 */
	public SizeBasedSquarifiedTreeMapLayout(String group) {
		this(group, 0);
	}

	/**
	 * Creates a new SquarifiedTreeMapLayout with the specified spacing between
	 * parent areas and their enclosed children.
	 * 
	 * @param frame
	 *            the amount of desired framing space between
	 *            parent areas and their enclosed children.
	 * @param group
	 *            the data group to layout. Must resolve to a Graph instance.
	 */
	public SizeBasedSquarifiedTreeMapLayout(String group, double frame) {
		super(group);
		setFrameWidth(frame);
	}

	/**
	 * Sets the amount of desired framing space between parent rectangles and
	 * their enclosed children. Use a value of 0 to remove frames altogether.
	 * If you adjust the frame value, you must re-run the layout to see the
	 * change reflected. Negative frame values are not allowed and will result
	 * in an IllegalArgumentException.
	 * 
	 * @param frame
	 *            the frame width, 0 for no frames
	 */
	public void setFrameWidth(double frame) {
		if (frame < 0)
			throw new IllegalArgumentException("Frame value must be greater than or equal to 0.");
		m_frame = frame;
	}

	/**
	 * Gets the amount of desired framing space, in pixels, between
	 * parent rectangles and their enclosed children.
	 * 
	 * @return the frame width
	 */
	public double getFrameWidth() {
		return m_frame;
	}

	/**
	 * @see prefuse.action.Action#run(double)
	 */
	public void run(double frac) {
		// setup
		NodeItem root = getLayoutRoot();
		Rectangle2D b = getLayoutBounds();
		m_r.setRect(b.getX(), b.getY(), b.getWidth() - 1, b.getHeight() - 1);

		// process size values
		computeAreas(root);

		// layout root node
		setX(root, null, 0);
		setY(root, null, 0);
		root.setBounds(0, 0, m_r.getWidth(), m_r.getHeight());

		// layout the tree
		updateArea(root, m_r);
		layout(root, m_r);
	}

	/**
	 * Compute the pixel areas of nodes based on their size values.
	 */
	private void computeAreas(NodeItem root) {
		int leafCount = 0;

		// ensure area data column exists
		Graph g = (Graph) m_vis.getGroup(m_group);
		TupleSet nodes = g.getNodes();
		nodes.addColumns(AREA_SCHEMA);

		// reset all sizes to zero
		Iterator iter = new TreeNodeIterator(root);
		while (iter.hasNext()) {
			NodeItem n = (NodeItem) iter.next();
			n.setDouble(AREA, 0);
		}

		// set raw sizes, compute leaf count
		iter = new TreeNodeIterator(root, false);
		while (iter.hasNext()) {
			NodeItem n = (NodeItem) iter.next();
			double area = 0;
			if (n.getChildCount() == 0) {
				area = n.getSize();
				++leafCount;
			} else if (n.isExpanded()) {
				NodeItem c = (NodeItem) n.getFirstChild();
				for (; c != null; c = (NodeItem) c.getNextSibling()) {
					area += c.getDouble(AREA);
					++leafCount;
				}
			}
			n.setDouble(AREA, area);
		}

		// scale sizes by display area factor
		Rectangle2D b = getLayoutBounds();
		double area = (b.getWidth() - 1) * (b.getHeight() - 1);
		double scale = area / root.getDouble(AREA);
		iter = new TreeNodeIterator(root);
		while (iter.hasNext()) {
			NodeItem n = (NodeItem) iter.next();
			n.setDouble(AREA, n.getDouble(AREA) * scale);
		}
	}

	/**
	 * Compute the tree map layout.
	 */
	private void layout(NodeItem p, Rectangle2D r) {
		// create sorted list of children
		Iterator childIter = p.children();
		while (childIter.hasNext())
			m_kids.add(childIter.next());
		Collections.sort(m_kids, s_cmp);

		// do squarified layout of siblings
		double w = Math.min(r.getWidth(), r.getHeight());
		squarify(m_kids, m_row, w, r);
		m_kids.clear(); // clear m_kids

		// recurse
		childIter = p.children();
		while (childIter.hasNext()) {
			NodeItem c = (NodeItem) childIter.next();
			if (c.getChildCount() > 0 && c.getDouble(AREA) > 0) {
				updateArea(c, r);
				layout(c, r);
			}
		}
	}

	private void updateArea(NodeItem n, Rectangle2D r) {
		Rectangle2D b = n.getBounds();
		if (m_frame == 0.0) {
			// if no framing, simply update bounding rectangle
			r.setRect(b);
			return;
		}

		// compute area loss due to frame
		double dA = 2 * m_frame * (b.getWidth() + b.getHeight() - 2 * m_frame);
		double A = n.getDouble(AREA) - dA;

		// compute renormalization factor
		double s = 0;
		Iterator childIter = n.children();
		while (childIter.hasNext())
			s += ((NodeItem) childIter.next()).getDouble(AREA);
		double t = A / s;

		// re-normalize children areas
		childIter = n.children();
		while (childIter.hasNext()) {
			NodeItem c = (NodeItem) childIter.next();
			c.setDouble(AREA, c.getDouble(AREA) * t);
		}

		// set bounding rectangle and return
		r.setRect(b.getX() + m_frame, b.getY() + m_frame, b.getWidth() - 2 * m_frame, b.getHeight() - 2 * m_frame);
		return;
	}

	private void squarify(List c, List row, double w, Rectangle2D r) {
		double worst = Double.MAX_VALUE, nworst;
		int len;

		while ((len = c.size()) > 0) {
			// add item to the row list, ignore if negative area
			VisualItem item = (VisualItem) c.get(len - 1);
			double a = item.getDouble(AREA);
			if (a <= 0.0) {
				c.remove(len - 1);
				continue;
			}
			row.add(item);

			nworst = worst(row, w);
			if (nworst <= worst) {
				c.remove(len - 1);
				worst = nworst;
			} else {
				row.remove(row.size() - 1); // remove the latest addition
				r = layoutRow(row, w, r); // layout the current row
				w = Math.min(r.getWidth(), r.getHeight()); // recompute w
				row.clear(); // clear the row
				worst = Double.MAX_VALUE;
			}
		}
		if (row.size() > 0) {
			r = layoutRow(row, w, r); // layout the current row
			row.clear(); // clear the row
		}
	}

	private double worst(List rlist, double w) {
		double rmax = Double.MIN_VALUE, rmin = Double.MAX_VALUE, s = 0.0;
		Iterator iter = rlist.iterator();
		while (iter.hasNext()) {
			double r = ((VisualItem) iter.next()).getDouble(AREA);
			rmin = Math.min(rmin, r);
			rmax = Math.max(rmax, r);
			s += r;
		}
		s = s * s;
		w = w * w;
		return Math.max(w * rmax / s, s / (w * rmin));
	}

	private Rectangle2D layoutRow(List row, double w, Rectangle2D r) {
		double s = 0; // sum of row areas
		Iterator rowIter = row.iterator();
		while (rowIter.hasNext())
			s += ((VisualItem) rowIter.next()).getDouble(AREA);
		double x = r.getX(), y = r.getY(), d = 0;
		double h = w == 0 ? 0 : s / w;
		boolean horiz = (w == r.getWidth());

		// set node positions and dimensions
		rowIter = row.iterator();
		while (rowIter.hasNext()) {
			NodeItem n = (NodeItem) rowIter.next();
			NodeItem p = (NodeItem) n.getParent();
			if (horiz) {
				setX(n, p, x + d);
				setY(n, p, y);
			} else {
				setX(n, p, x);
				setY(n, p, y + d);
			}
			double nw = n.getDouble(AREA) / h;
			if (horiz) {
				setNodeDimensions(n, nw, h);
				d += nw;
			} else {
				setNodeDimensions(n, h, nw);
				d += nw;
			}
		}
		// update space available in rectangle r
		if (horiz)
			r.setRect(x, y + h, r.getWidth(), r.getHeight() - h);
		else
			r.setRect(x + h, y, r.getWidth() - h, r.getHeight());
		return r;
	}

	private void setNodeDimensions(NodeItem n, double w, double h) {
		n.setBounds(n.getX(), n.getY(), w, h);
	}

} // end of class SquarifiedTreeMapLayout