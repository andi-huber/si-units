/*
 * International System of Units (SI)
 * Copyright (c) 2005-2019, Jean-Marie Dautelle, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Units of Measurement nor the names of their contributors may be used to
 *    endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package si.uom;

import java.math.BigDecimal;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class ArithmeticTest {
	
	@Test
	public void _testAdd() {
		Quantity<Mass> kg = Quantities.getQuantity(5d, Units.KILOGRAM);
		Quantity<Mass> p = Quantities.getQuantity(10E30d, SI.UNIFIED_ATOMIC_MASS);
		Quantity<Mass> result = kg.add(p);
		assertEquals(16610.38782d, result.getValue().doubleValue(), 1E-12);
		assertEquals(Units.KILOGRAM, result.getUnit());
	}

	@Test
	public void _testSubtract2() {
		Quantity<Mass> kg = Quantities.getQuantity(5000d, Units.KILOGRAM);
		Quantity<Mass> p = Quantities.getQuantity(1E30d, SI.UNIFIED_ATOMIC_MASS);
		Quantity<Mass> result = kg.subtract(p);
		assertEquals(3339.461218d, result.getValue().doubleValue(), 1E-12);
		assertEquals(Units.KILOGRAM, result.getUnit());
	}
	
//original tests	
//	   @Test
//	    public void testAdd() {
//	        Quantity<Mass> kg = Quantities.getQuantity(5d, Units.KILOGRAM);
//	        Quantity<Mass> p = Quantities.getQuantity(10E30d, SI.UNIFIED_ATOMIC_MASS);
//	        Quantity<Mass> result = kg.add(p);
//	        assertEquals(new BigDecimal("16610.38782"), result.getValue());
//	        assertEquals(Units.KILOGRAM, result.getUnit());
//	    }
//
//	    @Test
//	    public void testSubtract2() {
//	        Quantity<Mass> kg = Quantities.getQuantity(5000d, Units.KILOGRAM);
//	        Quantity<Mass> p = Quantities.getQuantity(1E30d, SI.UNIFIED_ATOMIC_MASS);
//	        Quantity<Mass> result = kg.subtract(p);
//	        assertEquals(new BigDecimal("3339.461218"), result.getValue());
//	        assertEquals(Units.KILOGRAM, result.getUnit());
//	}
}
