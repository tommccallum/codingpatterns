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
package basicmvc;

/**
 *
 * @author Tom McCallum
 */
public class BasicModel {
    private String value;
    private Observable obs;
    
    public BasicModel() {
        this.value = "Some value";
        this.obs = new Observable(this);
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String newValue ) {
        this.value = newValue;
        obs.notifyObservers();
    }
    
    public void addObserver(Observer observer) {
        this.obs.add(observer);
    }
}
