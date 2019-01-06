package com.app.cca.kpr.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.cca.kpr.model.CustomerWork;
import com.app.cca.kpr.repository.CustomerRepository;
import com.app.cca.kpr.repository.CustomerWorkRepository;
import com.app.cca.kpr.response.Response;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceTest {

	private CustomerService service;
	
	@MockBean
	private CustomerRepository repositoryMock;
	@MockBean
	private CustomerWorkRepository workRepositoryMock;
	
	@Before
	public void setup() {
		
		System.out.println("In setup ..........................");
		service = new CustomerService();
		
		repositoryMock = mock(CustomerRepository.class);
		workRepositoryMock = mock(CustomerWorkRepository.class);
		System.out.println("In setup 2 ..........................");
		service.setCustomerRepository(repositoryMock);
		service.setCustomeWorkRepository(workRepositoryMock);
	}
	
	/**
	"name": "Pankaj4",
    "gender": "M",
    "birthdate": "2012-04-23T18:25:43.511Z",
    "pancard": "AAAAA3333A",
    "contactno": "1234567890",
    "email": "pankaj@demo.com",
    "address1": "add 1",
    "address2": "add 2",
    "locality": "Pune",
    "pincode": "411014"
    **/
	
	@Test
	public void TestCreateNewCustomer() {
		System.out.println("In TestCreateNewCustomer ..........................");
		
		CustomerWork work = new CustomerWork("Pankaj", "M", new Date(), "AAAAA3333A", 1234567890, 
				"pankaj@demo.com", "add 1", "add 2", "Pune", 411041);
		
		System.out.println("In TestCreateNewCustomer 2 ..........................");
		
			Response response = service.createNewCustomer(work);
			System.out.println("In TestCreateNewCustomer 3 .........................."+response);
			Object[] objArray = response.getErrors();
			
					
			assertEquals(0, objArray.length);			
			
	}
	
}
