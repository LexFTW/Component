package models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Calendar;

public class UserLog implements PropertyChangeListener{

	private String username, tquery;
	private int numRegis;
	private Calendar hexecute;
	
	public UserLog() {
		super();
	}
	

	public UserLog(String username, String tquery, int numRegis, Calendar hexecute) {
		super();
		this.username = username;
		this.tquery = tquery;
		this.numRegis = numRegis;
		this.hexecute = hexecute;
	}


	public String getUsername() {
		return username;
	}

	public String getTquery() {
		return tquery;
	}

	public int getNumRegis() {
		return numRegis;
	}

	public Calendar getHexecute() {
		return hexecute;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setTquery(String tquery) {
		this.tquery = tquery;
	}

	public void setNumRegis(int numRegis) {
		this.numRegis = numRegis;
	}

	public void setHexecute(Calendar hexecute) {
		this.hexecute = hexecute;
	}

	@Override
	public String toString() {
		return "UserLog [username=" + username + ", tquery=" + tquery + ", numRegis=" + numRegis + ", hexecute="
				+ hexecute.get(Calendar.HOUR_OF_DAY) + ":" + hexecute.get(Calendar.MINUTE) + ":" + hexecute.get(Calendar.SECOND) + " " + hexecute.get(Calendar.DAY_OF_MONTH) + "/" + hexecute.get(Calendar.MONTH) + "/" + hexecute.get(Calendar.YEAR)  + "]";
	}

	public void propertyChange(PropertyChangeEvent e) {
		
	}
	
}
