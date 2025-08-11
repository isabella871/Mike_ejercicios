// Obserbación: Hay qu evalidar los datos ingresados y mostrar los datos de la cuenta (titular, saldo, numCuenta)

import java.util.Scanner;

public class BancoScanner {
    String titular;
    Integer numeroCuenta;
    Integer saldo;

    public BancoScanner(String titular, Integer numeroCuenta, Integer saldo){
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
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
        Scanner scanner = new Scanner(System.in);

        // Crear la cuenta
        System.out.print("Ingrese el nombre del titular: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el número de cuenta: ");
        Integer numCuenta = scanner.nextInt();

        System.out.print("Ingrese el saldo inicial: ");
        Integer saldoInicial = scanner.nextInt();

        CuentaBancaria cuenta = new CuentaBancaria(nombre, numCuenta, saldoInicial);

        int opcion;
        do {
            System.out.println("Selecciona una opción");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Transferir");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cuenta.mostrarDatosCuenta();
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    int deposito = scanner.nextInt();
                    cuenta.depositar(deposito);
                    break;

                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    int retiro = scanner.nextInt();
                    cuenta.retirar(retiro);
                    break;

                case 4:
                    System.out.print("Ingrese la cantidad a transferir: ");
                    int transferencia = scanner.nextInt();
                    System.out.print("Ingrese el número de cuenta destino: ");
                    int cuentaDestino = scanner.nextInt();
                    cuenta.transferir(transferencia, cuentaDestino);
                    break;

                case 5:
                    System.out.println("Se salió del menú");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}