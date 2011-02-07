package org.bimserver.client;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import org.bimserver.utils.ListEnumeration;

public class ServerTreeNode implements TreeNode {

	private final String server;
	private final ProjectsTreeNode projectsTreeNode = new ProjectsTreeNode(this);
	private final UsersTreeNode usersTreeNode = new UsersTreeNode(this);
	private final ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	private final RootTreeNode parent;

	public ServerTreeNode(RootTreeNode parent, String server) {
		this.parent = parent;
		this.server = server;
		list.add(projectsTreeNode);
		list.add(usersTreeNode);
	}

	@Override
	public Enumeration<TreeNode> children() {
		return new ListEnumeration<TreeNode>(list);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode)list.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return list.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return list.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return list.size() == 0;
	}
	
	@Override
	public String toString() {
		return server;
	}

	public void add(ProjectTreeNode projectTreeNode) {
		projectsTreeNode.add(projectTreeNode);
	}

	public void clearUsers() {
		usersTreeNode.clear();
	}

	public void clearProjects() {
		projectsTreeNode.clear();
	}

	public void add(UserTreeNode userTreeNode) {
		usersTreeNode.add(userTreeNode);
	}
}