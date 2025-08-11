public class CuentaBancaria {
    String titular;
    Integer numeroCuenta;
    Integer saldo;

    public CuentaBancaria(String titular, Integer numeroCuenta, Integer saldo){
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void mostrarDatosCuenta(){
        System.out.println("El titular de la cuenta es: " + titular);
        System.out.println("El numero de cuenta es: " + numeroCuenta);
        System.out.println("El saldo de la cuenta " + numeroCuenta + " es: " + saldo);
        System.out.println("----------------------------------------------------------");
    }

    public void depositar(Integer cantidad){
        if (cantidad < 500){
            System.out.println("Lo sentimos la cantidad mínima para depositar es 500");
        }else{
            this.saldo += cantidad;
            System.out.println("En la cuenta se ha depositado: " + cantidad + " su saldo ahora es: " + this.saldo);
        }
    }

    public void retirar(Integer cantidadRetiro){
        if (cantidadRetiro <= this.saldo){
            this.saldo -= cantidadRetiro;
            System.out.println("La cantidad retirada de la cuenta es: " + cantidadRetiro + " ahora su salgo es: " + this.saldo);
        }else{
            System.out.println("Saldo insuficiente para retirar");
        }
    }

    public void transferir(Integer cantidadTransferir, Integer cuenta){
        if (cuenta != numeroCuenta || cantidadTransferir <= this.saldo){
            this.saldo -= cantidadTransferir;
            System.out.println("La cantidad que ha sido transferida de la cuenta es de: " + cantidadTransferir + " su saldo actual es: " + this.saldo);
        }else{
            System.out.println("Lo sentimos, el número de la cuenta puede ser incorrecto o la cantidad a transferir");
        }
    }

    public static void main(String[] args) {
        CuentaBancaria persona1 = new CuentaBancaria("Isabella", 1234, 15000);
        
        persona1.mostrarDatosCuenta();
        persona1.depositar(4000);
        persona1.retirar(1000);
        persona1.transferir(2000, 00000);
    }
}
