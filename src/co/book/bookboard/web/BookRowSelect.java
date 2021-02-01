package co.book.bookboard.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.BookVO;
import co.book.bookboard.dao.BookBoardDao;
import co.book.common.Service;

public class BookRowSelect implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		BookBoardDao dao = new BookBoardDao();
		BookVO vo = new BookVO();
		
		vo.setBookCode(request.getParameter("bId"));
		
		vo = dao.select(vo);
		
		request.setAttribute("vos", vo);
		
		String viewPage = "bookBoard/bookRowSelect";
		
		return viewPage;
	}

}
