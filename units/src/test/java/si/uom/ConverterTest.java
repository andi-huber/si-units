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

import static org.junit.Assert.*;

import javax.measure.Quantity;
import javax.measure.quantity.Angle;

import org.junit.Test;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;


public class ConverterTest {

  @Test
  public void testAngleConverter() {
    Quantity<Angle> sut = Quantities.getQuantity(1, NonSI.DEGREE_ANGLE).to(Units.RADIAN);
    assertNotNull(sut);
    assertEquals(Units.RADIAN, sut.getUnit());
    assertEquals(0.017453292519943295d, sut.getValue().doubleValue(), 1E-12);
  }

  @Test
  public void testAngleConverterOpposite() {
    Quantity<Angle> sut = Quantities.getQuantity(1d, Units.RADIAN).to(NonSI.DEGREE_ANGLE);
    assertNotNull(sut);
    assertEquals(NonSI.DEGREE_ANGLE, sut.getUnit());
    assertEquals(57.29577951308232d, sut.getValue().doubleValue(), 1E-12);
  }
}
