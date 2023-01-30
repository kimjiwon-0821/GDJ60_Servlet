package com.iu.home.product;

public class ProductService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPRODUCTNAME("product1");
		productDTO.setPRODUCTDETAIL("detail1");
		
		Product_OptionDTO product_OptionDTO = new Product_OptionDTO();
		product_OptionDTO.setOPTIONNAME("optionName1");
		product_OptionDTO.setOPTIONPRICE(100L);
		product_OptionDTO.setJEGO(10L);
		product_OptionDTO.setPRODUCTNUM(null);
		
		Product_OptionDTO product_OptionDTO2 = new Product_OptionDTO();
		product_OptionDTO2.setOPTIONNAME("optionName2");
		product_OptionDTO2.setOPTIONPRICE(200L);
		product_OptionDTO2.setJEGO(20L);
		product_OptionDTO2.setPRODUCTNUM(null);
		
		try {
			Long num = productDAO.getpProductNum();
			productDTO.setPRODUCTNUM(num);
			int result = productDAO.setAddProduct(productDTO);
			product_OptionDTO.setPRODUCTNUM(num);
			System.out.println(num);
			
			if(result>0) {
				productDAO.setAddProduct(productDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
