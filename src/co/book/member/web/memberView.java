package co.book.member.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.MemberVO;
import co.book.common.Service;
import co.book.dao.MemberDAO;

public class memberView implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		vo.setMemberId(request.getParameter("memberId"));
		
		vo = dao.select(vo);
		
		request.setAttribute("vo", vo);
		
		return "member/memberView";
	}

}
