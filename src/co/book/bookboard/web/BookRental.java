package co.book.bookboard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.book.VO.BookVO;
import co.book.VO.MemberVO;
import co.book.bookboard.dao.BookBoardDao;
import co.book.common.Service;
import co.book.dao.MemberDAO;

public class BookRental implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//책게시판
		BookBoardDao dao = new BookBoardDao();
		BookVO vo = new BookVO();
		
		vo.setBookCode(request.getParameter("row"));
		
		String viewPage = null;
		
		int n = dao.bookRental(vo);
		
		//멤버
		//MemberDAO mDao = new MemberDAO();
		MemberVO mVo = new MemberVO();
		
		if(n != 0) {
			HttpSession session = request.getSession();
			session.setAttribute("bCode", vo.getBookCode());
			session.setAttribute("mId", mVo.getMemberId());
			
			viewPage = "bookRentalList.do";
		} else {
			String msg = "실패입니다.";
			request.setAttribute("msg", msg);
			viewPage = "error1";
		}

		
		return viewPage;
	}

}
