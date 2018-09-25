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
 * We provide an iterator over our collection
 * @author Tom McCallum
 */
public class MenuIterator implements Iterator {
    private Menu menu;
    private int position = 0;
    
    MenuIterator( Menu menu ) {
        this.menu = menu;
    }
    
    @Override
    public boolean hasNext() {
        return ( position < menu.size() );
    }

    @Override
    public Object next() {
        FoodItem item = menu.getOption(position);
        position++;
        return item;
    }
    
}
