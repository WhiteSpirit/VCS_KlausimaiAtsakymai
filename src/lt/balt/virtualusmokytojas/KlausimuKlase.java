package lt.balt.virtualusmokytojas;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class KlausimuKlase {
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	// http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv

	public static ArrayList<Klausimas> gautiKlausimusPasnekovuiIsDB(String pasnekovoVardas) {
		ArrayList<Klausimas> klausimaiPasnekovui = new ArrayList<Klausimas>();
		try {
			Class.forName("org.sqlite.JDBC");
			try {
			connection = DriverManager.getConnection("jdbc:sqlite:resources/tables/Klausimai.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			ResultSet rs = statement
					.executeQuery("select * from KlausimuLentele where Mokytojas = '" + pasnekovoVardas + "'");
			while (rs.next()) {
				klausimaiPasnekovui.add(new Klausimas(rs.getString("Klausimas"), rs.getString("VideoUrl"),
						rs.getString("Užuomina"), rs.getString("Atsakymas"), pasnekovoVardas));
			}
			} catch(SQLException sqlE) {System.err.println(sqlE.getMessage());}
		} catch(ClassNotFoundException classE) {}
		return klausimaiPasnekovui;
	}

}
