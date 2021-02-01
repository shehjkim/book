package co.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;

import co.book.VO.MemberVO;
import co.book.common.Service;
import co.book.dao.MemberDAO;

public class memberUpdate implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		vo.setMemberAuth(request.getParameter("memberAuth"));
		
		String viewPage = null;
		
		int n = dao.update(vo);
		
		if(n != 0 ) {
			viewPage ="member/memberList";
		}else {
			String message = "수정하지 못하였습니다. ";
					request.setAttribute("mag", message);
			viewPage ="member/memberUpdateFail";
		}
		
		
		return null;
	}

}
