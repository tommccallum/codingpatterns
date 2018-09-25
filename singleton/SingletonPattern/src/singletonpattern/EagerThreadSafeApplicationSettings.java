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
package singletonpattern;

/**
 * This is a Singleton class that could be used throughout an application.
 * We lose the flexibility that the singleton will only be create when required 
 * though.
 * @author Tom McCallum
 */
public class EagerThreadSafeApplicationSettings {
    static EagerThreadSafeApplicationSettings instance = new EagerThreadSafeApplicationSettings();
    
    private EagerThreadSafeApplicationSettings() {
        System.out.println("Creating instance of "+this.getClass().toString());
    }
    
    /**
     * This function is here is NOT thread safe and two threads could attempt
     * to enter this function at the same time.
     * @return 
     */
    public static EagerThreadSafeApplicationSettings getInstance() {
        System.out.println("["+EagerThreadSafeApplicationSettings.class.toString()+"] Request to return instance");
        return instance;
    }
        
}
