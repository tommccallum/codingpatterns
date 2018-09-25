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
package decoratorpattern;

/**
 *
 * @author Tom McCallum
 */
public class DecoratorPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Drink juice = new Juice();
        
        System.out.println("Juice cost: "+juice.cost());
        
        // The class Blackcurrent is decorating the class Juice
        // when using decorators you should always use the interface
        // not the underlying implementation classes.
        // You should also make sure that there are no ordering dependencies
        // between your decorators.
        Drink blackcurrant = new Blackcurrant(juice);
        System.out.println("Blackcurrent cost: "+blackcurrant.cost());
        
        Drink extrablackcurrant = new Blackcurrant(blackcurrant);
        System.out.println("Extra Blackcurrent cost: "+extrablackcurrant.cost());
    }
    
}
