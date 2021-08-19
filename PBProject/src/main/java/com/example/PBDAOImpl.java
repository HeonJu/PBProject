package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PBDAOImpl implements PBDAO {
	
	
   private Connection getConnection() throws SQLException {
      Connection conn = null;
      
      try {
         // 드라이버 로드
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // Connection 가져오기
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", // DBURL
               "C##BITUSER", // DB User
               "bituser"); // DB Pass
      } catch (ClassNotFoundException e) {
         System.err.println("드라이버 로드 실패!");
         e.printStackTrace();
      }
      
      return conn;
   }

   @Override
   public List<PBVO> getList() {
      List<PBVO> list = new ArrayList<>();
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      try {
         conn = getConnection();
         stmt = conn.createStatement();
         String sql = "SELECT name, hp, tel \" + \" FROM phonebook";
         rs = stmt.executeQuery(sql);
         while (rs.next()) {
            // 데이터 받기
            String name = rs.getString(1);
            String hp= rs.getString(2);
            String tel = rs.getString(3);
            // VO 객체 생성
            PBVO vo = new PBVO();
            vo.setName(name);
            vo.setHp(hp);
            vo.setTel(tel);
            // 리스트에 추가
            list.add(vo);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         // 자원 정리
         try {
            rs.close();
            stmt.close();
            conn.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      return list;
      
   }

  
   
   @Override
	public int insert(PBVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PBVO> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}


