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

import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Mass;

import org.junit.Ignore;
import org.junit.Test;

import static javax.measure.MetricPrefix.GIGA;
import static javax.measure.MetricPrefix.KILO;
import static javax.measure.MetricPrefix.MEGA;
import static javax.measure.MetricPrefix.NANO;
import static javax.measure.MetricPrefix.PICO;
import static javax.measure.MetricPrefix.YOTTA;
import static javax.measure.MetricPrefix.ZETTA;
import static org.junit.Assert.assertEquals;
import static tech.units.indriya.unit.Units.GRAM;
import static tech.units.indriya.unit.Units.KILOGRAM;
import static tech.units.indriya.unit.Units.METRE;

import tech.units.indriya.function.MultiplyConverter;

/**
 * @author <a href="mailto:werner@uom.si">Werner Keil</a>
 *
 */
public class PrefixTest {
	@Test
	public void testKilo() {
		// TODO how to handle equals for units?
		assertEquals(KILOGRAM.toString(), KILO(GRAM).toString());
	}

	@Test
	public void testMega() {
		Unit<Mass> m1 = MEGA(GRAM);
		assertEquals("Mg", m1.toString()); // Passes in Maven/CI
	}

	@Test
	public void testNano() {
		Unit<Mass> m1 = NANO(GRAM);
		assertEquals("ng", m1.toString());
	}

	@Test
	public void testPico() {
		Unit<Mass> m1 = PICO(KILOGRAM);
		assertEquals("pkg", m1.toString());
	}

	@Test
	@Ignore("Adjust to PowerOfIntConverter")
	public void testBetweenPrefixes() {
		UnitConverter conv = YOTTA(METRE).getConverterTo(ZETTA(METRE));
		assertEquals(conv, MultiplyConverter.ofRational(1000, 1));
	}

	@Test
	@Ignore("Adjust to PowerOfIntConverter")
	public void testBetweenPrefixes2() {
		UnitConverter conv = KILO(METRE).getConverterTo(GIGA(METRE));
		assertEquals(MultiplyConverter.ofRational(1, 1000000), conv);
	}
}
