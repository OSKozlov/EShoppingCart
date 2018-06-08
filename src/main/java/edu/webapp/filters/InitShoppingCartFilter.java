package edu.webapp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.webapp.model.ShoppingCart;

/**
 * @author 
 * @version 1.0
 */
public class InitShoppingCartFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

        final HttpSession session = ((HttpServletRequest) request).getSession();

        ShoppingCart result = (ShoppingCart) session.getAttribute("shoppingCart");
        if (result == null) {
            result = new ShoppingCart();
            session.setAttribute("shoppingCart", result);
        }
        
        request.setAttribute("shoppingCart", result);
        chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
