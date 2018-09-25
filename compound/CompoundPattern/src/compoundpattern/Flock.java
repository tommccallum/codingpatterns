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
package compoundpattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This composite pattern will allow us to treat a group of ducks the same as 
 * a single duck.
 * We also use the iterator pattern to loop through all the quackable objects.
 * @author Tom McCallum
 */
public class Flock implements Quackable {
    // using composition to add observer behaviour
    private ArrayList<Quackable> quackers = new ArrayList<>();
    
    public Flock() {
    }
    
    public void add( Quackable quacker ) {
        quackers.add( quacker );
    }
    
    @Override
    public void quack() {
        Iterator<Quackable> it = quackers.iterator();
        while ( it.hasNext() ) {
            Quackable quacker = it.next();
            quacker.quack();
        }
    }

    @Override
    public void register(Observer observer) {
        Iterator<Quackable> it = quackers.iterator();
        while ( it.hasNext() ) {
            Quackable q = it.next();
            q.register(observer);
        }
    }

    @Override
    public void notifyObservers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
