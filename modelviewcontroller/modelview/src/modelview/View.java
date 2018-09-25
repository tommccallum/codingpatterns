/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelview;

/**
 *
 * @author Tom McCallum
 */
public interface View extends Observer {
    public void registerForEvents(Controller controller);
}
