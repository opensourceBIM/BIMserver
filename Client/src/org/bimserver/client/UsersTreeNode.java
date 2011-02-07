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
import java.util.List;

import javax.swing.tree.TreeNode;

import org.bimserver.utils.ListEnumeration;

public class UsersTreeNode implements TreeNode {

	private final ServerTreeNode serverTreeNode;
	private final List<UserTreeNode> users = new ArrayList<UserTreeNode>();
	
	public UsersTreeNode(ServerTreeNode serverTreeNode) {
		this.serverTreeNode = serverTreeNode;
	}

	@Override
	public Enumeration<UserTreeNode> children() {
		return new ListEnumeration<UserTreeNode>(users);
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode)users.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return users.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return users.indexOf(node);
	}

	@Override
	public TreeNode getParent() {
		return serverTreeNode;
	}

	@Override
	public boolean isLeaf() {
		return getChildCount() == 0;
	}

	public void clear() {
		users.clear();
	}
	
	@Override
	public String toString() {
		return "Users";
	}

	public void add(UserTreeNode userTreeNode) {
		users.add(userTreeNode);
	}
}
