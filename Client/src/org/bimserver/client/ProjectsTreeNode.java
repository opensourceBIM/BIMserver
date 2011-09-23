package org.bimserver.client;

/******************************************************************************
 * Copyright (C) 2009-2011  BIMserver.org
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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

import org.bimserver.utils.ListEnumeration;

public class ProjectsTreeNode implements TreeNode{

	private List<ProjectTreeNode> projects = new ArrayList<ProjectTreeNode>();
	private final ServerTreeNode serverTreeNode;
	
	public ProjectsTreeNode(ServerTreeNode serverTreeNode) {
		this.serverTreeNode = serverTreeNode;
	}
	
	@Override
	public Enumeration<ProjectTreeNode> children() {
		return new ListEnumeration<ProjectTreeNode>(projects);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return projects.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return projects.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return projects.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return serverTreeNode;
	}

	@Override
	public boolean isLeaf() {
		return getChildCount() == 0;
	}

	public void add(ProjectTreeNode projectTreeNode) {
		projects.add(projectTreeNode);
	}

	public void clear() {
		projects.clear();
	}
	
	@Override
	public String toString() {
		return "Projects";
	}
}
