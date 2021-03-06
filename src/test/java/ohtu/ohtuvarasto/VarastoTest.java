package ohtu.ohtuvarasto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    Varasto varasto3;
    Varasto varasto4;
    Varasto varasto5;
    Varasto varasto6;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varasto2 = new Varasto(10, 1);
        varasto3 = new Varasto(10, 11);
        varasto4 = new Varasto(-1);
        varasto5 = new Varasto(-1, 1);
        varasto6 = new Varasto(1, -1);
    }

    @Test
    public void konstruktoriLuoMiinusVaraston1() {
        assertEquals(0, varasto4.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void konstruktoriLuoTuplaVarasto() {
        assertEquals(10, varasto2.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void konstruktoriLuoTuplaVarasto2() {
        assertEquals(1, varasto2.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoMiinusVaraston2() {
        assertEquals(0, varasto5.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void konstruktoriLuoMiinusVaraston3() {
        assertEquals(0, varasto6.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void konstruktoriLuoTaydenVaraston2() {
        assertEquals(10, varasto3.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pit??isi olla sama kun lis??tty m????r??
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pit??isi viel?? olla tilavuus-lis??tt??v?? m????r?? eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void lisaysNolla() {
        varasto2.lisaaVarastoon(-1);

        // vapaata tilaa pit??isi viel?? olla tilavuus-lis??tt??v?? m????r?? eli 2
        assertEquals(9, varasto2.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void varastoTaynna() {
        varasto.lisaaVarastoon(11);


        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
    @Test
    public void ottaminenPalauttaaOikeanMaaran2() {

        double saatuMaara = varasto.otaVarastosta(-2);

        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }
    @Test
    public void ottaminenPalauttaaOikeanMaaran3() {

        double saatuMaara = varasto2.otaVarastosta(2);

        assertEquals(1, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLis????Tilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pit??isi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void stringOikea() {
        String teksti = varasto2.toString();
        assertTrue(teksti.equals("saldo = " + 1.0 + ", viel?? tilaa " + 9.0));
    }

}