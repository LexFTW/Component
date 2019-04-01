package PersistenceBean;

import connections.mysql.MySQL;

public class Main {

	public static void main(String[] args) {
		MySQL mysql = new MySQL();
		if(!mysql.insert("INSERT INTO facciones(nombre_faccion, lore) VALUES('B', 'b')")) {
			System.err.println("[ERROR] - No se pudieron insertar los datos.");
		}
		
		if(!mysql.delete("DELETE FROM facciones WHERE nombre_faccion = 'B'")) {
			System.err.println("[ERROR] - No se pudieron eliminar los datos.");
		}
	}
	
}
