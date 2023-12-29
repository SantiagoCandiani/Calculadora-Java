import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);

        while (true) {
            System.out.println("**** Aplicacion Calculadora ****");
            mostrarMenu();
            try {
                var operacion = Integer.parseInt(consola.nextLine());
                if (operacion >= 1 && operacion <= 4) {
                    ejecutarOperacion(operacion, consola);
                } else if (operacion == 5) {
                    System.out.println("Hasta pronto....");
                    break;
                } else {
                    System.out.println("Opcion erronea: " + operacion);
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            } catch (ArithmeticException e) {
                System.out.println("Error matemático: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }//While

    }//Main

    private static void mostrarMenu() {
        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicacion
                4. Division
                5. Salir
                """);
        System.out.print("Seleccione la operacion a realizar: ");
    }//Mostrar

    private static void ejecutarOperacion(int operacion, Scanner consola) {
        System.out.print("Proporciona el valor de operando1:");
        var operando1 = Double.parseDouble(consola.nextLine());

        System.out.print("Proporciona el valor de operando2:");
        var operando2 = Double.parseDouble(consola.nextLine());

        double resultado;

        switch (operacion) {
            case 1 -> {
                resultado = suma(operando1, operando2);
                System.out.print("El resultado de la suma es: " + resultado);
            }
            case 2 -> {
                resultado = resta(operando1, operando2);
                System.out.print("El resultado de la resta es: " + resultado);
            }
            case 3 -> {
                resultado = multiplicacion(operando1, operando2);
                System.out.print("El resultado de la multiplicacion es: " + resultado);
            }
            case 4 -> {
                resultado = division(operando1, operando2);
                System.out.print("El resultado de la division es: " + resultado);
            }
            default -> System.out.print("Opcion erronea: " + operacion);
        }//Switch
    }//Ejecutar

    private static double suma(double a, double b) {
        return a + b;
    }

    private static double resta(double a, double b) {
        return a - b;
    }

    private static double multiplicacion(double a, double b) {
        return a * b;
    }

    private static double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return a / b;
    }

}//Class

