package kr.mem.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
import kr.mem.pojo.Controller;
import kr.mem.pojo.MemberDeleteController;
import kr.mem.pojo.MemberInsertController;
import kr.mem.pojo.MemberInsertFormController;
import kr.mem.pojo.MemberListController;
import sun.security.provider.certpath.ResponderId;

public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		
		//1. 어떤 요청인지 파악하는 작업 -> *.do?
		String reqUrl = request.getRequestURI();
//		System.out.println(reqUrl);
		String ctxPath = request.getContextPath();
//		System.out.println(ctxPath); >> contextpath만 찾아주는
		//2. 클라이언트가 요청한 명령
		String command = reqUrl.substring(ctxPath.length());
		System.out.println(command);
		// 각 요청에 따라 처리하기
		Controller controller= null;
		String nextView = null;
		//1. 변수생성
		HandlerMapping mappings = new HandlerMapping(); 
		//이걸 생성하는 동시에 put으로 해당 pojo와 view url값을 모두 넣어주게됨
		
		//command에 요청값이 있으니 getController메소드로 받아서 Controller반환
		controller= mappings.getController(command);
		//Controller로 받아서 나온 주소값을 nextView(보여줄 페이지주소)
		nextView = controller.requestHandle(request, response);
		
		
		//<HandlerMapping부분 >
		//===============================================================
//		if(command.equals("/list.do")) {
//		controller = new MemberListController();
//		nextView = controller.requestHandle(request, response);
//		//핸들러 매핑 >> 운전사가 핸들ㄹ
//			 
//		}else if(command.equals("/insert.do")) {
//			
//		controller = new MemberInsertController();//객체생성
//		nextView = controller.requestHandle(request, response);
//			
//		}else if(command.equals("/insertForm.do")) {
////			response.sendRedirect("member/Member.html");
//			controller = new MemberInsertFormController();
//			nextView = controller.requestHandle(request, response);
//		//url경로 왔다갔다 없이
//		}else if(command.equals("/delete.do")) {
//			
//			controller=new MemberDeleteController();
//			nextView = controller.requestHandle(request, response);
//		
//		}
		//===================================================
		
		
		
		
		
		
		
		if(nextView!=null) {
			//view page로 연동하는 부분
			if(nextView.indexOf("redirect:")!=-1) { //indexOf
				String[] sp= nextView.split(":"); //sp[0] = redirect:, sp[1] = :~
				response.sendRedirect(sp[1]);
			}else {
				RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/views/"+nextView);
				rd.forward(request, response);
			}
		}
		
		
		
		

	}

}
