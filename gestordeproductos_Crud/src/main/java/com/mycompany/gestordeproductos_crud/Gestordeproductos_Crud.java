/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestordeproductos_crud;
import java.util.Scanner;

public class Gestordeproductos_Crud {

    static String[] nombres = new String[5];
    static double[] precios = new double[5];
    static int contador = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- Productos de la empresa ---");
            System.out.println("1. Agregar (Create)");
            System.out.println("2. Listar (Read)");
            System.out.println("3. Actualizar (Update)");
            System.out.println("4. Eliminar (Delete)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion :");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> { //Create
                    System.out.println("Nombre del producto :");
                    String nombre = sc.nextLine();
                    System.out.println("Precio del producto :");
                    double precio = sc.nextDouble();
                    agregar(nombre, precio);
                }
                case 2 -> { // Read 
                    Listar();
                }
                case 3 -> { // Update 
                    Listar();
                    if (contador > 0) {
                        System.out.print("Ingrese el índice del producto a modificar: ");
                        int indice = sc.nextInt();
                        sc.nextLine(); 

                        if (indice >= 0 && indice < contador) {
                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = sc.nextLine();
                            System.out.print("Nuevo precio: ");
                            double nuevoPrecio = sc.nextDouble();

                            actualizar(indice, nuevoNombre, nuevoPrecio);
                        } else {
                            System.out.println("Índice no válido.");
                        }
                    }
                }
                case 4 -> { // Delete 
                    Listar();
                    if (contador > 0) {
                        System.out.print("Ingrese el índice del producto a eliminar: ");
                        int indice = sc.nextInt();
                        sc.nextLine(); 

                        eliminar(indice);
                    }
                }
            }

        } while (opcion != 0);

        sc.close();
    }

    static boolean agregar(String nombre, double precio) {
        if (contador >= nombres.length) {
            System.out.println("No hay espacio en el vector para almacenar elementos");
            return false;
        }
        nombres[contador] = nombre;
        precios[contador] = precio;
        contador++;
        return true;
    }

    static void Listar() {
        if (contador == 0) {
            System.out.println("No hay productos registrados");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(i + " " + nombres[i] + " - $" + precios[i]);
        }
    }


    static boolean actualizar(int indice, String nuevoNombre, double nuevoPrecio) {
        if (indice < 0 || indice >= contador) {
            System.out.println("Índice no válido.");
            return false;
        }
        nombres[indice] = nuevoNombre;
        precios[indice] = nuevoPrecio;
        System.out.println("Producto actualizado correctamente.");
        return true;
    }

    static boolean eliminar(int indice) {
        if (indice < 0 || indice >= contador) {
            System.out.println("Índice no válido.");
            return false;
        }
        
        for (int i = indice; i < contador - 1; i++) {
            nombres[i] = nombres[i + 1];
            precios[i] = precios[i + 1];
        }
        nombres[contador - 1] = null;
        precios[contador - 1] = 0;
        contador--;
        System.out.println("Producto eliminado correctamente.");
        return true;
    }
}