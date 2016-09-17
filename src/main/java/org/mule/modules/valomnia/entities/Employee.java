/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is Licensed under the Apache License, Version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Other license terms have been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.valomnia.entities;

public class Employee {

	private String lastName;

	private String managerReference;

	private String avatar;

	private String firstName;

	private String employeeGroupReference;

	private String reference;

	private String mobile;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getManagerReference() {
		return managerReference;
	}

	public void setManagerReference(String managerReference) {
		this.managerReference = managerReference;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmployeeGroupReference() {
		return employeeGroupReference;
	}

	public void setEmployeeGroupReference(String employeeGroupReference) {
		this.employeeGroupReference = employeeGroupReference;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}