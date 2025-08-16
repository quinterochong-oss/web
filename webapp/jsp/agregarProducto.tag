<!DOCTYPE html>
<html>
<head><title>Agregar Producto</title></head>
<body>
<h1>Agregar Producto</h1>
<form action="ProductoServlet" method="post">
    Nombre: <input type="text" name="nombre" required><br>
    Descripción: <input type="text" name="descripcion" required><br>
    Precio: <input type="number" step="0.01" name="precio" required><br>
    <input type="submit" value="Agregar">
</form>
</body>
</html>
