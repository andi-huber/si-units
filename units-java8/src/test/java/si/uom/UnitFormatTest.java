/*
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2015, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
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

import static org.junit.Assert.*;
import static tec.uom.se.unit.MetricPrefix.KILO;
import static tec.uom.se.unit.MetricPrefix.MEGA;
import static tec.uom.se.unit.Units.HERTZ;
import static tec.uom.se.unit.Units.KILOGRAM;
import static tec.uom.se.unit.Units.METRE;
import static tec.uom.se.unit.Units.MINUTE;
import static tec.uom.se.unit.Units.SECOND;

import java.io.IOException;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.ParserException;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Area;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Radioactivity;
import javax.measure.quantity.Speed;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import si.uom.SI;
import si.uom.quantity.MagnetomotiveForce;
import tec.uom.se.format.EBNFUnitFormat;
import tec.uom.se.format.SimpleUnitFormat;
import tec.uom.se.quantity.DefaultQuantityFactory;
import tec.uom.se.unit.Units;

/**
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 *
 */
public class UnitFormatTest {
	@SuppressWarnings("unused")
	private Quantity<Length> sut;

	private EBNFUnitFormat format;
	private SimpleUnitFormat format2;
	
	@Before
	public void init() {
		sut = new DefaultQuantityFactory(Length.class).create(10,
				METRE);
		
		format = EBNFUnitFormat.getInstance();
		format2 = SimpleUnitFormat.getInstance();
		
		format2.label(SI.BEL, "B");
		format2.label(SI.CARAT, "ct");
		format2.label(SI.HECTARE, "Ha");
		format2.label(SI.TONNE, "t");
	}

	@Test
	public void testFormat2() {
		Unit<Speed> kph = SI.KILOMETRES_PER_HOUR;
		assertEquals("kph", kph.toString());
	}
	
	@Test
	public void testFormat4() {
		Unit<Speed> kph = Units.KILOMETRES_PER_HOUR;
		assertEquals("kph", kph.toString());  // TODO i18n vs. no i18n
	}
	
	@Test
	public void testFormat5() {
		Unit<Dimensionless> b = SI.BEL;
		assertEquals("B", b.toString());
		//assertEquals("B", format.format(b));
	}
	
	@Test
	public void testFormat6() {
		Unit<Area> b = SI.HECTARE;
		assertEquals("Ha", b.toString());
	}
	
	@Test
	public void testFormat7() {
		Unit<Mass> c = SI.CARAT;
		
//		assertEquals("ct", format.format(c));
		assertEquals("ct", c.toString());
	}
	
	@Test
	public void testFormat3() {
		Unit<MagnetomotiveForce> at = SI.AMPERE_TURN;
		//assertEquals("At", at.toString());
	}
	
	@Test
	public void testParseSimple() {
		final UnitFormat format = EBNFUnitFormat.getInstance();
		try {
			Unit<?> u = format.parse("s");
			assertEquals("s", u.getSymbol());
			assertEquals(SECOND, u);
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testFormatFromQuantity() {
		final UnitFormat format = EBNFUnitFormat.getInstance();
		final Appendable a = new StringBuilder();
		try {
			format.format(METRE, a);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals(METRE, sut.getUnit());
		assertEquals("m", a.toString());

		final Appendable a2 = new StringBuilder();
		@SuppressWarnings("unchecked")
		Unit<Speed> v = (Unit<Speed>) sut.getUnit().divide(SECOND);
		try {
			format.format(v, a2);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals("m/s", a2.toString());
	}

	@Test
	public void testParseSimple1() {
		final UnitFormat format = EBNFUnitFormat.getInstance();
		try {
			Unit<?> u = format.parse("min");
			// assertEquals("min", u.getSymbol());
			assertEquals(MINUTE, u);
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testParseSimple2() {
		final UnitFormat format = EBNFUnitFormat.getInstance();
		try {
			Unit<?> u = format.parse("m");
			assertEquals("m", u.getSymbol());
			assertEquals(METRE, u);
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testParseSimple3() {
		final UnitFormat format = EBNFUnitFormat.getInstance();
		try {
			Unit<?> u = format.parse("kg");
			assertEquals("kg", u.getSymbol());
			assertEquals(KILOGRAM, u);
		} catch (ParserException e) {
			fail(e.getMessage());
		}
	}
}
