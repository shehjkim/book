package co.book.bookboard.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.book.VO.BookVO;
import co.book.common.DAO;
import co.book.common.DaoInterface;

public class BookBoardDao extends DAO implements DaoInterface<BookVO> {
	private PreparedStatement psmt;  
	private ResultSet rs;
	
	private final String BOOKSELECTLIST = "SELECT * FROM BOOK ORDER BY BOOKCODE DESC";
	private final String BOOKSELECT = "SELECT * FROM BOOK WHERE BOOKCODE = ?";
	private final String BOOKINSERT ="INSERT INTO BOOK(BOOKCODE,BOOKNAME) VALUES (?,?)";
	private final String BOOKUPDATE = "UPDATE BOOK SET BOOKNAME=?,QUANTITY=?,BCOUNT=? WHERE BOOKCODE=?";
	private final String BOOKDELETE ="DELETE FROM BOOK WHERE BOOKCODE=?";
	private final String BOOKRENTAL = " UPDATE BOOK SET BCOUNT=BCOUNT-1 WHERE BOOKCODE=?";
	private final String BOOKRETURN = " UPDATE BOOK SET BCOUNT=BCOUNT+1 WHERE BOOKCODE=?";

	
	public ArrayList<BookVO> selectList() {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		BookVO vo;

		try {
			psmt = conn.prepareStatement(BOOKSELECTLIST); 
			rs = psmt.executeQuery();

			while(rs.next()) {
				vo = new BookVO();
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookname"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));

				list.add(vo);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} 

		return list;
	} //end of selectList

	
	
	
	@Override
	public BookVO select(BookVO vo) {
		
		try {
			psmt = conn.prepareStatement(BOOKSELECT);
			psmt.setString(1, vo.getBookCode());
			//psmt.setString(1, vo.getBookCode());
			rs = psmt.executeQuery();

			if(rs.next()) {
				
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookname"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));


			}


		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close();
		}

		return vo;
	} //end of select
	
	
	

	@Override
	public int insert(BookVO vo) {
		
		//INSERT INTO BOOK(BOOKCODE,BOOKNAME) VALUES (?,?)";
		
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOOKINSERT);
	
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getBookName());
	


			n = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return n;
		
		
	}//end of insert
	
	
	

	@Override
	public int update(BookVO vo) {
		
		//UPDATE BOOK SET BOOKNAME=?,QUANTITY=?,BCOUNT=? WHERE BOOKCODE=?
		
		
		int n =0;

		try {
			psmt = conn.prepareStatement(BOOKUPDATE);
			psmt.setString(1, vo.getBookName());
			psmt.setInt(2, vo.getQuantity());
			psmt.setInt(3, vo.getbCount());
			psmt.setString(4, vo.getBookCode());
			n = psmt.executeUpdate();




		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	} //end of update
	
	

	@Override
	public int delete(BookVO vo) {
		//DELETE FROM BOOK WHERE BOOKCODE=?
		int n = 0;


		try {
			psmt = conn.prepareStatement(BOOKDELETE);
			psmt.setString(1, vo.getBookCode());

			n = psmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	} //end of delete
	
	
	
	
	public int bookRental(BookVO vo) {
		//UPDATE BOOK SET BCOUNT=BCOUNT-1 WHERE BOOKCODE=?
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOOKRENTAL);
			psmt.setString(1, vo.getBookCode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	} //end of bookrental
	
	
	public int bookReturn(BookVO vo) {
		//UPDATE BOOK SET BCOUNT=BCOUNT+1 WHERE BOOKCODE=?
		int n = 0;
		try {
			psmt = conn.prepareStatement(BOOKRETURN);
			psmt.setString(1, vo.getBookCode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	} //end of bookReturn
	

	
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
