package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			MemberDAO dao = new MemberDAO();
			
			String cpath =request.getContextPath();
			int num= Integer.parseInt(request.getParameter("num"));
			String addr = request.getParameter("addr");
		    String phone = request.getParameter("phone");
			//3개를 넘겨야지 
		    MemberVO vo = new MemberVO();
		   //3개를 묶어 보쟈 
		    vo.setNum(num);
	        vo.setPhone(phone);
	        vo.setAddr(addr);
	        
			int cnt = dao.memberUpdate(vo);
			
			String page = null;
			if(cnt>0) {
				page = "redirect:"+cpath+"/list.do";
				
			}else {
				
				throw new ServletException("error");
			}
			
			
			
		
		return page;
	}
}
