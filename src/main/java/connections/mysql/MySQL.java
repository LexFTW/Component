package connections.mysql;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import connections.IConnection;
import models.UserLog;

public class MySQL implements Serializable, IConnection{

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private String url, user, password;
	private EntityManagerFactory emf;
	private EntityManager em;
	private UserLog userlog = new UserLog();
	
	public MySQL() {
		this.url = "localhost:3306/forhonor";
		this.user = "root";
		this.password = "";
		
		if(!this.connection()) {
			System.err.println("[ERROR] - No se pudo establecer conexión");
		}else {
			System.out.println("[INFO] - Conexión Establecida");
			this.userlog.setUsername(this.user);
		}
		
	}

	public MySQL(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
		
		if(!this.connection()) {
			System.err.println("[ERROR] - No se pudo establecer conexión");
		}else {
			System.out.println("[INFO] - Conexión Establecida");
			this.userlog.setUsername(this.user);
		}
		
	}

	public boolean connection() {
		Map<String, String> persistenceMap = new HashMap<String, String>();
		persistenceMap.put("javax.persistence.jdbc.url", "jdbc:mysql://"+this.url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		persistenceMap.put("javax.persistence.jdbc.user", this.user);
		persistenceMap.put("javax.persistence.jdbc.password", this.password);
		persistenceMap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		
		this.emf = Persistence.createEntityManagerFactory("connection", persistenceMap);
		this.em = this.emf.createEntityManager();
		
		if(this.em.isOpen()) {
			return true;
		}
		
		return false;
	}

	public boolean insert(String query) {
		this.em.getTransaction().begin();
		Query q = this.em.createNativeQuery(query);
		int result = q.executeUpdate();
		this.em.getTransaction().commit();
		
		if(result >= 1) {
			this.userlog.setUsername(this.emf.getProperties().get("hibernate.connection.username").toString());
			this.userlog.setHexecute(Calendar.getInstance());
			this.userlog.setTquery("INSERT");
			this.userlog.setNumRegis(result);
			System.out.println(userlog.toString());
			return true;
		}
		
		return false;
	}

	public boolean delete(String query) {
		this.em.getTransaction().begin();
		Query q = this.em.createNativeQuery(query);
		int result = q.executeUpdate();
		this.em.getTransaction().commit();
		
		if(result >= 1) {
			this.userlog.setUsername(this.emf.getProperties().get("hibernate.connection.username").toString());
			this.userlog.setHexecute(Calendar.getInstance());
			this.userlog.setTquery("DELETE");
			this.userlog.setNumRegis(result);
			System.out.println(userlog.toString());
			return true;
		}
		
		return false;
	}
	
	public boolean update(String query) {
		this.em.getTransaction().begin();
		Query q = this.em.createNativeQuery(query);
		int result = q.executeUpdate();
		this.em.getTransaction().commit();
		
		if(result >= 1) {
			this.userlog.setUsername(this.emf.getProperties().get("hibernate.connection.username").toString());
			this.userlog.setHexecute(Calendar.getInstance());
			this.userlog.setTquery("DELETE");
			this.userlog.setNumRegis(result);
			System.out.println(userlog.toString());
			return true;
		}
		
		return false;
	}

}
