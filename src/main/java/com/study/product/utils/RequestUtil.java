package com.study.product.utils;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.study.product.dto.InsertProductReqDto;

public class RequestUtil {
		
	public static String getJsonta(HttpServletRequest request) throws IOException{
		
		String requestJsonData = null;
		
		StringBuilder builder = new StringBuilder();
		
		BufferedReader reader = request.getReader();
		
		String redLineData = null;
		
		
		while((redLineData = reader.readLine()) != null) {
			builder.append(redLineData);
		}
		
		requestJsonData = builder.toString();
		
		return requestJsonData;
	}
	
	public static <T> T convertJsonData(HttpServletRequest request, Class<T> classOfT) throws IOException {
		
		String requestJsonData = null;
		
		StringBuilder builder = new StringBuilder();
		
		BufferedReader reader = request.getReader();
		
		String redLineData = null;
		
		
		while((redLineData = reader.readLine()) != null) {
			builder.append(redLineData);
		}
		
		requestJsonData = builder.toString();
		
		Gson gson = new Gson();

		return gson.fromJson(requestJsonData, classOfT);
	}
}
