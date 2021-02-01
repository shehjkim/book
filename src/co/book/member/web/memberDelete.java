package co.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.book.VO.MemberVO;
import co.book.common.Service;
import co.book.dao.MemberDAO;

public class memberDelete implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));

		int n = dao.delete(vo);
		String viewPage = null;
		
		if(n !=0)
			viewPage = "member/memberList";
		
		return viewPage;
	}

}
