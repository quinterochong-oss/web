package com.miempresa.dao;

import com.miempresa.models.Producto;
import java.sql.*;

public class ProductoDAO {
    private Connection conn;

    public ProductoDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertarProducto(Producto p) throws SQLException {
        String sql = "INSERT INTO productos(nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getDescripcion());
            stmt.setDouble(3, p.getPrecio());
            stmt.setInt(4, p.getStock());
            stmt.executeUpdate();
        }
    }
}
