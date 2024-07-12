/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registro")
public class Registro extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (nombre == null || apellido == null || email == null || password == null || 
            nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendRedirect("/BloomProyectoFinal/pages/registrarse.html");
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setPassword(password);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.insertarUsuario(usuario);
            response.sendRedirect("/BloomProyectoFinal/pages/registrarse.html");  // Redirigir a una página de éxito
        } catch (Exception e) {
            response.sendRedirect("/BloomProyectoFinal/pages/registrarse.html");
        }
    }
}
