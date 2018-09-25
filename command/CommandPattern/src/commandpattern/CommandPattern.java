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
 *
 * @author Tom McCallum
 */
public class CommandPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        
        remote.setCommand(lightOn);
        remote.buttonPressed();
        
        remote.setCommand(new NoCommand());
        remote.buttonPressed();
        
        MacroCommand macro = new MacroCommand();
        macro.add( lightOn );
        macro.add( lightOn );
        macro.add( lightOn );
        macro.add( new NoCommand() );
        remote.setCommand(macro);
        remote.buttonPressed();
    }
    
}
