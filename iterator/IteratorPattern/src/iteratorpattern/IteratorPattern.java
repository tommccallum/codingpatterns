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
package iteratorpattern;

import java.util.Iterator;

/**
 *
 * @author Tom McCallum
 */
public class IteratorPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add( new Jelly() );
        
        // here we have to manually setup the iterator which means
        // that we are now tied to the iterator implementation
        MenuIterator it = new MenuIterator(menu);
        while ( it.hasNext() ) {
            System.out.println(it.next());
        }
        
        // this way we don't care what the iterator is and leave
        // that to be controlled by the collection
        // this decouples us from the iterator
        Iterator it2 =  menu.iterator();
        while ( it2.hasNext() ) {
            System.out.println(it.next());
        }
    }
    
}
