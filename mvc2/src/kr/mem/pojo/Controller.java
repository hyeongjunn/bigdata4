package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	
	//FrontController가 할일을 POJO들이 대신 해주는 Method 제작
	
	
	//
	
	
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException;
	//servlet이 하는일돠 동일해야하기때문에 request 와 response를 가져올수 있또록 설정. servlet처럼 설정해줌
	
	
	
	
	
	
}
