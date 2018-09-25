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
public class BasicView implements Observer {
    private BasicModel model;
    private BasicController controller;
    private String value;
    
    public BasicView( BasicController controller, BasicModel model ) {
        this.model = model;
        this.controller = controller;
        this.model.addObserver(this);
        createView();
    }
    
    // we PULL the values from the model on VIEW creation
    public void createView() {
        System.out.println("Create view components..."+model.getValue());
    }
    

    // when the model updates, as the view listens in on the model we will
    // get a change event, potentially with an object passed through.  We
    // can either use that object or use our direct connection to get the new
    // value.
    @Override
    public void update(Object model) {
        System.out.println("after user has changed a value, we update the model");
        value = this.model.getValue();
        createView();
    }
    
    public void somethingClicked() {
        controller.sayHello();
    }
}
