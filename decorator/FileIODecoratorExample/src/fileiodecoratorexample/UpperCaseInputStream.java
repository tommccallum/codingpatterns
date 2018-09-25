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

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Example of creating a filter which will convert all incoming characters to
 * uppercase.
 * 
 * Decorators in this way allow us to EXTEND functionality without MODIFYING the
 * original class.
 * @author Tom McCallum
 */
public class UpperCaseInputStream extends FilterInputStream {

    public UpperCaseInputStream(InputStream in) {
        super(in);
    }
    
    public int read() throws IOException {
        int c = in.read();
        return ( c== -1 ? c : Character.toUpperCase((char) c) );
    }

    @Override
    public int read(byte[] bytes, int offset, int len) throws IOException {
        int result = in.read(bytes, offset, len);
        for( int ii=offset; ii < offset + result; ii++ ) {
            bytes[ii] = (byte) Character.toUpperCase((char) bytes[ii]);
        }
        return result;
    }
    
    
    
}
