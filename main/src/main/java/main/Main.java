/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;

import contract.ControllerOrder;
import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     */
    public static void main(final String[] args) throws IOException {
    	
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        
        view.setController(controller);
        
        model.avoidLatency();

        controller.control();
        controller.orderPerform(ControllerOrder.NOTHING);
        model.Timer();
        
    }
}
