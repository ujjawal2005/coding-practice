package com.org.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.util.Utility;

@Controller
@RequestMapping("/order")
public class OrderDetailsController {

	private static final String TRUNCATE_KEY="...(truncated)...";
		@RequestMapping(value = "/subscribe",method = RequestMethod.GET)
		public String subscribe(HttpServletRequest request) {
			String orderDetails = getOrderDetails(request);
			String truncatedOrderDetails = Utility.truncate(orderDetails, 25);
			System.out.println(truncatedOrderDetails);
			return truncatedOrderDetails;
		}
		
		public String getOrderDetails(HttpServletRequest request){
			return (String)request.getAttribute("orderDetails");
			//return "1234567890123456789012345678901234567890";
		}
	}
