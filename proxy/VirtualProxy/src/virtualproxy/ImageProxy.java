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
package virtualproxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * This proxy will allow us to display a local image until
 * the one we want is downloaded.
 * @author Tom McCallum
 */
public class ImageProxy implements Icon {
    private volatile ImageIcon imageIcon;
    private final URL imageURL;
    private Thread retrievalThread;
    private boolean retrieving = false;
    
    public ImageProxy(URL url) {
        this.imageURL = url;
    }
    
    private final synchronized void setImageIcon(ImageIcon imageIcon ) {
        this.imageIcon = imageIcon;
    }
    
    @Override
    public void paintIcon(Component cmpnt, Graphics graphics, int x, int y) {
        if ( imageIcon != null ) {
            imageIcon.paintIcon(cmpnt,graphics,x,y);
        } else {
            // this puts in our placeholder
            graphics.drawString("Loading image...", x+300,y+190);
            if ( !retrieving ) {
                // this is where we do the work of loading the image
                retrieving = true;
                retrievalThread = new Thread(new Runnable() {
                   public void run() {
                       try { 
                           setImageIcon( new ImageIcon(imageURL, "Image"));
                           cmpnt.repaint();
                       } catch( Exception ex ) {
                           ex.printStackTrace();
                       }
                   } 
                });
                retrievalThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if ( imageIcon != null ) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if ( imageIcon != null ) {
            return imageIcon.getIconWidth();
        } else {
            return 600;
        }
    }
    
}
