/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pc
 */
public class AlumnoImpl {
    
    Conexion x = new Conexion();
    String sql = "";
    ArrayList<Alumno> listaAlumnoEgresado = new ArrayList<Alumno>();

    
    public ArrayList<Alumno> listaEgresados(String s_anhio_egreso) throws java.lang.Exception{
    
        try {
            
            Connection conn = x.connectDatabase();
            sql="select * from alumno where alumno_codigo like '"+s_anhio_egreso+"%' ";
            
            System.out.println(sql);
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno datos = new Alumno();
                datos.setO_alumno_id(rs.getString("alumno_id"));
                datos.setO_alumno_codigo(rs.getString("alumno_codigo"));
                datos.setO_alumno_nombre(rs.getString("alumno_nombres"));
                datos.setO_alumno_apellido_paterno(rs.getString("alumno_apellido_paterno"));
                datos.setO_alumno_apellido_materno(rs.getString("alumno_apellido_materno"));
                datos.setO_alumno_direccion(rs.getString("alumno_direccion"));
                
                listaAlumnoEgresado.add(datos);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error "+ex.getMessage());
        }
        
        return listaAlumnoEgresado;
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        AlumnoImpl am = new AlumnoImpl();
        for (Alumno ad : am.listaEgresados("20")) {
            System.out.println("en el foor loop");
            System.out.println(ad.getO_alumno_codigo());
            System.out.println(ad.getO_alumno_nombre());
            System.out.println("fin");
        }
    }
    
}
