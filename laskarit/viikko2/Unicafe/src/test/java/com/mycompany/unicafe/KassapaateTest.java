package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kp;
    Maksukortti mk;
    
    @Before
    public void setUp() {
        kp = new Kassapaate();
        mk = new Maksukortti(500);
    }

    @Test
    public void luotuKassapaateOnOlemassa() {
        assertTrue(kp != null);
    }
    
    @Test
    public void konstruktoriAlustaaSaldonOikeaksi() {
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void myydytEdullisetAlussaNolla() {
        assertEquals(0, kp.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myydyMaukkaatAlussaNolla() {
        assertEquals(0, kp.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void myytyjenEdullisenLkmKasvaa() {
        kp.syoEdullisesti(240);
        assertEquals(1, kp.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myytyEdullinenNostaaSaldoaOikein() {
        kp.syoEdullisesti(245);
        assertEquals(100240, kp.kassassaRahaa());
    }
    
    @Test
    public void myytyjenMaukkaittenLkmKasvaa() {
        kp.syoMaukkaasti(400);
        assertEquals(1, kp.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void myytyMaukasNostaaSaldoaOikein() {
        kp.syoMaukkaasti(405);
        assertEquals(100400, kp.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiPalauttaaOikeinKunTasaraha() {
        assertEquals(0, kp.syoEdullisesti(240));
    }
    
    @Test
    public void syoEdullisestiPalauttaaOikeanMaaran() {
        assertEquals(5, kp.syoEdullisesti(245));
    }
    
    @Test
    public void syoMaukkaastiPalauttaaOikeinKunTasaraha() {
        assertEquals(0, kp.syoMaukkaasti(400));
    }
    
    @Test
    public void syoMaukkaastiPalauttaaOikeanMaaran() {
        assertEquals(5, kp.syoMaukkaasti(405));
    }
    
    @Test
    public void syoEdullisestiPalauttaaRahatKunMaksuEiRiita() {
        assertEquals(239, kp.syoEdullisesti(239));
    }
    
    @Test
    public void syoMaukkaastiPalauttaaRahatKunMaksuEiRiita() {
        assertEquals(399, kp.syoMaukkaasti(399));
    }
    
    @Test
    public void syoEdullisestiEiNostaMyytyjenMaaraaKunMaksuEiRiita() {
        kp.syoEdullisesti(239);
        assertEquals(0, kp.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiEiNostaMyytyjenMaaraaKunMaksuEiRiita() {
        kp.syoMaukkaasti(399);
        assertEquals(0, kp.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiEiMuutaSaldoaKunMaksuEiRiita() {
        kp.syoEdullisesti(239);
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiEiMuutaSaldoaKunMaksuEiRiita() {
        kp.syoMaukkaasti(399);
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiKortillaPalauttaaTrue() {
        Maksukortti mk = new Maksukortti(260);
        assertTrue(kp.syoEdullisesti(mk));
    }
    
    @Test
    public void syoMaukkaastiKortillaPalauttaaTrue() {
        Maksukortti mk = new Maksukortti(400);
        assertTrue(kp.syoMaukkaasti(mk));
    }
    
    @Test
    public void syoEdullisestiVeloittaaKorttiaOikein() {
        kp.syoEdullisesti(mk);
        assertEquals(260, mk.saldo());
    }
    
    @Test
    public void syoMaukkaastiVeloittaaaKorttiaOikein() {
        kp.syoMaukkaasti(mk);
        assertEquals(100, mk.saldo());
    }
    
    @Test
    public void syoEdullisestiKortillaNostaaMyytyjenLkm() {
        kp.syoEdullisesti(mk);
        assertEquals(1, kp.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKortillaNostaaMyytyjenLkm() {
        kp.syoMaukkaasti(mk);
        assertEquals(1, kp.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKortillaEiMuutaKassanRahamaaraa() {
        kp.syoEdullisesti(mk);
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiKortillaEiMuutaKassanRahamaaraa() {
        kp.syoMaukkaasti(mk);
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void syoEdullisestiEiMuutaKortinSaldoaJosSaldoEiRiita() {
        mk = new Maksukortti(239);
        kp.syoEdullisesti(mk);
        assertEquals(239, mk.saldo());
    }
    
    @Test
    public void syoMaukkaastiEiMuutaKortinSaldoaJosSaldoEiRiita() {
        mk = new Maksukortti(399);
        kp.syoMaukkaasti(mk);
        assertEquals(399, mk.saldo());
    }
    
    @Test
    public void syoEdullisestiKortillaPalauttaaFalseJosSaldoEiRiita() {
        mk = new Maksukortti(0);
        assertFalse(kp.syoEdullisesti(mk));
    }
    
    @Test
    public void syoMaukkaastiKortillaPalauttaaFalseJosSaldoEiRiita() {
        mk = new Maksukortti(300);
        assertFalse(kp.syoMaukkaasti(mk));
    }
    
    @Test
    public void syoEdullisestiKortillaEiMuutaMyytyenLkmJosSaldoEiRiita() {
        mk = new Maksukortti(0);
        kp.syoEdullisesti(mk);
        assertEquals(0, kp.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKortillaEiMuutaMyytyjenLkmJosSaldoEiRiita() {
        mk = new Maksukortti(240);
        kp.syoMaukkaasti(mk);
        assertEquals(0, kp.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void lataaRahaaKortilleNostaaKortinSaldoa() {
        kp.lataaRahaaKortille(mk, 300);
        assertEquals(800, mk.saldo());
    }
    
    @Test
    public void lataaRahaaKortilleNegatiivinenMaaraEiMuutaKortinSaldoa() {
        kp.lataaRahaaKortille(mk, -400);
        assertEquals(500, mk.saldo());
    }
    
    @Test
    public void lataaRahaaKortilleNegatiivinenMaaraEiMuutaKassanRahamaaraa() {
        kp.lataaRahaaKortille(mk, -400);
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleNostaaKassanSaldoa() {
        kp.lataaRahaaKortille(mk, 1);
        assertEquals(100001, kp.kassassaRahaa());
    }
}
