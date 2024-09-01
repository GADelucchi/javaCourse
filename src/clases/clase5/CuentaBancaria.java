package clases.clase5;

public class CuentaBancaria {

    //  Variable de instancia
    private double saldo;
    private String titular;

    //  Constructor
    public CuentaBancaria(double saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }

    //  Métodos
    // Getter
    public double getSaldo() {
        return saldo;
    }
    public String getTitular() {
        return titular;
    }

    // Setter
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setTitular(String titular) {
        this.titular = titular;
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
