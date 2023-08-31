package com.example.filters;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter  {

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		System.out.println("-----------In Route Filter- Method-------------");
		
		return null;
	}

	@Override
	public String filterType() {
		
		return "route";
	}

	@Override
	public int filterOrder() {
		
		return 0;
	}

}
