package co.book.bookboard.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.BookVO;
import co.book.bookboard.dao.BookBoardDao;
import co.book.common.Service;

public class BookList implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		BookBoardDao dao = new BookBoardDao();
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		list = dao.selectList();
		request.setAttribute("list", list);
		
		String viewPage = "bookBoard/bookList";
		
		return viewPage;
	}

}
