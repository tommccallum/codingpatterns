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
 * Using the Decorator pattern to add more functionality to Quackable objects
 * @author Tom McCallum
 */
public class QuackCounter implements Quackable {
    // using composition to add observer behaviour
    private Quackable duck;
    private static int quackCounter = 0;
    
    public QuackCounter(Quackable q) {
        this.duck = q;
    }
    
    @Override
    public void quack() {
        duck.quack();
        quackCounter++;
    }
    
    public static int getQuackCount() {
        return quackCounter;
    }
    
    
    public void register(Observer observer) {
        duck.register(observer);
    }
    
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
