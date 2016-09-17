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
import org.mule.modules.valomnia.entities.TaxList;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;



public class MergeTaxListTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeTaxListTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
      TaxList obj = new TaxList();

        boolean exist = false;

        List<TaxList> list = null;
        
        try {
            list = getConnector().findTaxLists();
        } catch (Exception e) {

            e.printStackTrace();
        }
      

        for (TaxList taxList : list)
        {
            if (taxList.getName().equals("test TaxList")&&taxList.getReference().equals("test TaxList Reference"))
            
                    
                exist = true;
        }
        
        obj.setName("test TaxList");
        obj.setTaxType("Percentage %");
        obj.setReference("test TaxList Reference");
        
       

        

        if (exist)
            assertEquals(getConnector().mergeTaxList(obj), expected1);
        else
            assertEquals(getConnector().mergeTaxList(obj), expected2);
    }
   
	}

	




