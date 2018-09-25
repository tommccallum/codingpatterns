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

/**
 *
 * @author Tom McCallum
 */
public class DuckCall implements Quackable {
    // using composition to add observer behaviour
    Observable observable; 
    
    public DuckCall() {
        observable = new Observable(this);
    }
    
    @Override
    public void quack() {
        System.out.println("Kwak!");
        notifyObservers();
    }
    
    
    public void register(Observer observer) {
        observable.register(observer);
    }
    
    public void notifyObservers() {
        observable.notifyObservers();
    }
    
    public String toString() {
        return "Duck Call";
    }
}
