package com.miempresa.controllers;

import com.miempresa.models.Producto;
import com.miempresa.dao.ProductoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));

        Producto producto = new Producto(nombre, descripcion, precio);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tu_base", "usuario", "password"
            );
            ProductoDAO dao = new ProductoDAO(conn);
            dao.insertarProducto(producto);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/listarProductos.jsp");
        dispatcher.forward(request, response);
    }
}
