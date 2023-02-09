package com.iu.home.product;

import java.util.List;

public class ProductService {
	private ProductDAO productDAO;
 // 여기서만 쓰세요~~~(이 클래스 내에서만 사용 가능 멤버변수)
//	productSerivce는 productDAO에 의존 (dependency Injection)
	
	
//	private ProductDAO productDAO = new ProductDAO();
	//-> 결합도가 강하다 - 같이 생성되고 같이 소멸됨.
//	//멤버변수 초기화 방법 4번 - object와 class(instance 블럭)
//	{
//		this.productDAO = new ProductDAO();
//	}//초기화블럭
	
	//멤버변수 초기화 방법 3번 - object와 class
	public ProductService() {
		this.productDAO = new ProductDAO();
		
	}//생성자 - constructor
	//결합도가 약하다
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}//setter
	
	public int setAddProduct(ProductDTO productDTO, List<Product_OptionDTO> ar ) throws Exception{
		//product, option
		Long productNum=productDAO.getpProductNum();
		productDTO.setPRODUCTNUM(productNum);
		int result = productDAO.setAddProduct(productDTO);
		for(Product_OptionDTO product_OptionDTO : ar) {
			product_OptionDTO.setPRODUCTNUM(productNum);
			result = productDAO.setAddProductOption(product_OptionDTO);
		}
		return result;
	}

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
