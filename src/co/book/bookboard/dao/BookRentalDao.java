package co.book.bookboard.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.book.VO.BookRentalVO;
import co.book.common.DAO;
import co.book.common.DaoInterface;

public class BookRentalDao extends DAO implements DaoInterface<BookRentalVO> {
	
	private PreparedStatement psmt;  
	private ResultSet rs;
	
	private final String RETURNINSERT = "INSERT INTO BOOKRENTAL(RENTALDATE,BOOKCODE,MEMBERID) VALUES(SYSDATE, ?,?)";

	@Override
	public ArrayList<BookRentalVO> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookRentalVO select(BookRentalVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookRentalVO vo) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(RETURNINSERT);
	
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getMemberId());
	


			n = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	@Override
	public int update(BookRentalVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BookRentalVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private  void close() {

		try {
			if(rs != null) {rs.close();}
			if(psmt != null) {psmt.close();}
			if(conn != null) {conn.close();}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	} //end of close


}
