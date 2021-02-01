package co.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.common.Service;

public class memberJoinForm implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		return "member/memberJoinForm";
	}

}
