/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */


package org.mule.modules.valomnia.automation.functional;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.mule.modules.valomnia.ValomniaConnector;
import org.mule.modules.valomnia.entities.Employee;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeEmployeeTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeEmployeeTestCases() {
        super(ValomniaConnector.class);
    }

    
            @Test
            public void verify() {
                java.lang.String expected1 = "Success Updated";
                java.lang.String expected2 = "Success created";
                Employee obj = new Employee();

                boolean exist = false;

                List<Employee> list = null;
                try {
                    list = getConnector().findEmployees();
                } catch (Exception e) {

                    e.printStackTrace();
                }
                

                for (Employee employee : list)
                {
                    if (employee.getReference()
                            .equals("ref test Employee"))
                        exist = true;
                }
                obj.setFirstName("test Item");
                
                obj.setReference("ref test Employee");
                obj.setFirstName("test First Name");

                obj.setLastName("test Last Name");

                if (!exist)
                    assertEquals(getConnector().mergeEmployee(obj), expected2);
                else
                    assertEquals(getConnector().mergeEmployee(obj), expected1);
            }

            @Test
            public void missingReferenceTest() {
                java.lang.String expected = "Reference missing";
               
                Employee obj = new Employee();

                
                obj.setFirstName("test Item");
                obj.setFirstName("test First Name");

                obj.setLastName("test Last Name");

               
                    assertTrue(getConnector().mergeEmployee(obj).contains(expected));
               
            }
            
            
            @Test
            public void verifyEmployeeSaved() {
            	
            	List<Employee> list = null;
            	boolean   exist=false;
                
                    list = getConnector().findEmployees();
                
                for (Employee  employee:list)
                { if ( employee.getReference().equals("ref test Employee"))
                    exist=true;
                }
            	assertTrue(exist);
            }


        }       

