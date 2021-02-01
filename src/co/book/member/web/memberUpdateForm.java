package co.book.member.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.MemberVO;
import co.book.common.Service;
import co.book.dao.MemberDAO;

public class memberUpdateForm implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
				
		vo.setMemberId(request.getParameter("memberId"));

		
		vo = dao.select(vo);
		
		request.setAttribute("vo", vo);
		String viewPage = "member/memberUpdateForm";

		return viewPage;
	}

}
