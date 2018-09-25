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
package remoteproxyclient;

import remoteproxyserver.Server;
import java.rmi.Naming;

/**
 *
 * @author Tom McCallum
 */
public class Client {
    public void sayHello()  {
        try {
            // you will get an exception if no security manager is set
            System.setSecurityManager(new SecurityManager());
            
            // MyServer can be any string which is registered with the rmiregistry
            // service
            // 'Server' must be a shared interface between client and server
            Server server = (Server) Naming.lookup("rmi://127.0.0.1/MyService");
            String s = server.sayWhat();
            System.out.println("Hello "+s);
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
