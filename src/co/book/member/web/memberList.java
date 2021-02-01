package co.book.member.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.VO.MemberVO;
import co.book.common.Service;
import co.book.dao.MemberDAO;

public class memberList implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO dao = new MemberDAO();
		
	
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		list = dao.selectList();
		
		request.setAttribute("list", list);
		
		return "member/memberList";
	}

}
