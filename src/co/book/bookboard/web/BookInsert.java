package co.book.bookboard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.BookVO;
import co.book.bookboard.dao.BookBoardDao;
import co.book.common.Service;

public class BookInsert implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		BookBoardDao dao = new BookBoardDao();
		BookVO vo = new BookVO();
		
		vo.setBookCode(request.getParameter("no"));
		vo.setBookName(request.getParameter("name"));
		
		int n = dao.insert(vo);
		String viewPage = null;
		
		if(n!=0) {
			viewPage = "bookList.do";
		} else {
			String message = "입력에 실패하였습니다.";
			request.setAttribute("msg", message);
			viewPage = "";
			
			
			
		}
		
		return viewPage;
	}

}
