package co.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.book.VO.MemberVO;
import co.book.common.DAO;
import co.book.common.DaoInterface;


public class MemberDAO extends DAO implements DaoInterface<MemberVO> {
	private PreparedStatement psmt;
	private ResultSet rs;

//조회
	@Override
	public ArrayList<MemberVO> selectList() {
		// TODO Auto-generated method stub		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "SELECT * FROM member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("memberID"));
				vo.setMemberName(rs.getString("memberName"));
				vo.setMemberTel(rs.getString("memberTel"));
				vo.setMemberAddress(rs.getString("memberAddress"));
				vo.setMemberAuth(rs.getString("memberAuth"));
				list.add(vo);
				System.out.println("조회완료");
			}					
		} catch (Exception e) {
		}finally {
			close();
		}
		return list;
	}
//한건조회
	@Override
	public MemberVO select(MemberVO vo) {
		String sql = "SELECT * FROM member WHERE memberID=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberName(rs.getString("memberName"));
				vo.setMemberPassword(rs.getString("memberPassword"));
				vo.setMemberTel(rs.getString("memberTel"));
				vo.setMemberAddress(rs.getString("memberAddress"));
				vo.setMemberAuth(rs.getString("memberAuth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
//등록
	@Override
	public int insert(MemberVO vo) {
		String sql  = "INSERT INTO member(memberId,memberName,memberPassword,memberTel,memberAddress) VALUES (?,?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberPassword());			
			psmt.setString(4, vo.getMemberTel());
			psmt.setString(5, vo.getMemberAddress());
			n = psmt.executeUpdate();
			System.out.println( n + "명 등록 되었습니다.");
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			close();
		}	
		return n;
	}
//수정
	@Override
	public int update(MemberVO vo) {
		int n = 0;
		String sql = "UPDATE member SET memberPassword=?, memberTel = ?, memberAddress=?, memberAuth=? WHERE memberId=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberPassword());
			psmt.setString(2, vo.getMemberTel());
			psmt.setString(3, vo.getMemberAddress());
			psmt.setString(4, vo.getMemberAuth());
			psmt.setString(5, vo.getMemberId());			
			n = psmt.executeUpdate();
			System.out.println(n + "건의 회원정보가 수정되었습니다. ");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
//삭제
	@Override
	public int delete(MemberVO vo) {
		int n = 0;
		String sql = "DELETE FROM member WHERE memberID=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			n = psmt.executeUpdate();
			System.out.println(n + "명의 회원이 삭제되었습니다. ");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return n;
	}
//ID 중복체크	
	public boolean IsidCheck(String id) {			
		boolean bool = true;
		
		String sql = "SELECT memberId FROM member WHERE memberId = ?";
		try {
			psmt  = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				bool = false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return bool;
	}

//로그인 메소드
	public MemberVO login(MemberVO vo) {							//로그인 메소드
		String sql="SELECT * FROM MEMBER WHERE MemberID = ? AND MemberPASSWORD = ?";		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberName(rs.getString("memberName"));
				vo.setMemberTel(rs.getString("memberTel"));
				vo.setMemberAddress(rs.getString("memberAddress"));
				vo.setMemberAuth(rs.getString("memberAuth"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return vo;
	}
	
	

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
