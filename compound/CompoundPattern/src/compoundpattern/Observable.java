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
 *
 * @author Tom McCallum
 */
public class Observable implements QuackObservable {
    ArrayList<Observer> observers = new ArrayList<Observer>();
    QuackObservable duck;
    
    public Observable(QuackObservable duck) {
        this.duck = duck;
    }
    
    @Override
    public void register(Observer observer) {
        observers.add( observer );
    }

    @Override
    public void notifyObservers() {
        Iterator it = observers.iterator();
        while ( it.hasNext() ) {
            Observer observer = (Observer) it.next();
            observer.update(duck);
        }
    }
    
}
