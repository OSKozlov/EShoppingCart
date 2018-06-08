package edu.webapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.webapp.model.ShoppingCart;

/**
 * @author 
 * @version 1.0
 */
public class RemoveFromShoppingCartServlet extends HttpServlet {
	
    private static final Logger logger = Logger.getLogger(AddToShoppingCartServlet.class);

    @Override
    protected void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException, IOException {

        /** get item name; raise an exception if no item specified */
        final String item = request.getParameter("item");
        if (item == null) {
            throw new ServletException("No item specified.");
        }

        /** remove ... */
        logger.info("Remove: " + item);
        ShoppingCart.getInstance(request).remove(item);

        /** redirect to show */
        response.sendRedirect("showShoppingCart");
    }
	
}
