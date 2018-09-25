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
 * @author Tom McCallum
 */
public class NonThreadSafeApplicationSettings {
    static NonThreadSafeApplicationSettings instance;
    
    private NonThreadSafeApplicationSettings() {
        System.out.println("Creating instance of "+this.getClass().toString());
    }
    
    /**
     * This function is here is NOT thread safe and two threads could attempt
     * to enter this function at the same time.
     * @return 
     */
    public static NonThreadSafeApplicationSettings getInstance() {
        System.out.println("["+NonThreadSafeApplicationSettings.class.toString()+"] Request to return instance");
        if ( instance == null ) {
            instance = new NonThreadSafeApplicationSettings();
        }
        return instance;
    }
        
}
