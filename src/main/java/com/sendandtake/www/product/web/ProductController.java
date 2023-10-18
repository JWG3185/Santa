package com.sendandtake.www.product.web;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.sendandtake.www.main.model.MemberVO;
import com.sendandtake.www.product.model.ProductVO;
import com.sendandtake.www.product.model.ReviewVO;
import com.sendandtake.www.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	//상세페이지
	@GetMapping("/detail.do")
	String detail(int pNo, Model model, ReviewVO rvo) {
		
		//상품 하나 불러오기
		ProductVO productOne = productService.selectProduct(pNo);
		
		model.addAttribute("product", productOne);
		
		//회사명 CompanyName -> ${comName}
		int index = productOne.getpCode().indexOf("_");
		
		String CompanyName = productOne.getpCode().substring(0, index);

		model.addAttribute("comName", CompanyName.toUpperCase());
		
		//리뷰 리스트 불러오기
		List<ReviewVO> rvList = productService.selectReviewList(pNo);
		
		model.addAttribute("rvList", rvList);	
		
		
		return "detail/detail";
	}
	
	
	@ResponseBody
	@PostMapping("/rvSave/ajax")
	Map<String, ReviewVO> rvSave (ReviewVO rvo, @SessionAttribute("loginUser") MemberVO mvo, HttpServletRequest req){
		
		Map<String, ReviewVO> rmap = new HashMap<String, ReviewVO>();
		
		final String webPath = "/resources/upload/";
		
		//상대경로 
		final String folderPath = req.getSession().getServletContext().getRealPath(webPath);
		
		System.out.println("상대경로 : "+ folderPath);
		
		System.out.println(rvo.getpNo());
		
		//로그인 처리(+)
		rvo.setUserNo(mvo.getUserNo());
		rvo.setUserEmail(mvo.getUserEmail());
		
		//첨부파일
		MultipartFile file = rvo.getRvImg();
		
		if(file != null && !file.isEmpty()) {
			
			String filename = file.getOriginalFilename();
			
			//랜덤 파일 이름
			UUID uuid = UUID.randomUUID();
			String[] uuids = uuid.toString().split("-");
			
			String uniquefilename = uuids[0];
			
			//확장자 명
			String fileExtension = filename.substring(filename.lastIndexOf("."), filename.length());
			
			try {
				
				System.out.println(uniquefilename);
				System.out.println(fileExtension);
				
				file.transferTo(new File(folderPath + uniquefilename + fileExtension));
				
				//jsp로 이미지파일 불러오기 위한 준비(+)
				rvo.setRvNewImg(uniquefilename);
				
				rvo.setRvExtn(fileExtension);
				
				productService.insertReview(rvo);
				
				//리뷰 구역 ajax로 띄우기.
				ReviewVO r = productService.selectReview(rvo.getRvNewImg());			
				rmap.put("rOne", r);
				
			} catch (Exception e) {				
				e.printStackTrace();
			}
	
		}
		
		return rmap;
	}
	
	//상품구매
	@GetMapping("/buy.do")
	String buy() {
		return "product/buy";
	}
	
	//상품구매동의
	@GetMapping("/buycheck.do")
	String buycheck() {
		
		
		return "product/buycheck";
	}
	
	//상품구매종류선택
	@GetMapping("/buyinput.do")
	String buyinput() {
		return "product/buyinput";
	}
	
	//상품구매 배송/결제
	@GetMapping("/buypay.do")
	String buypay() {
		return "product/buypay";
	}
	
	//상품구매완료
	@GetMapping("/buycomplete.do")
	String buycomplete() {
		return "product/buycomplete";
	}
	
	//상품판매
	@GetMapping("/sell.do")
	String sell() {
		return "product/sell";
	}
	//상품판매동의
	@GetMapping("/sellcheck.do")
	String sellcheck() {
		return "product/sellcheck";
	}
	
	//상품판매 반송/결제
	@GetMapping("/sellpay.do")
	String sellpay() {
		return "product/sellpay";
	}
	//상품판매신청완료
	@GetMapping("/sellcomplete.do")
	String sellcomplete() {
		return "product/sellcomplete";
	}
	
}
