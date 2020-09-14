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
		
		//1. � ��û���� �ľ��ϴ� �۾� -> *.do?
		String reqUrl = request.getRequestURI();
//		System.out.println(reqUrl);
		String ctxPath = request.getContextPath();
//		System.out.println(ctxPath); >> contextpath�� ã���ִ�
		//2. Ŭ���̾�Ʈ�� ��û�� ���
		String command = reqUrl.substring(ctxPath.length());
		System.out.println(command);
		// �� ��û�� ���� ó���ϱ�
		Controller controller= null;
		String nextView = null;
		//1. ��������
		HandlerMapping mappings = new HandlerMapping(); 
		//�̰� �����ϴ� ���ÿ� put���� �ش� pojo�� view url���� ��� �־��ְԵ�
		
		//command�� ��û���� ������ getController�޼ҵ�� �޾Ƽ� Controller��ȯ
		controller= mappings.getController(command);
		//Controller�� �޾Ƽ� ���� �ּҰ��� nextView(������ �������ּ�)
		nextView = controller.requestHandle(request, response);
		
		
		//<HandlerMapping�κ� >
		//===============================================================
//		if(command.equals("/list.do")) {
//		controller = new MemberListController();
//		nextView = controller.requestHandle(request, response);
//		//�ڵ鷯 ���� >> �����簡 �ڵ餩
//			 
//		}else if(command.equals("/insert.do")) {
//			
//		controller = new MemberInsertController();//��ü����
//		nextView = controller.requestHandle(request, response);
//			
//		}else if(command.equals("/insertForm.do")) {
////			response.sendRedirect("member/Member.html");
//			controller = new MemberInsertFormController();
//			nextView = controller.requestHandle(request, response);
//		//url��� �Դٰ��� ����
//		}else if(command.equals("/delete.do")) {
//			
//			controller=new MemberDeleteController();
//			nextView = controller.requestHandle(request, response);
//		
//		}
		//===================================================
		
		
		
		
		
		
		
		if(nextView!=null) {
			//view page�� �����ϴ� �κ�
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
