package co.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.common.Service;
import co.book.dao.MemberDAO;

public class idCheck implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("memberId");
		
		boolean bool = dao.IsidCheck(id);
		String message = null;
		
		if(bool) {
			message = id + "는 사용할 수 있습니다. ";
		}else {
			message = id + "는 사용할 수 없습니다. ";
		}
		
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		
		return "member/idCheck";
	}

}
