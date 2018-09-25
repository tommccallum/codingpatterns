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
package modelview;

import java.awt.event.ActionEvent;

/**
 * Controller knows about the view and the model
 * All the application data and operations on that data should be in the model.
 * When your controller becomes large you should consider splitting the view actions
 * into multiple controllers.
 * @author Tom McCallum
 */
public class BasicController implements Controller {
    private BasicModel model;
    private View view;
    
    public BasicController( MainWindow window, BasicModel model ) {
        this.model = model;
        this.view = window;
        this.model.add( (Observer) this.view );
        this.view.registerForEvents( this );
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Controller::button pressed");
        model.setValue("hello world!");
    }
    
}
