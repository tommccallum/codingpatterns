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
package fileiodecoratorexample;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Tom McCallum
 */
public class FileIODecoratorExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int c;
        
        try { 
            // InputStream is the interface for the raw functionality 
            // FilterInputStream is the base class for the decorators
            // 
            // FileInputStream implements InputStream
            // BufferedInputStream impl FilterInputStream and decorates FileInputStream
            // UpperCaseInputStream impl FilterInputStream and decorates BufferedInputStream
            InputStream in = new UpperCaseInputStream(
                                    new BufferedInputStream(
                                        new FileInputStream("test.txt")));
            while ( (c = in.read()) >= 0 ) {
                System.out.println((char)c);
            }
            in.close();
        } catch( IOException ex ) {
            ex.printStackTrace();
        }
    }
    
}
