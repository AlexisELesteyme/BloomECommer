/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionDB;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
   public boolean insertarUsuario(Usuario usuario){
       String sql = "INSERT INTO RegistroUsuarios (nombre, apellido, email, password) VALUES (?, ?, ?, ?)";
       
       try (Connection conn = ConexionDB.obtenerConexion(); 
            PreparedStatement pstmt = conn.prepareStatement(sql)){
           
           pstmt.setString(1, usuario.getNombre());
           pstmt.setString(2, usuario.getApellido());
           pstmt.setString(3, usuario.getEmail());
           pstmt.setString(4, usuario.getPassword());
       
           int filasAfectadas = pstmt.executeUpdate();
           return filasAfectadas > 0;
        }catch (Exception e){
               e.printStackTrace();
            return false;
        }  
   }
   private Usuario extraerUsuarioDeResultSet(ResultSet rs) throws Exception{
   
    Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNombre(rs.getString("Nombre"));
        usuario.setApellido(rs.getString("Apellido"));
        usuario.setEmail(rs.getString("Email"));
        usuario.setPassword(rs.getString("Password"));
    return usuario; 
   }
   public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM RegistroUsuarios";
        try (Connection conn = ConexionDB.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Usuario usuario = extraerUsuarioDeResultSet(rs);
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
   }
   public Usuario ObtenerPorId(int id){
   String query ="SELECT * FROM RegistroUsuarios WHERE id = ?";
   
   try (Connection conn = ConexionDB.obtenerConexion();
        PreparedStatement pstm = conn.prepareStatement(query)){
        try(ResultSet rs = pstm.executeQuery()){
            if (rs.next()){
            return extraerUsuarioDeResultSet(rs);
            }
        }
    }catch(Exception e){
        e.printStackTrace();
    }
         return null;
    }
   public boolean eliminar (int id){
   String query = "DELETE FROM Registro WHERE Id = ?";
   
   try(Connection conn = ConexionDB.obtenerConexion();
           
        PreparedStatement pstmt = conn.prepareStatement(query)){
        pstmt.setInt(1, id);
        int filasAfectadas = pstmt.executeUpdate();
        return filasAfectadas > 0;
   }catch (Exception e){
        e.printStackTrace();
        return false;
   }
   
   }
}