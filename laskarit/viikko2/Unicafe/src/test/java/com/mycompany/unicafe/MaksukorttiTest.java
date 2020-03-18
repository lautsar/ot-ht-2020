package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void rahanLatausOikein() {
        kortti.lataaRahaa(520);
        assertEquals("saldo: 5.30", kortti.toString());
    }

    @Test
    public void saldoVaheneeKunSaldoa() {
        kortti.lataaRahaa(500);
        kortti.otaRahaa(100);
        assertEquals("saldo: 4.10", kortti.toString());
    }

    @Test
    public void saldoEiVaheneKunEiSaldoa() {
        kortti.otaRahaa(100);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void otaRahaaPalauttaaTrue() {
        kortti.lataaRahaa(500);
        assertTrue(kortti.otaRahaa(100));
    }

    @Test
    public void otaRahaaPalauttaaFalse() {
        assertFalse(kortti.otaRahaa(100));
    }

}
