package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	
	//FrontController�� ������ POJO���� ��� ���ִ� Method ����
	
	
	//
	
	
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException;
	//servlet�� �ϴ��ϵ� �����ؾ��ϱ⶧���� request �� response�� �����ü� �ֶǷ� ����. servletó�� ��������
	
	
	
	
	
	
}
