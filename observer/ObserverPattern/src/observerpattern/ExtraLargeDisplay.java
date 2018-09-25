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
package observerpattern;

/**
 *
 * @author Tom McCallum
 */
public class ExtraLargeDisplay implements Observer, DisplayElement {
    private int timestamp;
    private Sensor sensor;
    
    public ExtraLargeDisplay(Sensor sensor) {
        timestamp = 1;
        this.sensor = sensor;
        this.sensor.registerObserver(this);
    }
    
    // in this case we don't actually use the argument being passed to us
    @Override
    public void update(Sensor s) {
        display();
        timestamp++;
    }

    @Override
    public void display() {
        System.out.println("["+timestamp+"] "+ sensor.getValue());
    }
    
}
