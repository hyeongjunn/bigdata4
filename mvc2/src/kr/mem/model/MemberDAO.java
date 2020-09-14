package kr.mem.model;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO { //���� ���� �������� ��Ƴ��� ���� VO���� �޾ƿ��� ��. 

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	// �ٸ� DB�� ������

	// �ʱ�ȭ ��
	static { // ��ü�� �����Ҷ� �ѹ� �����?
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
			conn = DriverManager.getConnection(url, user, password); // DriverManager�� ��� static���� �̷����.

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	} //��������� �����ε��� ���� JDBC������ ���� �͵� 

	public int memberInsert(MemberVO vo) { // �������̽��� ����� �������ϴ¼� �ʿ��� ���褩�� �ҷ���! �׷����� �´� �����ڰ� �ʿ��ϰ��� 

		conn = getConnection(); //�켱 �����ε� �����ϰ� 
		// MyBatis >> DB Framework
		String sql = "INSERT INTO tblmem values (seq_num.nextval,?,?,?,?,?)"; // SQL�� �ۼ� >> �켱 �ʿ��Ѱ� �־��ֱ� 
		int cnt = -1;// -1�� �ǹ̴� �׳� ������ �ǹ̷� ���� ����.

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
			// ������ �Ϸ�

		return cnt;
	}


	public ArrayList<MemberVO> memberAllList() { //����Ʈ�� ���鶧�� �׿� �´� ������ ������ �̾ƿ;��ϴϱ� ArrayList�� ������ 

		ArrayList<MemberVO> list = new ArrayList<MemberVO>(); //���� �����ؼ�.
		conn = getConnection();
		String sql = "SELECT * from tblmem order by num desc"; //DB�� �ִ� ������ �ҷ��´�. 
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
				MemberVO vo = new MemberVO(num, name, phone, addr, lat, lng); //�ݺ����� ���ؼ� ������.
				list.add(vo); //list�� memberVO������ �������� �־��ֱ� 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally { //������ �ְ� ���� ������ �ѹ� ����. 
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
		String sql = "select * from tblMem where num = ?"; //�������� �ѹ��� �̿��� DB�� ����!
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
	
	  public int memberUpdate(MemberVO vo) { //�����Ҷ� ���� �޼ҵ� 
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
