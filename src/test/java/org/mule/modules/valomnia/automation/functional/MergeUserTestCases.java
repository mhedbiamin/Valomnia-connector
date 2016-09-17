/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.User;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class MergeUserTestCases extends AbstractTestCase<ValomniaConnector> {

	public MergeUserTestCases() {
		super(ValomniaConnector.class);
	}

	@Test
	public void verify() {
		java.lang.String expected1 = "Success Updated";
		java.lang.String expected2 = "Success created";
		User obj = new User();

		boolean exist = false;

		List<User> list = null;

		try {
			list = getConnector().findUsers();
		} catch (Exception e) {

			e.printStackTrace();
		}

		for (User user : list) {
			if (user.getEmail().equals("Test@valomnia.com"))

				exist = true;
		}

		obj.setEmail("Test@valomnia.com");
		obj.setEmployeeReference("ref test Employee");
		obj.setEnabled("FALSE");

		if (exist)
			assertEquals(getConnector().mergeUser(obj), expected1);
		else
			assertEquals(getConnector().mergeUser(obj), expected2);
	}

	

	@Test
	public void verifyUserSaved() {

		List<User> list = null;
		boolean exist = false;
		User obj = null;
		list = getConnector().findUsers();

		for (User user : list) {
			if (user.getEmployeeReference().equals("ref test Employee"))
			{    obj=user;
				exist = true;
			}
		}
		assertTrue(exist);
		/* update the  mail of User */
		obj.setEnabled("TRUE");
		assertEquals(getConnector().mergeUser(obj), "Success Updated");
		list = getConnector().findUsers();
		
		for (User user : list) {
			if (user.getEmployeeReference().equals("ref test Employee"))
			{    obj=user;
				
			}
		}
		
		
		
		assertEquals(obj.getEnabled(), "true");
	}

}