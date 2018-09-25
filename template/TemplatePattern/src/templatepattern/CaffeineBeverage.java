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
package templatepattern;

/**
 *
 * @author Tom McCallum
 */
public abstract class CaffeineBeverage {
    
    // this is our template for the algorithm
    public void prepare() {
        boil();
        brew();
        pour();
        addCondiments();
    }
    
    // here we allow the parts of the template to change
    // by subclasses this abstract class
    // some default actions can be handled in this class
    // others are fully delegated to subclass
    protected abstract void brew();
    
    protected abstract void addCondiments();
    
    // these default functions are called hooks
    // hooks can be empty but allow subclasses to override
    // and add actions ONLY IF actions are necessary
    protected void boil() {
        System.out.println("boil");
    }
    
    protected void pour() {
        System.out.println("pour");
    }
}
