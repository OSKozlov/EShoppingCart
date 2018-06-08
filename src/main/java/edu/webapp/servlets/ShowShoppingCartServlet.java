package edu.webapp.servlets;

import edu.webapp.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 
 * @version 1.0
 */
public class ShowShoppingCartServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AddToShoppingCartServlet.class);

    @Override
    protected void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException, IOException {

        final PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<head><title>Shopping Cart items ...</title></head>");
        writer.println("<body>");

        /** print form */
        writer.println("<form action='addToShoppingCart' method='post'>");
        writer.println("    <input type='hidden' name='action' value='add'>");
        writer.println("    Name: <input type='text' name='item'>");
        writer.println("    <input type='submit' value='Add'>");
        writer.println("</form>");

        /** print items */
        writer.println("<p>");
//        System.err.println("#### Shopping cart : " + ShoppingCart.getInstance());
        final List<String> items = ShoppingCart.getInstance(request).getItems();
        if (items.size() > 0) {
            writer.println("<ul>");
            for (final String item : items) {
                writer.println("<li><a href='removeFromShoppingCart?item=" + item + "'>" + item + "</a></li>");
            }
            writer.println("</ul>");

        } else {
            writer.println("No items...");
        }
        writer.println("</p>");

        /** */
        writer.println("</body>");
        writer.println("</html>");
    }

}
