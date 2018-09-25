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
 *
 * @author Tom McCallum
 */
public class StateC implements State {
    private StateDiagram diagram;
    private boolean once = false;
    
    public StateC(StateDiagram diagram) {
        this.diagram = diagram;
    }
    
    @Override
    public void print() {
        if ( !once ) {
            System.out.println("State C");
            once = true;
        }
    }

    @Override
    public boolean isFinal() {
        return true;
    }
    
    @Override
    public void next(double pr) {
        System.out.println("We are in a final state");
    }
}
