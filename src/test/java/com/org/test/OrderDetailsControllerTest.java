package com.org.test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class OrderDetailsControllerTest {

	@Mock
    private HttpServletRequest httpServletRequest;
	
	OrderDetailsController orderDetailsController;
	
	@Before
	 public void setUp() {
		 orderDetailsController = new OrderDetailsController();
	 }
	 
	 @Test
	 public void shoudContainTruncatedKeyWord(){
		 given(httpServletRequest.getAttribute(anyString())).willReturn("1234567890123456789012345678901234567890");
		 String orderDetailsText=orderDetailsController.getOrderDetails(httpServletRequest);
		 System.out.println(orderDetailsText);
		 Assert.assertTrue(orderDetailsText.contains("truncated"));
	 }
	 
	 @Test
	 public void shoudNotContainTruncatedKeyWord(){
		 given(httpServletRequest.getAttribute(anyString())).willReturn("12345678901234567890");
		 String orderDetailsText=orderDetailsController.getOrderDetails(httpServletRequest);
		 System.out.println(orderDetailsText);
		 Assert.assertFalse(orderDetailsText.contains("truncated"));
	 }
}
