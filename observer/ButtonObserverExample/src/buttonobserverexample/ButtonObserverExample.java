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
package buttonobserverexample;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This example shows that the JButton object is using the Observer pattern
 * to listen to when the it is pressed.  A listener is just another term for
 * an observer.
 * @author Tom McCallum
 */
public class ButtonObserverExample {
    JFrame frame;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ButtonObserverExample eg = new ButtonObserverExample();
        eg.go();
    }
    
    public void go() {
        frame = new JFrame();
        
        JButton button = new JButton("Press me!");
        // note the order that these print out 
        // - you should never assume the order that observers will fire
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        button.addActionListener((ActionEvent ae) -> { System.out.println("Lambda's are cool!"); });
        
        frame.add( button );
        frame.setSize(new Dimension(200,200));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    class AngelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Good!");
        }
    }
    
    class DevilListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Oops!");
        }
    }
}
  