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
			throws ServletException, IOException { //interface�� �޼ҵ� �̸� ������ ���� �߻�Ŭ����
			//���� ���� �������̵�(������)�� ���ְ�
		String cpath = request.getContextPath();
		MemberDAO dao = new MemberDAO(); //�ʿ��� ��� DAO���� �ҷ��������� ����
		ArrayList<MemberVO> list = dao.memberAllList(); //��� 
		//��ü ���ε�
		request.setAttribute("list",list); //��ü ���ε�
		return "member/memberList.jsp";//���� �������� �ּ� �˷��ֱ� 
	}
	
}
