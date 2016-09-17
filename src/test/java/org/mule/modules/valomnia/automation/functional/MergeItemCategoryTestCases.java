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
import org.mule.modules.valomnia.entities.ItemCategory;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;


public class MergeItemCategoryTestCases extends AbstractTestCase<ValomniaConnector> {

    public MergeItemCategoryTestCases() {
        super(ValomniaConnector.class);
    }

    @Test
    public void verify() {
        java.lang.String expected1 = "Success Updated";
        java.lang.String expected2 = "Success created";
        ItemCategory obj = new ItemCategory();

        boolean exist = false;

        List<ItemCategory> list = null;
        try {
            list = getConnector().findItemsCategory();
        } catch (Exception e) {

            e.printStackTrace();
        }
       

        for (ItemCategory itemCategory : list)
        {
            if (itemCategory.getReference()
                    .equals("ref test ItemCategory"))
                exist = true;
        }
        obj.setName("test ItemCategory");
        
        obj.setReference("ref test ItemCategory");
       

        

        if (!exist)
            assertEquals(getConnector().mergeItemCategory(obj), expected2);
        else
            assertEquals(getConnector().mergeItemCategory(obj), expected1);
    }
    @Test
	public void missingReferenceTest() {

		java.lang.String expected = "Reference missing";

		ItemCategory obj = new ItemCategory();
		obj.setName("test ItemCategory");
		


		String apiResponse = getConnector().mergeItemCategory(obj);
		assertTrue(apiResponse.contains(expected));
	}
    public void missingNameTest() {

		java.lang.String expected = "name required";

		ItemCategory obj = new ItemCategory();

        obj.setReference("ref test ItemCategory");
		


		String apiResponse = getConnector().mergeItemCategory(obj);
		assertTrue(apiResponse.contains(expected));
	}
    @Test
    public void verifyItemCategorySaved() {
    	
    	List<ItemCategory> list = null;
    	boolean   exist=false;
        
            list = getConnector().findItemsCategory();
        
        for (ItemCategory  itemCategory:list)
        { if ( itemCategory.getReference().equals("ref test ItemCategory"))
            exist=true;
        }
    	assertTrue(exist);
    }

}

