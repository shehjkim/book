package co.book.bookboard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.common.Service;

public class BookInsertForm implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		return "bookBoard/bookInsertForm";
	}

}
