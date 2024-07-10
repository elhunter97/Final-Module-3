package com.hbn.final_module_3.controllers;

import com.hbn.final_module_3.models.Product;
import com.hbn.final_module_3.services.IService;
import com.hbn.final_module_3.services.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProcductController",value="/product")
public class ProductController extends HttpServlet {
    IService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/products/create.jsp").forward(req, resp);
                break;
            default:
                List<Product> products = productService.findAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/products/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                int price = Integer.parseInt(req.getParameter("price"));
                Double discount = Double.parseDouble(req.getParameter("discount"));
                int stock = Integer.parseInt(req.getParameter("stock"));
                Product product = new Product(name, price, discount, stock);
                productService.save(product);
                resp.sendRedirect("/product");
                break;
        }
    }
}
