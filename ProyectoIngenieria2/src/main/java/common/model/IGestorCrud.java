package common.model;

public interface IGestorCrud {
	public void create(Object o);
	public String read();
	public boolean update(int pos, Object o);
	public boolean delete(int pos);
}
