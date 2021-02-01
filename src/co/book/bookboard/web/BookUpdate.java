package co.book.bookboard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.BookVO;
import co.book.bookboard.dao.BookBoardDao;
import co.book.common.Service;

public class BookUpdate implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		BookBoardDao dao = new BookBoardDao();
		BookVO vo = new BookVO();
		
		vo.setBookName(request.getParameter("name"));
		vo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		vo.setbCount(Integer.parseInt(request.getParameter("count")));
		vo.setBookCode(request.getParameter("code"));
		
		String viewPage = null;
		
		int n = dao.update(vo);
		
		if(n != 0) {
			viewPage = "bookList.do";
		} else {
			String msg = "실패입니다.";
			request.setAttribute("msg", msg);
			viewPage = "error1";
		}

		
		return viewPage;
		
		
	}

}
