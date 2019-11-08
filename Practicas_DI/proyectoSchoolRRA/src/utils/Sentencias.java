package utils;

import basedatos.DatosBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sentencias {

    static Connection connection = null;

    public static void registrarUsuario(Usuario usuario){
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    connection = basedatos.Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    //st.execute("INSERT INTO inicio (nombre,apellido,correo) VALUES ('','','')");
                    String query = "INSERT INTO %s (%s, %s, %s, %s) " +
                                           "VALUES ('%s', '%s', '%s', '%s')";
                    if (st.execute(String.format(query
                            , DatosBD.TAB_TABLAUSUARIOS
                            , DatosBD.TAB_INICIO_COL_NOMBRE
                            , DatosBD.TAB_INICIO_COL_APELLIDO
                            , DatosBD.TAB_INICIO_COL_CORREO
                            , DatosBD.TAB_INICIO_COL_CONTRASENIA
                            , utils.Usuario.getNombre()
                            , utils.Usuario.getApellidos()
                            , utils.Usuario.getCorreo()
                            , utils.Usuario.getContrasenia()
                    ))){
                        System.out.println("INSERCION NO REALIZADA");
                    }else {
                        System.out.println("INSERCION REALIZADA CORRECTAMENTE");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        //connection.commit();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    public static void registrarCicloUsuario(Usuario usuario) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    connection = basedatos.Conexion.dbConnector();
                    Statement st = connection.createStatement();
                    String query = "INSERT INTO %s (%s, %s, %s) " +
                            "VALUES ('%s', '%d', '%d')";
                    if (st.execute(String.format(query
                            , DatosBD.TAB_TABLACICLOS
                            , DatosBD.TAB_CICLOS_COL_NOMBRE_CICLO
                            , DatosBD.TAB_CICLOS_ID_ALUMNO
                            , DatosBD.TAB_CICLOS_COL_CONOCIMIENTOPREVIO
                            , utils.Usuario.getCiclo()
                            , getIDUsuario(usuario)
                            , utils.Usuario.getConocimientoPrevio()
                    ))) {
                        System.out.println("INSERCION NO REALIZADA");
                    } else {
                        System.out.println("INSERCION REALIZADA CORRECTAMENTE");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        //connection.commit();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
    public static int getIDUsuario(Usuario usuario){
        ResultSet rs = null;
        int aux=0;
        try {
            connection = basedatos.Conexion.dbConnector();
            Statement st = connection.createStatement();
            String sql = "SELECT %s from %s WHERE %s = '%s'";
            rs = st.executeQuery(String.format(sql
                    , DatosBD.TAB_INICIO_COL_ID
                    , DatosBD.TAB_TABLAUSUARIOS
                    , DatosBD.TAB_INICIO_COL_NOMBRE
                    , utils.Usuario.getNombre()));

            while (rs.next()) {
                aux     = rs.getInt(DatosBD.TAB_INICIO_COL_ID);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //   JOptionPane.showMessageDialog(null,"Error al acceder a la tabla " + e.getErrorCode(),ERROR,JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return aux;
    }


    public static boolean iniciarSesion(String usuario, String contrasenia){
        ResultSet rs = null;
        try {
            connection = basedatos.Conexion.dbConnector();
            Statement st = connection.createStatement();
            String sql = "SELECT %s, %s from %s WHERE %s = '%s' AND %s = '%s'";
            rs = st.executeQuery(String.format(sql
                    , DatosBD.TAB_INICIO_COL_NOMBRE
                    , DatosBD.TAB_INICIO_COL_CONTRASENIA
                    , DatosBD.TAB_TABLAUSUARIOS
                    , DatosBD.TAB_INICIO_COL_NOMBRE
                    , usuario
                    , DatosBD.TAB_INICIO_COL_CONTRASENIA
                    , contrasenia));
/*
            while (rs.next()) {
                usuar     = rs.getString(DatosBD.TAB_INICIO_COL_NOMBRE);
                contrasen = rs.getString(DatosBD.TAB_INICIO_COL_CONTRASENIA);
            }
 */
            return(rs.first());

        } catch (SQLException e) {
            e.printStackTrace();
            //   JOptionPane.showMessageDialog(null,"Error al acceder a la tabla " + e.getErrorCode(),ERROR,JOptionPane.WARNING_MESSAGE);
            return false;
        } finally {
            try {
                if (rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
