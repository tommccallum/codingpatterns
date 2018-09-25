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

/**
 * The Command interface allows us to change what the remote control does.
 * It also decouples the RemoteControl from the Light class.
 * @author Tom McCallum
 */
public class RemoteControl {
    Command slot;
    
    public RemoteControl() {
        
    }
    
    public void setCommand(Command command) {
        this.slot = command;
    }
    
    public void buttonPressed() {
        slot.execute();
    }
}
