package co.book;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.book.common.MainService;
import co.book.common.Service;
import co.book.member.web.idCheck;
import co.book.member.web.memberDelete;
import co.book.member.web.memberJoin;
import co.book.member.web.memberJoinFail;
import co.book.member.web.memberJoinForm;
import co.book.member.web.memberJoinSuccess;
import co.book.member.web.memberList;
import co.book.member.web.memberLogin;
import co.book.member.web.memberLoginForm;
import co.book.member.web.memberLogout;
import co.book.member.web.memberUpdate;
import co.book.member.web.memberUpdateForm;
import co.book.member.web.memberView;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Service> map = new HashMap<String, Service>();

    public FrontController() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainService());
		map.put("/memberJoinForm.do", new memberJoinForm()); //�쉶�썝媛��엯�뤌
		map.put("/memberJoin.do", new memberJoin()); //�쉶�썝媛��엯
		map.put("/idCheck.do",new idCheck()); //以묐났泥댄겕
		map.put("/memberJoinSuccess.do",new memberJoinSuccess()); //�쉶�썝媛��엯�꽦怨�
		map.put("/memberJoinFail.do",new memberJoinFail()); //�쉶�썝媛��엯 �떎�뙣
		map.put("/memberLoginForm.do", new memberLoginForm()); //濡쒓렇�씤 �뤌
		map.put("/memberlogin.do", new memberLogin()); //濡쒓렇�씤
		map.put("/memberLogout.do", new memberLogout()); //濡쒓렇�븘�썐
		map.put("/memberList.do", new memberList()); //�쉶�썝 紐⑸줉
		map.put("/memberView.do", new memberView()); //�쉶�썝 �긽�꽭 �젙蹂�
		map.put("/memberDelete.do", new memberDelete()); //회원삭제
		map.put("/memberUpdateForm.do", new memberUpdateForm()); //회원정보수정폼
		map.put("/memberUpdate.do", new memberUpdate()); //수정완료
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();    //理쒖긽�쐞 寃쎈줈
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());   //�떎�젣 �슂泥��븳 request

		Service service = map.get(path);  //service.java�쓽 service�깮�꽦�옄媛� 諛섑솚?�븯�뒗寃� String, �쟻�젅�븳 command瑜� 李얜뒗 遺�遺�
		String viewPage = service.run(request, response); //�떎�뻾�빐�꽌 寃곌낵瑜� �룎�젮二쇰뒗 �럹�씠吏�?
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" +viewPage +  ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
