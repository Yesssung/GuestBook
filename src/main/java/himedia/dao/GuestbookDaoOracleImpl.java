package himedia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import himedia.vo.GuestbookVo;

public class GuestbookDaoOracleImpl implements GuestbookDao {
	private String dbuser;
	private String dbpass;
	
	public GuestbookDaoOracleImpl(String dbuser, String dbpass) {
		super();
		this.dbuser = dbuser;
		this.dbpass = dbpass;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public List<GuestbookVo> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<GuestbookVo> list = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM guestbook";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long no = rs.getLong("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String content = rs.getString("content");
				Date regdate = rs.getDate("reg_date");
				
				GuestbookVo vo = new GuestbookVo(no, name, password, content, regdate);
			
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean insert(GuestbookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertedCount = 0;
		
		try {
		conn = getConnection();
		String sql = "INSERT INTO guestbook (no, name, password, content, regdate) VALUES(seq_guestbook_pk.nextval, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getContent());
		
		insertedCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 1 == insertedCount;
	}

	@Override
	public boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM guestbook WHERE no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,  no);
			
			deletedCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 1 == deletedCount;
	}
	
	
	
}
