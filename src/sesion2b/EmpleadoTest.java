package sesion2b;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmpleadoTest {

    // PRUEBAS DEL LIMITE DE 1000 EUROS

    @Test
    void testVentas999() {
        Empleado empleado = new Empleado();
        assertEquals(2000.0f,
                empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 999, 0));
    }

    @Test
    void testVentas1000() {
        Empleado empleado = new Empleado();
        assertEquals(2100.0f,
                empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1000, 0));
    }

    @Test
    void testVentas1001() {
        Empleado empleado = new Empleado();
        assertEquals(2100.0f,
                empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1001, 0));
    }

    // PRUEBAS DEL LIMITE DE 1500 EUROS

    @Test
    void testVentas1499() {
        Empleado empleado = new Empleado();
        assertEquals(2100.0f,
                empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1499, 0));
    }

    @Test
    void testVentas1500() {
        Empleado empleado = new Empleado();
        assertEquals(2200.0f,
                empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1500, 0));
    }

    @Test
    void testVentas1501() {
        Empleado empleado = new Empleado();
        assertEquals(2200.0f,
                empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1501, 0));
    }

    
    // PRUEBAS DEL LIMITE DE NOMINA NETA: 2100 EUROS

    @Test
    void testNomina2099() {
        Empleado empleado = new Empleado();

        assertEquals(2099.0f,
                empleado.calculoNominaNeta(2099));
    }

    @Test
    void testNomina2100() {
        Empleado empleado = new Empleado();

        assertEquals(1785.0f,
                empleado.calculoNominaNeta(2100));
    }

    @Test
    void testNomina2101() {
        Empleado empleado = new Empleado();

        assertEquals(1785.85f,
                empleado.calculoNominaNeta(2101), 0.01f);
    }


    // PRUEBAS DEL LIMITE DE NOMINA NETA: 2500 EUROS

    @Test
    void testNomina2499() {
        Empleado empleado = new Empleado();

        assertEquals(2124.15f,
                empleado.calculoNominaNeta(2499), 0.01f);
    }

    @Test
    void testNomina2500() {
        Empleado empleado = new Empleado();

        assertEquals(2050.0f,
                empleado.calculoNominaNeta(2500));
    }

    @Test
    void testNomina2501() {
        Empleado empleado = new Empleado();

        assertEquals(2050.82f,
                empleado.calculoNominaNeta(2501), 0.01f);
    }
    
    
    // PRUEBA DEL SUELDO BASE DE UN ENCARGADO

    @Test
    void testSueldoEncargado() {
        Empleado empleado = new Empleado();

        assertEquals(2500.0f,
                empleado.calculoNominaBruta(TipoEmpleado.ENCARGADO, 0, 0));
    }
    
    // PRUEBAS DE HORAS EXTRAS

    @Test
    void testHorasExtra0() {
        Empleado empleado = new Empleado();

        assertEquals(2000.0f,
                empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0, 0));
    }

    @Test
    void testHorasExtra1() {
        Empleado empleado = new Empleado();

        assertEquals(2030.0f,
                empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0, 1));
    }

    @Test
    void testHorasExtra2() {
        Empleado empleado = new Empleado();

        assertEquals(2060.0f,
                empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0, 2));
    }
    
    // CASO NEGATIVO 1: TIPO DE EMPLEADO NO VALIDO

    @Test
    void testTipoEmpleadoNulo() {
        Empleado empleado = new Empleado();

        assertThrows(IllegalArgumentException.class, () -> {
            empleado.calculoNominaBruta(null, 1000, 2);
        });
    }

    // CASO NEGATIVO 2: VENTAS NEGATIVAS

    @Test
    void testVentasNegativas() {
        Empleado empleado = new Empleado();

        assertThrows(IllegalArgumentException.class, () -> {
            empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, -1, 2);
        });
    }

    // CASO NEGATIVO 3: HORAS EXTRAS NEGATIVAS

    @Test
    void testHorasExtraNegativas() {
        Empleado empleado = new Empleado();

        assertThrows(IllegalArgumentException.class, () -> {
            empleado.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1000, -1);
        });
    }

    // CASO NEGATIVO 4: NOMINA BRUTA NEGATIVA

    @Test
    void testNominaBrutaNegativa() {
        Empleado empleado = new Empleado();

        assertThrows(IllegalArgumentException.class, () -> {
            empleado.calculoNominaNeta(-1);
        });
    }
}