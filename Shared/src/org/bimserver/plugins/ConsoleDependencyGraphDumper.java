/*******************************************************************************
 * Copyright (c) 2010, 2013 Sonatype, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sonatype, Inc. - initial API and implementation
 *******************************************************************************/
package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyNode;
import org.eclipse.aether.graph.DependencyVisitor;
import org.eclipse.aether.util.artifact.ArtifactIdUtils;
import org.eclipse.aether.util.graph.manager.DependencyManagerUtils;
import org.eclipse.aether.util.graph.transformer.ConflictResolver;

/**
 * A dependency visitor that dumps the graph to the console.
 */
public class ConsoleDependencyGraphDumper
    implements DependencyVisitor
{

    private PrintStream out;

    private List<ChildInfo> childInfos = new ArrayList<ChildInfo>();

    public ConsoleDependencyGraphDumper()
    {
        this( null );
    }

    public ConsoleDependencyGraphDumper( PrintStream out )
    {
        this.out = ( out != null ) ? out : System.out;
    }

    public boolean visitEnter( DependencyNode node )
    {
        out.println( formatIndentation() + formatNode( node ) );
        childInfos.add( new ChildInfo( node.getChildren().size() ) );
        return true;
    }

    private String formatIndentation()
    {
        StringBuilder buffer = new StringBuilder( 128 );
        for ( Iterator<ChildInfo> it = childInfos.iterator(); it.hasNext(); )
        {
            buffer.append( it.next().formatIndentation( !it.hasNext() ) );
        }
        return buffer.toString();
    }

    private String formatNode( DependencyNode node )
    {
        StringBuilder buffer = new StringBuilder( 128 );
        Artifact a = node.getArtifact();
        Dependency d = node.getDependency();
        buffer.append( a );
        if ( d != null && d.getScope().length() > 0 )
        {
            buffer.append( " [" ).append( d.getScope() );
            if ( d.isOptional() )
            {
                buffer.append( ", optional" );
            }
            buffer.append( "]" );
        }
        {
            String premanaged = DependencyManagerUtils.getPremanagedVersion( node );
            if ( premanaged != null && !premanaged.equals( a.getBaseVersion() ) )
            {
                buffer.append( " (version managed from " ).append( premanaged ).append( ")" );
            }
        }
        {
            String premanaged = DependencyManagerUtils.getPremanagedScope( node );
            if ( premanaged != null && !premanaged.equals( d.getScope() ) )
            {
                buffer.append( " (scope managed from " ).append( premanaged ).append( ")" );
            }
        }
        DependencyNode winner = (DependencyNode) node.getData().get( ConflictResolver.NODE_DATA_WINNER );
        if ( winner != null && !ArtifactIdUtils.equalsId( a, winner.getArtifact() ) )
        {
            Artifact w = winner.getArtifact();
            buffer.append( " (conflicts with " );
            if ( ArtifactIdUtils.toVersionlessId( a ).equals( ArtifactIdUtils.toVersionlessId( w ) ) )
            {
                buffer.append( w.getVersion() );
            }
            else
            {
                buffer.append( w );
            }
            buffer.append( ")" );
        }
        return buffer.toString();
    }

    public boolean visitLeave( DependencyNode node )
    {
        if ( !childInfos.isEmpty() )
        {
            childInfos.remove( childInfos.size() - 1 );
        }
        if ( !childInfos.isEmpty() )
        {
            childInfos.get( childInfos.size() - 1 ).index++;
        }
        return true;
    }

    private static class ChildInfo
    {

        final int count;

        int index;

        public ChildInfo( int count )
        {
            this.count = count;
        }

        public String formatIndentation( boolean end )
        {
            boolean last = index + 1 >= count;
            if ( end )
            {
                return last ? "\\- " : "+- ";
            }
            return last ? "   " : "|  ";
        }

    }

}