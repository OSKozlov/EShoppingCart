package edu.webapp.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
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
public class AddToShoppingCartServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AddToShoppingCartServlet.class);

    private int maxItemsCount = Integer.MAX_VALUE;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        maxItemsCount = Integer.parseInt(config.getInitParameter("maxItemCount"));
    }

    @Override
    protected void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException, IOException {

        /** get item name; raise an exception if no item specified */
        final String item = request.getParameter("item");
        if (item == null) {
            throw new ServletException("No item specified.");
        }

        final ShoppingCart shoppingCart = ShoppingCart.getInstance(request);

        /** check if list exceeds the maximum; remove the first item if needed */
        if (shoppingCart.getItems().size() >= maxItemsCount) {
            logger.info("Max size reached. Remove last item.");
            shoppingCart.getItems().remove(0);
        }

        /** add ... */
        logger.info("Add: " + item);
        shoppingCart.add(item);

        /** redirect to show */
        response.sendRedirect("showShoppingCart");
    }

}
