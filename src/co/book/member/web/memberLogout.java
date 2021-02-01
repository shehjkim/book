package co.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.book.common.Service;

public class memberLogout implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		request.setAttribute("memberId", memberId);
		session.invalidate();
		
		return "member/Logout";
	}

}
