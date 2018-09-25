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

import java.lang.reflect.Proxy;

/**
 * Dynamic proxy's provide checks on using a particular class
 * It's dynamic because it creates a class at runtime
 * @author Tom McCallum
 */
public class DynamicProxy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonalDataBean bean = new PersonalDataBean();
        bean.setAge(40);
        bean.setName("Joe Bloggs");
        
        Person proxy = getOwnerProxy(bean);
        System.out.println(Proxy.isProxyClass(bean.getClass()));
        System.out.println(Proxy.isProxyClass(proxy.getClass()));
        System.out.println(proxy.getAge());
        System.out.println(proxy.getName());
        try {
            proxy.setAge(50); // throws exception
        } catch( Exception ex ) {
            System.out.println("method failed");
        }
        
    }
    
    public static Person getOwnerProxy(PersonalDataBean person) {
        return (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), 
                                                            person.getClass().getInterfaces(), 
                                                            new OwnerInvocationHandler(person) 
                                                         );
    }
}
