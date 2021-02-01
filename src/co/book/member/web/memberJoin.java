package co.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.MemberVO;
import co.book.common.Service;
import co.book.dao.MemberDAO;

public class memberJoin implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
	
		int n = dao.insert(vo);
		String viewPage= null;
		
		request.setAttribute("vo", vo);
		if(n != 0) {
			viewPage = "member/memberJoinSuccess";
		}else {
			viewPage = "member/memberJoinFail";
		}
				
		return viewPage;
	}

}
