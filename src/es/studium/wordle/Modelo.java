package es.studium.wordle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Modelo
{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/wordle";
	String login = "userWordle"; // Usuario MySQL
	String password = "Studium2023;"; // Su clave correspondiente
	String sentencia = "";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	int letrasPorPalabra = 0;
	
	int puntuacion;
	
	public Modelo(int i) {
		letrasPorPalabra = i;
		connection = this.conexion();
	}

	private Connection conexion()
	{
		try
		{
			// Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			// Establecer la conexión con la BD
			return (DriverManager.getConnection(url, login, password));
		} catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}
	
	public void desconectar()
	{
		try
		{
			if (connection != null)
			{
				connection.close();
			}
		} catch (SQLException e)
		{
		}
	}
	
	public String obtenerJugadores()
	{
		String contenido = "";
		ResultSet rs = null;
		try
		{
			// Crear una sentencia
			statement = connection.createStatement();
			// Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL
			rs = statement.executeQuery("SELECT * FROM jugadores ORDER BY puntosJugador DESC LIMIT 10;");
			while (rs.next()) // Si hay, al menos uno
			{
				// Sacamos los siguientes datos
				// En getString o getInt también se puede poner un número que indica posición
				contenido = contenido + /* rs.getInt("idJugador") + " "+ */
						"Jugador: " + rs.getString("nombreJugador") + ", puntuación: " + rs.getString("puntosJugador")
						+ "\n";
			}
		} catch (SQLException sqle)
		{
		}
		return (contenido);
	}
	
	public void guardarPuntuacion(String nick, int puntos)
	{
		String sentencia = "INSERT INTO jugadores VALUES(null, '" + nick + "', " + puntos + ");";
		try
		{
			// Crear una sentencia
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// Ejecutar la sentencia
			statement.executeUpdate(sentencia);
		} catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public void ayuda()
	{
		goToURL("file:///C:/Users/madzi/eclipse-workspace/Workspace/WordleNew/ayuda/ayuda.html");
	}

	private void goToURL(String URL)
	{
		if (java.awt.Desktop.isDesktopSupported())
		{
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE))
			{
				try
				{
					java.net.URI uri = new java.net.URI(URL);
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
	}
	
	public String obtenerPalabraAleatoria(int letrasPorPalabra) {
		String nombreArchivo = "";
		String palabraAleatoria = "";
		List<String> palabras = new ArrayList<>();

		switch(letrasPorPalabra) {
		case 3:
			nombreArchivo = "words3letters.txt";
			break;
		case 4:
			nombreArchivo = "words4letters.txt";
			break;
		case 5:
			nombreArchivo = "words5letters.txt";
			break;
		case 6:
			nombreArchivo = "words6letters.txt";
			break;
		}
			
		try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo)))
		{
			String linea;
			while ((linea = br.readLine()) != null)
			{
				String[] palabrasLinea = linea.split("\\s+");
				for (String palabra : palabrasLinea)
				{
					palabras.add(palabra);
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		Random random = new Random();
		int indiceAleatorio = random.nextInt(palabras.size());
		palabraAleatoria = palabras.get(indiceAleatorio);
		return palabraAleatoria;
		
	}
	
	public int calcularPuntuacion(int intentos) {
	    int puntuacion = 0;

	    if (intentos == 5) {
	        puntuacion = 25;
	    } else if (intentos == 4) {
	        puntuacion = 20;
	    } else if (intentos == 3) {
	        puntuacion = 15;
	    } else if (intentos == 2) {
	        puntuacion = 10;
	    } else if (intentos == 1) {
	        puntuacion = 5;
	    }

	    return puntuacion;
	}
	
	

}
