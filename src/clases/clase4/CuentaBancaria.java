package clases.clase4;

public class CuentaBancaria {

    //  Variable de instancia
    private double saldo;

    //  Métodos
    // Getter
    public double getSaldo() {
        return saldo;
    }

    // Setter
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Retirar dinero
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo = saldo - monto;
            System.out.println("Retirado " + monto);
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida");
        }
    }
}
