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
 *
 * @author Tom McCallum
 */
public class Leaf implements Node {

    @Override
    public String getName() {
        return "Leaf";
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public void print() {
        System.out.println(getName());
    }

    // the additional functions which are not meant for all types is an 
    // overhead that we accept for the sake of simplifying access
    @Override
    public void add(Node item) {
        // do nothing or we could throw an UnsupportedOperationException
        // depending on whether we want the programmer to specifically handle
        // when an illegal call occurs
    }

    @Override
    public Iterator iterator() {
        // this saves us having to have a == null test after each call
        return new NullIterator();
    }
    
}
