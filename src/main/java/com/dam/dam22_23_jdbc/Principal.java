package com.dam.dam22_23_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Cargamos el driver
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Class.forName("org.postgresql.Driver");
		
		//Obtener una conexión
		Connection conexion = 
				DriverManager.getConnection("jdbc:postgresql://localhost/dam22", "postgres", "1234.Abcd");
		
		Statement sentencia = conexion.createStatement();
		ResultSet resultados = sentencia.executeQuery("SELECT * FROM alumno");
		
		while (resultados.next()) {
			
			System.out.println(resultados.getInt(1) + " " + resultados.getString(2) + " " + 
							   resultados.getString(3));
			
		}
		
		//Inserción
		Statement insercion = conexion.createStatement();
		int filas = insercion.executeUpdate("INSERT INTO alumno VALUES(500, 'Jose', 'ASIR')");
		
		if (filas == 0) {
			System.out.println("El registro NO se ha insertado");
		}else {
			System.out.println("El registro se ha insertado correctamente");
		}
		
		//Actualización
		Statement actualizacion = conexion.createStatement();
		filas = actualizacion.executeUpdate("UPDATE alumno SET nombre = 'José Antonio' WHERE codigo = 500");
		
		if (filas == 0) {
			System.out.println("El registro NO se ha modificado");
		}else {
			System.out.println("El registro se ha modificado correctamente");
		}
		
		//Borrado
		Statement borrado = conexion.createStatement();
		filas = borrado.executeUpdate("DELETE FROM alumno WHERE codigo = 500");
				
		if (filas == 0) {
			System.out.println("El registro NO se ha borrado");
		}else {
			System.out.println("El registro se ha borrado correctamente");
		}
		
		
		resultados.close();
		sentencia.close();
		insercion.close();
		actualizacion.close();
		borrado.close();
		conexion.close();

	}

}
