/*
 * Copyright (C) 2018 Tom McCallum
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
 */
package compositepattern;

import java.util.Iterator;

/**
 * Our composite pattern effectively creates a TREE structure that we can
 * use for hierarchical structures.
 * @author Tom McCallum
 */
public class CompositePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node a = new Composite();
        a.add( new Leaf() );
        Node b = new Composite();
        a.add( b );
        b.add( new Leaf() );
        
        a.print();
        
        System.out.println("Iterator over each print method");
        Iterator it = a.iterator();
        while ( it.hasNext() ) {
            ((Node) it.next()).print();
        }
        // note that this misses the printing the first node hence
        // not identical
    }
    
}
