package co.book.common;

import java.util.ArrayList;

public interface DaoInterface<T> {
	public ArrayList<T> selectList();
	public T select(T vo);
	public int insert(T vo);
	public int update(T vo);
	public int delete(T vo);
	

}
