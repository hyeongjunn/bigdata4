package kr.mem.pojo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;

public class MemberListController implements Controller {
	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { //interface는 메소드 이름 통일을 위한 추상클래스
			//따라서 먼저 오버라이딩(재정의)를 해주고
		String cpath = request.getContextPath();
		MemberDAO dao = new MemberDAO(); //필요한 기능 DAO에서 불러오기위해 생성
		ArrayList<MemberVO> list = dao.memberAllList(); //기능 
		//객체 바인딩
		request.setAttribute("list",list); //객체 바인딩
		return "member/memberList.jsp";//어디로 보낼건지 주소 알려주기 
	}
	
}
