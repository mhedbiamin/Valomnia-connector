/**
 * (C) 2016 ApptivIT �. This software is protected by international copyright. Any use of this software is subject to Valomnia User account
 * through a sales contract between you and ApptivIT �. If such a user account Valomnia is not in place,
 * you can not use the software.
 * a copy of Valomnia GENERAL TERMS AND CONDITIONS has-been included with this distribution in the file LICENSE.md
 */

package org.mule.modules.valomnia.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.Field;

import org.junit.Test;
import org.mule.modules.valomnia.entities.Price;

public class PriceTest {

	@Test
	public void testSetterPriceItemReference_setsProperly() throws NoSuchFieldException, IllegalAccessException {

		Price price = new Price();

		price.setItemReference("test item reference");

		final Field field = price.getClass().getDeclaredField("itemReference");
		field.setAccessible(true);
		assertEquals(field.get(price), "test item reference");
	}

	@Test
	public void testSetterPriceUnitRefrence_setsProperly() throws NoSuchFieldException, IllegalAccessException {
		Price price = new Price();

		price.setUnitReference("test Unit Reference");

		Field field = price.getClass().getDeclaredField("unitReference");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(price), "test Unit Reference");
	}

	@Test
	public void testGetterPriceItemReference_getsValue() throws NoSuchFieldException, IllegalAccessException {
		final Price price = new Price();

		Field field = price.getClass().getDeclaredField("itemReference");
		field.setAccessible(true);
		field.set(price, "test item reference");

		final String result = price.getItemReference();

		assertEquals("field wasn't retrieved properly", result, "test item reference");
	}

	@Test
	public void testPriceGetters() {

		Price price = new Price();

		price.setItemReference("test item reference");
		price.setUnitReference("test unit reference");
		price.setValue("564");
		price.setPriceListReference("price List Reference");
		price.setUnitPrice("unitPrice");

		assertEquals(price.getUnitPrice(), "unitPrice");
		assertEquals(price.getPriceListReference(), "price List Reference");
		assertEquals(price.getValue(), "564");

	}

	@Test
	public void testPricesAreNotEqual() {
		Price price = new Price();

		price.setItemReference("test item reference");
		price.setUnitReference("test unit reference");
		price.setValue("564");
		price.setPriceListReference("price List Reference");

		Price price1 = new Price();

		price1.setItemReference("test item reference");
		price1.setUnitReference("test unit reference");
		price1.setValue("564");
		price1.setPriceListReference("price List Reference1");

		assertFalse(price.equals(price1));

	}

}
