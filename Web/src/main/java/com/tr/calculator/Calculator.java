package com.tr.calculator;

import javax.servlet.http.HttpServletRequest;

public class Calculator {

	public static void calc_trade(HttpServletRequest request) {
		
		String sort = request.getParameter("sort");
		String deal_sort = request.getParameter("deal_sort");
		int trade_price = Integer.parseInt(request.getParameter("trade_price")); 
		double confer = Double.parseDouble(request.getParameter("confer"));	
		double result = 0;
		if (sort.equals("주택")) {
			
		if (trade_price < 50000000) {
			if (confer > 0.6) {
				confer = 0.6;
			}
			
		}else if(trade_price < 200000000) {
			if (confer > 0.5) {
				confer = 0.5;
			}
			
		}else if(trade_price < 900000000) {
			if (confer > 0.4) {
				confer = 0.4;
			}
		}else if(trade_price < 1200000000) {
			if (confer > 0.5) {
				confer = 0.5;
			}
		}else if(trade_price < 1500000000) {
			if (confer > 0.6) {
				confer = 0.6;
			}
		}else {
			if (confer > 0.7) {
				confer = 0.7;
			}
		}
		result = (trade_price * confer)/100;
		if (trade_price < 50000000) {
			if (result > 250000) {
				result = 250000;
			}
		}
		if (trade_price < 200000000) {
			if (result > 800000) {
				result = 800000;
			}
		}
		
		}else if (sort.equals("오피스텔")) {
			if (confer > 0.5) {
				confer = 0.5;
			}
			result = (trade_price * confer)/100;
		}else {
			if (confer > 0.9) {
				confer = 0.9;
			}
			result = (trade_price * confer)/100;
		}
		
		Result rs = new Result(result, trade_price, confer, deal_sort, sort);
		request.setAttribute("result", rs);
		
		
	}

	public static void calc_jm(HttpServletRequest request) {
		String sort = request.getParameter("sort");
		String deal_sort = request.getParameter("deal_sort");
		int price = 0; 
		double confer = Double.parseDouble(request.getParameter("confer"));
		double result = 0;
		if (deal_sort.equals("월세")) {
			int monthly_deposit = Integer.parseInt(request.getParameter("monthly_deposit")); 
			int monthly_price = Integer.parseInt(request.getParameter("monthly_price")); 
			price = monthly_deposit + monthly_price*100;
			if (price < 50000000) {
				price = monthly_deposit + monthly_price*70;
			}
			
		}else {
			price = Integer.parseInt(request.getParameter("jeonse_deposit"));
		}
		
		
		if (sort.equals("주택")) {
			
			if (price < 50000000) {
				if (confer > 0.5) {
					confer = 0.5;
				}
				
			}else if(price < 200000000) {
				if (confer > 0.4) {
					confer = 0.4;
				}
				
			}else if(price < 900000000) {
				if (confer > 0.3) {
					confer = 0.3;
				}
			}else if(price < 1200000000) {
				if (confer > 0.4) {
					confer = 0.4;
				}
			}else if(price < 1500000000) {
				if (confer > 0.5) {
					confer = 0.5;
				}
			}else {
				if (confer > 0.6) {
					confer = 0.6;
				}
			}
			result = (price * confer)/100;
			if (price < 50000000) {
				if (result > 200000) {
					result = 200000;
				}
			}
			if (price < 200000000) {
				if (result > 300000) {
					result = 300000;
				}
			}
			
			}else if (sort.equals("오피스텔")) {
				if (confer > 0.4) {
					confer = 0.4;
				}
				result = (price * confer)/100;
			}else {
				if (confer > 0.9) {
					confer = 0.9;
				}
				result = (price * confer)/100;
			}
		Result rs = new Result(result, price, confer, deal_sort, sort);
		request.setAttribute("result", rs);
		
		
	}

	

}
