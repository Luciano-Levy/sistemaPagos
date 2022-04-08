package sistemapagos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sistemapagos.tarjeta.Tarjeta;

public class TarjetaTest {
    
    Tarjeta tarjeta;
    String numero;
    String vencimiento;
    String cardHolder ;
    String marca;

    @BeforeEach
    void before(){
        numero = "01523654798747896L";
        vencimiento = "12/2029";
        cardHolder = "Luciano Levy";
        marca = "AMEX";
        tarjeta = new Tarjeta(numero, vencimiento, cardHolder, marca);
    }

    @Test
    @DisplayName("Creacion")
    void setUp(){
        
        assertInstanceOf(Tarjeta.class,tarjeta);
    }


    @Test
    @DisplayName("Info")
    void testInfo(){
        String[] info = tarjeta.info();
        
        assertEquals(info[0], marca);
        assertEquals(info[1],cardHolder);
        assertEquals(info[2],numero);
        assertEquals(info[3],vencimiento);
    }


    @Test
    @DisplayName("esValida")
    void testValida(){
        assertTrue(tarjeta.esValida());

    }

    @Test
    @DisplayName("Son Distintas")
    void testSonDistintas(){
        String numero = "01523654798747896L";
        String vencimiento = "12/2029";
        String cardHolder = "Luciano Levy";
        String marca = "AMEX";
        Tarjeta tarjeta2 = new Tarjeta(numero, vencimiento, cardHolder, marca);
        assertTrue(tarjeta.sonDistintas(tarjeta2));

    }

       
}


