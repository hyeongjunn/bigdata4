package kr.mem.model;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO { //각종 수행 로직들을 모아놨다 값은 VO에서 받아오면 됨. 

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	// 다른 DB로 컴파일

	// 초기화 블럭
	static { // 객체를 실행할때 한번 실행됨?
		try { // DriverManager
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";

		try {
			conn = DriverManager.getConnection(url, user, password); // DriverManager는 모두 static으로 이루어짐.

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	} //여기까지는 동적로딩을 위한 JDBC연동을 위한 것들 

	public int memberInsert(MemberVO vo) { // 인터페이스를 만들고 구현을하는순 필요한 값듣ㄹ만 불러와! 그럴려면 맞는 생성자가 필요하겠지 

		conn = getConnection(); //우선 동적로딩 수행하고 
		// MyBatis >> DB Framework
		String sql = "INSERT INTO tblmem values (seq_num.nextval,?,?,?,?,?)"; // SQL문 작성 >> 우선 필요한거 넣어주기 
		int cnt = -1;// -1의 의미는 그냥 실패의 의미로 종종 쓰임.

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getPhone());
			psmt.setString(3, vo.getAddr());
			psmt.setDouble(4, vo.getLat());
			psmt.setDouble(5, vo.getLng());
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();// pre compile
		}
			// 컴파일 완료

		return cnt;
	}


	public ArrayList<MemberVO> memberAllList() { //리스트를 만들때는 그에 맞는 값들을 여러개 뽑아와야하니깐 ArrayList가 적당함 

		ArrayList<MemberVO> list = new ArrayList<MemberVO>(); //새로 생성해서.
		conn = getConnection();
		String sql = "SELECT * from tblmem order by num desc"; //DB에 있는 값들을 불러온다. 
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // cursor

			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String addr = rs.getString("addr");
				Double lat = rs.getDouble("lat");
				Double lng = rs.getDouble("lng");
				MemberVO vo = new MemberVO(num, name, phone, addr, lat, lng); //반복문을 통해서 가져옴.
				list.add(vo); //list에 memberVO생성자 형식으로 넣어주기 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally { //에러가 있건 없건 무조건 한번 실행. 
			dbClose();
		}

		return list;
	}

	
	public int memberDelete(int num) {
		int cnt = 0;
		conn = getConnection();
		String sql = "Delete from tblMem where num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}

	
	public void dbClose() {

		try {
			if (rs != null) {
				rs.close();
			}

			if (psmt != null) {
				psmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public MemberVO memberContent(int num) { 
		
		MemberVO vo = null;
		conn = getConnection();
		String sql = "select * from tblMem where num = ?"; //고유값인 넘버를 이용해 DB에 접근!
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
				if(rs.next()) {
					num = rs.getInt("num");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String addr = rs.getString("addr");
					Double lat = rs.getDouble("lat");
					Double lng = rs.getDouble("lng");
					vo = new MemberVO(num, name, phone, addr, lat, lng);
					
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		return vo; 
		
	}
	
	  public int memberUpdate(MemberVO vo) { //수정할때 쓰는 메소드 
	      conn=getConnection();
	      String SQL="update tblMem set phone=?,addr=? where num=?";
	      int cnt=-1;
	      try {
	      psmt=conn.prepareStatement(SQL);
	      psmt.setString(1, vo.getPhone());
	      psmt.setString(2, vo.getAddr());
	      psmt.setInt(3, vo.getNum());
	      cnt=psmt.executeUpdate();
	   } catch (Exception e) {
	      e.printStackTrace();
	   }finally {
	      dbClose();
	   }
	     return cnt; 
	   }
	
}
