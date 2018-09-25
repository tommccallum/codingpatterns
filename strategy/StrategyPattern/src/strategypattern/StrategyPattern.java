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
package strategypattern;

/**
 *
 * @author Tom McCallum
 */
public class StrategyPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Duck duck = new Duck();
        Swan swan = new Swan();
        Chicken chicken = new Chicken();
        
        duck.fly();
        duck.speak();
        swan.fly();
        swan.speak();
        chicken.fly();
        chicken.speak();
        
        // now we can easily make a no-fly duck
        duck.setFlyBehaviour(new NoFly());
        duck.fly();
        
        VoiceBehaviour f = new Hiss();
        f.speak(); // has no anExtraFunction to call
        Hiss h = (Hiss) f;
        h.anExtraFunction(); // now we can see the additional function
        
    }
    
}
