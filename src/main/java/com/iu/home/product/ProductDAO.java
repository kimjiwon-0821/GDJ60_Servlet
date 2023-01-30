package com.iu.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.home.util.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class ProductDAO {
	public int setAddProduct(ProductDTO productDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCT VALUES(?,?,?,0.0)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1,productDTO.getPRODUCTNUM());
		st.setString(2,productDTO.getPRODUCTNAME());
		st.setString(3,productDTO.getPRODUCTDETAIL());
		//st.setDouble(3,productDTO.getPRODUCTJUMSU());
		int result = st.executeUpdate();
		DBConnection.disConnection(st, connection);
		return result;
		
	}	
	
	public List<ProductDTO> getProductList() throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		Connection connection= DBConnection.getConnection();
		String sql = "SELECT PRODUCTNUM, PRODUCTNAME, PRODUCTJUMSU FROM PRODUCT ORDER BY PRODUCTJUMSU DESC";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setPRODUCTNUM(rs.getLong("PRODUCTNUM"));
			productDTO.setPRODUCTNAME(rs.getString("PRODUCTNAME"));
			productDTO.setPRODUCTJUMSU(rs.getDouble("PRODUCTJUMSU"));
			ar.add(productDTO);
		}
		DBConnection.disConnection(rs, st, connection);
		return ar;
		
	}
//	----------------------------------------------------------------------
	public int setAddProductOption(Product_OptionDTO product_OptionDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCT_OPTION VALUES(BANK_SEQ.NEXTVAL,?,?,?,?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1,product_OptionDTO.getPRODUCTNUM());
		st.setString(2,product_OptionDTO.getOPTIONNAME());
		st.setLong(3, product_OptionDTO.getOPTIONPRICE());
		st.setLong(4,product_OptionDTO.getJEGO());
		int result = st.executeUpdate();
		DBConnection.disConnection(st, connection);
		return result;
		
		
	}
	public List<Product_OptionDTO> getProduct_OptionList() throws Exception{
		List<Product_OptionDTO> arr = new ArrayList<Product_OptionDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCT_OPTION ";
		PreparedStatement st =connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Product_OptionDTO product_OptionDTO = new Product_OptionDTO();
			product_OptionDTO.setOPTIONNUM(rs.getLong("OPTIONNUM"));
			product_OptionDTO.setPRODUCTNUM(rs.getLong("PRODUCTNUM"));
			arr.add(product_OptionDTO);
		}
		DBConnection.disConnection(rs, st, connection);
		return arr;
	}
//	-------------------------------------------------------------------
	public Long getpProductNum() throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT BANK_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		Long num = rs.getLong(1);
		DBConnection.disConnection(rs, st, connection);
		return num;
	}
	
	
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		try {
			List<Product_OptionDTO> ar = productDAO.getProduct_OptionList();
			System.out.println(ar.size()!=0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
