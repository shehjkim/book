package co.book.bookboard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.BookVO;
import co.book.bookboard.dao.BookBoardDao;
import co.book.common.Service;

public class BookDelete implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		BookBoardDao dao = new BookBoardDao();
		BookVO vo = new BookVO();
		vo.setBookCode(request.getParameter("row"));
		
		int n = dao.delete(vo);
		String viewPage = null;
		
		if(n!=0) {
			viewPage = "bookList.do";
		}
		return viewPage;
	}

}
