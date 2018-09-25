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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Composite class can hold more like itself or Leaf classes.
 * @author Tom McCallum
 */
public class Composite implements Node {
    ArrayList<Node> children;
    
    public Composite() {
        children = new ArrayList<>();
    }
    
    @Override
    public String getName() {
        return "Node";
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public void print() {
        System.out.println(getName());
        for( Node child : children ) {
            child.print();
        }
    }

    @Override
    public void add(Node item) {
        children.add( item );
    }

    @Override
    public Iterator iterator() {
        return children.iterator();
    }
    
}
