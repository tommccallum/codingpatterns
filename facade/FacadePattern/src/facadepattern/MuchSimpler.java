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
 * Facades provide a unified interface to a set of interfaces of a subsystem.
 * It makes the subsystems much easier to use and change in the long term.
 * @author Tom McCallum
 */
public class MuchSimpler {
    ComponentA a;
    ComponentB b;
    ComponentC c;
    
    public MuchSimpler(ComponentA a, ComponentB b, ComponentC c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void on() {
        a.on();
        b.on();
        c.on();
    }
}
