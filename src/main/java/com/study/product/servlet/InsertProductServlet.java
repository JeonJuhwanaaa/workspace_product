package com.study.product.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.study.product.dao.ProductDao;
import com.study.product.dto.InsertProductReqDto;
import com.study.product.service.ProductService;
import com.study.product.utils.RequestUtil;
import com.study.product.utils.ResponseEntity;


@WebServlet("/product")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService;

    public InsertProductServlet() {
        super();
        productService = ProductService.getInstance();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InsertProductReqDto reqDto = RequestUtil.convertJsonData(request, InsertProductReqDto.class);
		
		// 중복이 됐는지 확인하고 중복이면 if문 실행
		if(productService.isDuplicatedProductName(reqDto.getProductName())) {
			
			Map<String, Object> responseMap = new HashMap<>();
			responseMap.put("errorMessage", "이미 등록된 상품명입니다.");
			
			ResponseEntity.ofJson(response, 400, responseMap);
			return;
		}
		
		// 중복이 아니라면 실행
		ResponseEntity.ofJson(response, 201, productService.addProduct(reqDto));
		
	}
	
}
		
//		System.out.println(reqDto.getProductName());
//		System.out.println(reqDto.getProductPrice());
//		System.out.println(reqDto.getProductSize());
//		
//		ProductDao productDao = ProductDao.getInstance();
//		Product findProduct = productDao.findProductByName(product.getName());
//		
//		
//		if(findProduct != null) {
//			Map<String, Object> errorMap = new HashMap<>();
//			errorMap.put("errorMessage", "이미 등록된 상품입니다.");
//			
//			response.setStatus(400);
//			response.setContentType("application/json");
//			response.getWriter().println(gson.toJson(errorMap));
//			return;
//		}
//
//		int successCount = productDao.saveProduct(product);
//		
//		Map<String, Object> responseMap = new HashMap<>();
//		responseMap.put("status", 201);
//		responseMap.put("data", "응답데이터");
//		responseMap.put("successCount", successCount);
//		
//		response.setStatus(201);
//		response.setContentType("application/json");
//		
//		PrintWriter witer = response.getWriter();
//		witer.println(gson.toJson(responseMap));
//		
//		}
