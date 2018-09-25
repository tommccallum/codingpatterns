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
import java.util.Stack;

/**
 *
 * @author Tom McCallum
 */
public class CompositeIterator implements Iterator {
    Stack<Iterator<Node>> stack = new Stack<Iterator<Node>>();
    
    CompositeIterator( Iterator it ) {
        stack.push(it);
    }
    
    @Override
    public boolean hasNext() {
        if ( stack.empty() ) {
            return false;
        } else {
            Iterator<Node> iterator = stack.peek();
            if ( iterator.hasNext() == false ) {
                stack.pop();
                return hasNext(); // recurse down the stack
            } else {
                return true;
            }
        }
    }

    @Override
    public Object next() {
        if ( hasNext() ) {
            Iterator<Node> iterator = stack.peek();
            Node node = (Node) iterator.next();
            stack.push( node.iterator() );
            return node;
        } else {
            return null;
        }
    }
    
}
