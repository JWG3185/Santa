package com.sendandtake.www.product.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sendandtake.www.product.model.ChartVO;
import com.sendandtake.www.product.service.ProductService;

@Controller
public class ChartController {

	@Autowired
	ProductService productService;

	@GetMapping("/chartTest")
	String chart() {

		int pNo = 1;

		List<ChartVO> chartList = productService.selectXyList(pNo);

		
		List<ChartVO> SList = new ArrayList<ChartVO>(); 
		List<ChartVO> AList = new ArrayList<ChartVO>(); 
		List<ChartVO> BList = new ArrayList<ChartVO>();
		

		for (ChartVO cl : chartList) {

			
			 if (cl.getGrade().equals("S")) { 
			 System.out.println(cl.getGrade());
			 
			 SList.add(cl);
			 
			 } else if (cl.getGrade().equals("A")) {
			 
			 AList.add(cl);
			 
			 } else {
			 
			 BList.add(cl);
			 
			 }
		}
		//Map<String, List<ChartVO>> = new HashMap<String, List<ChartVO>>();
		return "chart";
	}

}
