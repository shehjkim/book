package co.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.book.VO.MemberVO;
import co.book.common.Service;
import co.book.dao.MemberDAO;

public class memberLogin implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = dao.login(vo);
		
		String viewPage = null;
		
		request.setAttribute("vo", vo);
		
		if(vo.getMemberAuth() != null ) {
			HttpSession session = request.getSession();	
			session.setAttribute("memberId", vo.getMemberId());	
			session.setAttribute("memberAuth", vo.getMemberAuth());  
			viewPage = "member/loginSuccess";
		}else {
			viewPage = "member/loginFail";
		}
		
		return viewPage;
	}

}
