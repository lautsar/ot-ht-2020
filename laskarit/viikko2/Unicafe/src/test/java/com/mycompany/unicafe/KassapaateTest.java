package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void konstruktoriAsettaaMaukkaatOikein() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void konstruktoriAsettaaEdullisetOikein() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoEdullinen1() {
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void kateisostoEdullinen2() {
        assertEquals(60, kassa.syoEdullisesti(300));
    }

    @Test
    public void kateisostoEdullinen3() {
        kassa.syoEdullisesti(300);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoEdullinen4() {
        kassa.syoEdullisesti(100);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kateisostoEdullinen5() {
        assertEquals(100, kassa.syoEdullisesti(100));
    }

    @Test
    public void kateisostoEdullinen6() {
        kassa.syoEdullisesti(100);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoMaukas1() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void kateisostoMaukas2() {
        assertEquals(100, kassa.syoMaukkaasti(500));
    }

    @Test
    public void kateisostoMaukas3() {
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoMaukas4() {
        kassa.syoMaukkaasti(100);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kateisostoMaukas5() {
        assertEquals(100, kassa.syoMaukkaasti(100));
    }

    @Test
    public void kateisostoMaukas6() {
        kassa.syoMaukkaasti(100);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttimaksuMaukas1() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void korttimaksuMaukas2() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void korttimaksuMaukas3() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttimaksuMaukas4() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void korttimaksuMaukas5() {
        Maksukortti kortti = new Maksukortti(100);
        assertFalse(kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void korttimaksuMaukas6() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.syoMaukkaasti(kortti);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttimaksuMaukas7() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void korttimaksuEdullinen1() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.syoEdullisesti(kortti);
        assertEquals(260, kortti.saldo());
    }

    @Test
    public void korttimaksuEdullinen2() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(kassa.syoEdullisesti(kortti));
    }

    @Test
    public void korttimaksuEdullinen3() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttimaksuEdullinen4() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.syoEdullisesti(kortti);
        assertEquals(100, kortti.saldo());
    }

    @Test
    public void korttimaksuEdullinen5() {
        Maksukortti kortti = new Maksukortti(100);
        assertFalse(kassa.syoEdullisesti(kortti));
    }

    @Test
    public void korttimaksuEdullinen6() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.syoEdullisesti(kortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttimaksuEdullinen7() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kortinLatausKasvattaaKassaa() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(100500, kassa.kassassaRahaa());
    }

    @Test
    public void kortinLatausKasvattaaSaldoa() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void negatiivinenLatausEiKasvataSaldoa() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.lataaRahaaKortille(kortti, -500);
        assertEquals(500, kortti.saldo());
    }

}
