package edu.webapp.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 
 * @version 1.0
 */
public class ShoppingCart {

    private final List<String> items = new ArrayList<String>();

    public static ShoppingCart getInstance(final HttpServletRequest request) {
        return (ShoppingCart) request.getAttribute("shoppingCart");
    }

    public void add(final String item) {
        items.add(item);
    }

    public void remove(final String item) {
        final Iterator<String> it = getItems().iterator();
        while (it.hasNext()) {
            final String next = it.next();
            if (item.equals(next)) {
                it.remove();
            }
        }
    }

    public List<String> getItems() {
        return items;
    }
}
