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

import java.util.ArrayList;

/**
 *
 * @author Tom McCallum
 */
public class TemperatureSensor implements Sensor {
    private float value;
    private ArrayList<Observer> observers;
    private boolean changed;
    
    public TemperatureSensor() {
        observers = new ArrayList<>();
        changed = false;
    }

    @Override
    public final void registerObserver(Observer o) {
        if ( observers.contains(o) == false ) { 
            observers.add( o );
        }
    }

    @Override
    public final void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public final void notifyObservers() {
        if ( changed ) {
            for( Observer o : observers ) {
                o.update(this);
            }
            this.reset();
        }
    }

    // we have a changed variable to uncouple the changing of the data 
    // from the notify.  This is useful when multiple updates are expected
    // before a notification.
    
    @Override
    public final boolean hasChanged() {
        return changed;
    }

    @Override
    public final void changed() {
        changed = true;
    }

    @Override
    public final void reset() {
        changed = false;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
        this.changed();
        notifyObservers();
    }
    
    
}
