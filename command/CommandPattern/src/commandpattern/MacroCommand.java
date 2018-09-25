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
package commandpattern;

import java.util.ArrayList;

/**
 * This is a good extension of Command allowing you to 
 * create sets of user-defined actions.
 * This could also be used to store a history of commands.
 * @author Tom McCallum
 */
public class MacroCommand implements Command {
    private ArrayList<Command> commands;
    
    public MacroCommand() {
        commands = new ArrayList<>();
    }
    
    public void add(Command command) {
        commands.add( command );
    }
    
    public void remove(Command command) {
        commands.remove(command);
    }
    
    public void execute() {
        for(Command command : commands ) {
            command.execute();
        }
    }
    
}
