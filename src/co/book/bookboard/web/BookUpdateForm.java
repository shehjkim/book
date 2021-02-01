package co.book.bookboard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.BookVO;
import co.book.bookboard.dao.BookBoardDao;
import co.book.common.Service;

public class BookUpdateForm implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		BookBoardDao dao = new BookBoardDao();
		BookVO vo= new BookVO();
		
		vo.setBookCode(request.getParameter("row"));
		
		
		vo = dao.select(vo);
		
		request.setAttribute("voServ", vo);
		String viewPage = "bookBoard/boardUpdateForm";
		
		return viewPage;
	}

}
