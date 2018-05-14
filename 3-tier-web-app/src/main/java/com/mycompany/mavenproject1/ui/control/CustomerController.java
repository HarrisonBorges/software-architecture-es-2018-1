package com.mycompany.mavenproject1.ui.control;

import com.mycompany.mavenproject1.business.CountryBusiness;
import com.mycompany.mavenproject1.business.CustomerBusiness;
import com.mycompany.mavenproject1.data.Country;
import com.mycompany.mavenproject1.data.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customerController")
public class CustomerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Customer newCustomer = new Customer();
        CountryBusiness countryBusiness = new CountryBusiness();
        //req.getParameter("inputName")/
        int age = Integer.parseInt(req.getParameter("inputAge"));
        String name = req.getParameter("inputName");
        String phone = req.getParameter("inputPhone");
        Country country = countryBusiness.readById(Integer.parseInt(req.getParameter("inputCountry")));

        newCustomer.setAge(age);
        try {
            newCustomer.setCountry(country);
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            newCustomer.setName(name);
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        newCustomer.setPhone(phone);
        CustomerBusiness business = new CustomerBusiness();

        try {
            business.create(newCustomer);
            req.getSession().setAttribute("customerList", business.readAll());
            req.getSession().setAttribute("countryList", countryBusiness.readAll());
            resp.sendRedirect("customer.jsp");
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            try (PrintWriter out = resp.getWriter()) {
                out.println("<div>" + ex + "</div>");
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountryBusiness countryBusiness = new CountryBusiness();
        CustomerBusiness business = new CustomerBusiness();
        req.getSession().setAttribute("customerList", business.readAll());
        req.getSession().setAttribute("countryList", countryBusiness.readAll());
        resp.sendRedirect("customer.jsp");
    }

}
