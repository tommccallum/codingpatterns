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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Tom McCallum
 */
public class IteratorPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<>();
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        
        days = dayNames.elements();
        while ( days.hasMoreElements() ) {
            System.out.println(days.nextElement());
        }
        
        // now we use our adapter
        days = dayNames.elements();
        EnumerationIterator it = new EnumerationIterator(days);
        while ( it.hasNext() ) {
            System.out.println((String) it.next());
        }
    }
    
}
