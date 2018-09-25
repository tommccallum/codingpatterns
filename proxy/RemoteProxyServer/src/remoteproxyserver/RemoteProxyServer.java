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
package remoteproxyserver;

import java.rmi.Naming;

/**
 * VM Arguments:
 * -Djava.security.policy=/home/tom/Development/OoCodingPatterns/proxy/RemoteProxyServer/build/security.policy 
 * -Djava.rmi.server.codebase=file:/home/tom/Development/OoCodingPatterns/proxy/RemoteProxyServer/build/classes/remoteproxyserver
 * @author Tom McCallum
 */
public class RemoteProxyServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Server service = new RemoteServer();
            // this places the service accessible via rmiregistry
            // on the server
            Naming.bind( "MyService", service);
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }
    
}
