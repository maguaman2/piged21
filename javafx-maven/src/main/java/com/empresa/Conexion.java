package com.empresa;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

     public Connection connectToDB() {
          Connection connection = null;

          try {
               connection = DriverManager.getConnection("jdbc:postgresql://ec2-50-19-26-235.compute-1.amazonaws.com:5432/dfrtg02nfu9ju","hxjvdlckmiytvx", "46c591a986c57224f901c25f6cf539d047e14420b06cb6810b5671efa9461157");
               if (connection != null) {
                    System.out.println("Se estableció la conexión :)");
               }
          } catch (Exception e) {
               // TODO: handle exception
               System.out.println("Error al conectar a la base.");
               e.printStackTrace();
          }finally {
               return connection;
          }

     }
}
