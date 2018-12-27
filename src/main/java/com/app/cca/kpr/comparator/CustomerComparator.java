package com.app.cca.kpr.comparator;

import java.util.Comparator;

import com.app.cca.kpr.model.Customer;

public class CustomerComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer obj1, Customer obj2) {
		// TODO Auto-generated method stub
		int result=0;
		
		if(obj1.getId() < obj2.getId()) {
			result = -1;
		}if(obj1.getId() > obj2.getId()) {
			result = 1;
		}
		return result;
	}

}
