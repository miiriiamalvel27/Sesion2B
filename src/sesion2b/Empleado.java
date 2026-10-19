package sesion2b;

public class Empleado {

    public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {

        // Validar los datos de entrada
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de empleado no valido");
        }

        if (ventasMes < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser negativas");
        }

        if (horasExtra < 0) {
            throw new IllegalArgumentException("Las horas extras no pueden ser negativas");
        }

        float nominaBruta = 0;

        // Sueldo base según el tipo de empleado
        if (tipo == TipoEmpleado.VENDEDOR) {
            nominaBruta = 2000;
        } else if (tipo == TipoEmpleado.ENCARGADO) {
            nominaBruta = 2500;
        }

        // Prima por ventas
        if (ventasMes >= 1500) {
            nominaBruta += 200;
        } else if (ventasMes >= 1000) {
            nominaBruta += 100;
        }

        // Pago de horas extras
        nominaBruta += horasExtra * 30;

        return nominaBruta;
    }

    public float calculoNominaNeta(float nominaBruta) {

        // Validar que la nomina bruta no sea negativa
        if (nominaBruta < 0) {
            throw new IllegalArgumentException("La nomina bruta no puede ser negativa");
        }

        float retencion = 0;

        if (nominaBruta >= 2500) {
            retencion = 0.18f;
        } else if (nominaBruta >= 2100) {
            retencion = 0.15f;
        }

        return nominaBruta * (1 - retencion);
    }
}