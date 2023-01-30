package com.iu.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.home.util.DBConnection;

public class MemberDAO {//멤버메소드,인스턴스메소드
	//setAddMember
	public int setAddMember(MemberDTO memberDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql="INSERT INTO MEMBER VALUES (?,BANK_SEQ.NEXTVAL,?,?,?,?,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1,memberDTO.getMEMBER_ID());
		//st.setString(2,memberDTO.getMEMBER_NUM());
		st.setString(2,memberDTO.getMEMBER_PW());
		st.setString(3,memberDTO.getMEMBER_NAME());
		st.setString(4,memberDTO.getMEMBER_ADDRESS());
		st.setString(5,memberDTO.getMEMBER_PHONE());
		st.setString(6,memberDTO.getMEMBER_EMAIL());
		int result = st.executeUpdate();
		DBConnection.disConnection(st, connection);
		return result;
		
	}
	
	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMEMBER_ID("JWJW");
		try {
			int result =memberDAO.setAddMember(memberDTO);
			System.out.println(result==1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
