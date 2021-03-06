/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */


package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Employee;
import org.mule.modules.valomnia.entities.EmployeeGroup;
import org.mule.modules.valomnia.entities.User;
import org.mule.modules.valomnia.entities.UserAuthority;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class EntitiesTestCases   extends AbstractTestCase<ValomniaConnector> {
	 public EntitiesTestCases() {
	        super(ValomniaConnector.class);
	    }
	
	 @Test
	 public void verify() throws Exception {
		 Employee  employee=new Employee();
		 employee.setFirstName("test first name");
		 employee.setLastName("test LasrtName");
		 employee.setMobile("000986754");
		 employee.setReference("test Employee");
		 
		 User user= new User();
		 user.setEmail("test@test.com");
		 Employee employee1=null;
		 for (Employee  emp :getConnector().findEmployees())
		 {if  (emp.getReference().equals("test Employee"))
		 employee1=emp;
		 }
		 if (employee1==null)
		 { assertNotNull(getConnector().mergeEmployee(employee));}
		user.setEmployeeReference(employee.getReference());
		 
		 assertNotNull( getConnector().mergeUser(user));
		 UserAuthority userAuthority=new UserAuthority();
		 userAuthority.setAuthorityName("test Authority name");
		 userAuthority.setUserEmail("test@test.com");
		 assertNotNull( getConnector().mergeUserAuthority(userAuthority));
		 
		 EmployeeGroup  employeeGroup=new EmployeeGroup();
		 employeeGroup.setName("Test EmployeeGroup");
		 employeeGroup.setReference("Test EmployeeGroup Reference");
		 assertNotNull( getConnector().mergeEmployeeGroup(employeeGroup));
		 
		 employee.setEmployeeGroupReference("Test EmployeeGroup Reference");
		 
		 assertTrue(getConnector().mergeEmployee(employee).equals("Success Updated"));
		 
		 
		 
		
	 }
}
