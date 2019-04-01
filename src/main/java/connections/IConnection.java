package connections;

public interface IConnection {

	public boolean connection();
	public boolean insert(String query);
	public boolean delete(String query);
	public boolean update(String query);
	
}
