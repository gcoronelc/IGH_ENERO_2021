package com.desarrollasoftware.app.service;

import javax.inject.Named;

@Named
public class AppService {
	
	public int sumar(int n1, int n2) {
		return (n1+n2);
	}

}

