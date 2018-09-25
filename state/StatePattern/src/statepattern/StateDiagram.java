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
package statepattern;

/**
 * This is the state container, either the states can decide which is the next
 * state to go to, or the logic could be in this diagram, or you could use the
 * strategy method to assign a new transition method.
 * 
 * @author Tom McCallum
 */
public class StateDiagram {
    private State current;
    
    public StateDiagram() {
        current = new StateA(this);
        current.print();
    }
    
    public void run() {
        while ( current.isFinal() == false ) {
            double dice = Math.random();
            current.next(dice);
            current.print();
        }
    }
    
    public void step() {
        double dice = Math.random();
        current.next(dice);
        current.print();
    }
    
    public void setState( State state ) {
        this.current = state;
    }
}
