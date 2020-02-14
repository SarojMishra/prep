package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeList;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

	@Mock
	private RestTemplate restTemplate;

	@Autowired
	private MockMvc mockMvc;
	private MockRestServiceServer mockServer;

	@Before
	public void init() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void main() throws Exception {

		Employee emp = new Employee();
		emp.setId("1");
		emp.setEmployee_name("saroj");
		emp.setEmployee_salary("100");
		emp.setEmployee_age("30");
		emp.setProfile_image("image");
		Employee emp1 = new Employee();
		emp1.setId("2");
		emp1.setEmployee_name("saroj1");
		emp1.setEmployee_salary("1001");
		emp1.setEmployee_age("301");
		emp1.setProfile_image("image1");

		EmployeeList empList = new EmployeeList();
		empList.setStatus("Success");
		Employee[] employees = new Employee[2];
		employees[0] = emp;
		employees[1] = emp1;
		empList.setEmployees(employees);

		ResultActions resultActions = mockMvc.perform(get("/employees")).andExpect(status().isOk())
				.andExpect(view().name("welcome"));
				//.andExpect(12,empList.getEmployees().length));
			//	.andExpect(model().attribute("employees", equalTo(empList.getEmployees())));

		MvcResult mvcResult = resultActions.andReturn();
		ModelAndView mv = mvcResult.getModelAndView();

	}
//	@Test
//	public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
//		
//		Mockito.when(restTemplate.getForObject("http://localhost:8080/employees", EmployeeList.class))
//				.thenReturn(empList);
//		Employee[] es = empList.getEmployees();
//		Assert.assertEquals("Success",empList.getStatus()); 
////		Assert.assertEquals(2,empList.getEmployees().length); 
//		Assert.assertEquals("saroj",es[0].getEmployee_name()); 
//		Assert.assertEquals("saroj1",es[1].getEmployee_name()); 
//	}
}
