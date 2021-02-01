package co.book.bookboard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.BookRentalVO;
import co.book.bookboard.dao.BookRentalDao;
import co.book.common.Service;

public class BookRentalList implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		BookRentalDao dao = new BookRentalDao();
		BookRentalVO vo = new BookRentalVO();
		
		vo.setBookCode(request.getParameter("bCode"));
		vo.setMemberId(request.getParameter("mId"));
		
		int n = dao.insert(vo);
		String viewPage = "bookBoard/bookRentalList";
		
		return viewPage;
	}

}
