package com.sendandtake.www.product.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sendandtake.www.product.model.DealVO;
import com.sendandtake.www.product.model.OrderVO;
import com.sendandtake.www.product.model.ProductVO;
import com.sendandtake.www.product.model.SaleProductVO;
import com.sendandtake.www.product.service.DealService;
import com.sendandtake.www.product.service.ProductService;

@Controller
public class DealController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	DealService dealService;
	
	//상품구매
	@GetMapping("/buy")
	String buy(int pNo, Model model,@SessionAttribute("productVO") ProductVO pvo) {
		
		List<SaleProductVO> priceList = productService.selectPriceList(pNo);
		
		for (SaleProductVO pList : priceList) {
			if(pList.getGrade().equals("S")) {
				model.addAttribute("Sprice", pList.getSalePrice());
			}
			else if(pList.getGrade().equals("A")) {
				model.addAttribute("Aprice", pList.getSalePrice());
			}
			else {
				model.addAttribute("Bprice", pList.getSalePrice());
			}
		}
		
		model.addAttribute("pvo", pvo);
		
		return "product/buy";
	}
	
	//상품구매동의
	@GetMapping("/buycheck")
	String buycheck(String grade, @SessionAttribute("productVO") ProductVO pvo, Model model) {
		
		System.out.println("grade : " + grade);
		
		pvo.setGrade(grade);
		
		model.addAttribute("pvo", pvo);
		
		return "product/buycheck";
	}
	
	//상품구매종류선택
	@GetMapping("/buyinput")
	String buyinput(@SessionAttribute("productVO") ProductVO pvo, Model model) {
		
		List<SaleProductVO> priceList = productService.selectPriceList(pvo.getpNo());
		
		DealVO dvo = dealService.imdSellPrice(pvo);
		
		for (SaleProductVO pList : priceList) {
			if(pList.getGrade().equals(pvo.getGrade())) {
				dvo.setImdBuyPrice(pList.getSalePrice());
			}
		}
		model.addAttribute("dvo", dvo);
		model.addAttribute("pvo", pvo);
		
		return "product/buyinput";
	}
	
	//상품구매 배송/결제
	@GetMapping("/buypay")
	String buypay(DealVO dvo, @SessionAttribute("productVO") ProductVO pvo, Model model) {
		
		model.addAttribute("dvo", dvo);
		model.addAttribute("pvo", pvo);
		return "product/buypay";
	}
	
	//상품구매완료
	@GetMapping("/buycomplete")
	String buycomplete(@SessionAttribute("productVO") ProductVO pvo, OrderVO ovo, Model model) {
		model.addAttribute("ovo", ovo);
		model.addAttribute("pvo", pvo);
		return "product/buycomplete";
	}
	
	//상품판매
	@GetMapping("/sell")
	String sell(int pNo, @SessionAttribute("productVO") ProductVO pvo, Model model) {
		
		pvo.setGrade("S");
		DealVO dvo = dealService.imdSellPrice(pvo);
		model.addAttribute("Sprice", dvo.getImdSellPrice());
		
		pvo.setGrade("A");
		dvo = dealService.imdSellPrice(pvo);
		model.addAttribute("Aprice", dvo.getImdSellPrice());
		
		pvo.setGrade("B");
		dvo = dealService.imdSellPrice(pvo);
		model.addAttribute("Bprice", dvo.getImdSellPrice());
		
		model.addAttribute("pvo", pvo);
		
		return "product/sell";
	}
	//상품판매동의
	@GetMapping("/sellcheck")
	String sellcheck(@SessionAttribute("productVO") ProductVO pvo, Model model) {
		
		model.addAttribute("pvo", pvo);
		
		return "product/sellcheck";
	}
	
	//상품판매 반송/결제
	@GetMapping("/sellpay")
	String sellpay(@SessionAttribute("productVO") ProductVO pvo, Model model) {
		
		model.addAttribute("pvo", pvo);
		
		return "product/sellpay";
	}
	//상품판매신청완료
	@GetMapping("/sellcomplete")
	String sellcomplete(@SessionAttribute("productVO") ProductVO pvo, OrderVO ovo, Model model) {
		
		model.addAttribute("pvo", pvo);
		model.addAttribute("ovo", ovo);
		
		return "product/sellcomplete";
	}
	
}
