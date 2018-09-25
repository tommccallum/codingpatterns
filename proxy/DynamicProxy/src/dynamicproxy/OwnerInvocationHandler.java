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
package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Tom McCallum
 */
public class OwnerInvocationHandler implements InvocationHandler {
    private final PersonalDataBean person;
    
    public OwnerInvocationHandler(PersonalDataBean person) {
        this.person = person;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] arguments) throws IllegalAccessException {
        try {
            if ( method.getName().startsWith("get") ) {
                return method.invoke(person, arguments);
               
            } else if ( method.getName().startsWith("set") ) {
                // we deny the owner from setting their own info in 
                // case they have been hacked perhaps?
                throw new IllegalAccessException();
            }
        } catch( InvocationTargetException ex ) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
