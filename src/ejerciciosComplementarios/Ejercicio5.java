package ejerciciosComplementarios;

public class Ejercicio5 {
    public static void main(String[] args) throws CloneNotSupportedException {
        CuentaBancaria cuenta1 = new CuentaBancaria("Gastón", "Delucchi", 40568729, 0.0, 0.0);
    }
//    Crear clase padre de datos comunes de las cuentas
    public static class CuentaBancaria {
        private String nombre;
        private String apellido;
        private int dni;
        private double saldoCajaAhorro;
        private int intentosRetiro = 0;
        private static final double LIMITE_CAJA_AHORRO = 500000.00;
        private double montoRetirado = 0.00;
        private double saldoCuentaCorriente;
        private static final double LIMITE_CUENTA_CORRIENTE = -500000.00;

        public CuentaBancaria(String nombre, String apellido, int dni, double saldoCajaAhorro, double saldoCuentaCorriente) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.saldoCajaAhorro = saldoCajaAhorro;
            this.saldoCuentaCorriente = saldoCuentaCorriente;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getDni() {
            return dni;
        }

        public void setDni(int dni) {
            this.dni = dni;
        }

        public double getSaldoCajaAhorro() {
            return saldoCajaAhorro;
        }

        public void setSaldoCajaAhorro(double saldoCajaAhorro) {
            this.saldoCajaAhorro = saldoCajaAhorro;
        }

        public double getSaldoCuentaCorriente() {
            return saldoCuentaCorriente;
        }

        public void setSaldoCuentaCorriente(double saldoCuentaCorriente) {
            this.saldoCuentaCorriente = saldoCuentaCorriente;
        }

        public int getIntentosRetiro() {
            return intentosRetiro;
        }

        public double getLimiteMaximo() {
            return LIMITE_CAJA_AHORRO;
        }

        public double getMontoRetirado() {
            return montoRetirado;
        }


        public void retirarCajaAhorro(double monto) {
            if (intentosRetiro < 5 && (montoRetirado + monto) <= LIMITE_CAJA_AHORRO) {
                if (monto > 0 && monto <= saldoCajaAhorro) {
                    saldoCajaAhorro = saldoCajaAhorro - monto;
                    System.out.println("Retirado " + monto);
                } else {
                    System.out.println("Fondos insuficientes o cantidad inválida");
                }
                intentosRetiro = intentosRetiro++;
                montoRetirado = montoRetirado + monto;
            } else {
                System.out.println("Límite máximo o intentos de retiro máximos alcanzados en el día. Espera 24hs.");
            }
        }

        public void retirarCuentaCorriente(double monto) {
            if (monto > 0 && (saldoCuentaCorriente - monto) >= LIMITE_CUENTA_CORRIENTE) {
                saldoCuentaCorriente = saldoCuentaCorriente - monto;
                System.out.println("Retirado " + monto);
            }
        }
    }
}
