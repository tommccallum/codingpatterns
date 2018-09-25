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
package facadepattern;

/**
 *
 * @author Tom McCallum
 */
public class FacadePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // we could do this everywhere
        ComponentA a = new ComponentA();
        ComponentB b = new ComponentB();
        ComponentC c = new ComponentC();
        
        a.on();
        b.on();
        c.on();
        
        // or we could just use a Facade and hide
        // the creation of this object could also be done
        // via Factory Method decoupling the object creation from
        // the caller
        MuchSimpler d = new MuchSimpler(a,b,c);
        d.on();
    }
    
}
