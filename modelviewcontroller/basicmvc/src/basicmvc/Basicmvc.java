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
public class Basicmvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BasicModel model = new BasicModel();
        BasicController controller = new BasicController(model);
        
        // note here that we have no interaction with the view
        // as the control should come from the controller.
        controller.sayHello();
    }
    
}
