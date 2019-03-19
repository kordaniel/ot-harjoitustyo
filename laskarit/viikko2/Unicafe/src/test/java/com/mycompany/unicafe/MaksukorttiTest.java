package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(1550);
        assertEquals(2550, kortti.saldo());
    }
    
    @Test
    public void kortiltaVoiOttaaRahaaKunSaldoRiittaa() {
        kortti.otaRahaa(999);
        assertEquals(1, kortti.saldo());
    }
    
    @Test
    public void kortiltaVoiNostaaSaldonNollaksi() {
        kortti.otaRahaa(1000);
        assertEquals(0, kortti.saldo());
    }
    
    @Test
    public void saldoEiMuutuKunYritetaanNostaaSaldonYlittavaa() {
        kortti.otaRahaa(1001);
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void palauttaaTrueKunOtetaanRahaa() {
        assertTrue(kortti.otaRahaa(999));
    }
    
    @Test
    public void palauttaFalseKunEiVoidaNostaaRahaa() {
        assertFalse(kortti.otaRahaa(1001));
    }
    
}
