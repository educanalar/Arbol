import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodo;
        Arbol arbol = new Arbol();
        arbol.agregar(6);
        arbol.agregar(4);
        arbol.agregar(3);
        arbol.agregar(5);
        arbol.agregar(8);
        arbol.agregar(7);
        arbol.agregar(9);
        arbol.agregar(2);
        arbol.agregar(10);

        System.out.println("El tamaño del arbol es de: " + arbol.obtenerTamano());
        System.out.println("El nodo raiz es " + arbol.obtenerRaiz());
        System.out.println("Recorriendo en orden:");
        arbol.recorrerEnOrden(arbol.getRaiz());
        System.out.println("\nRecorriendo postorden:");
        arbol.recorrerPostOrden(arbol.getRaiz());
        System.out.println("\nRecorriendo preorden:");
        arbol.recorrerPreOrden(arbol.getRaiz());
        System.out.println("\nNodo a eliminar: ");
        nodo = scanner.nextInt();
        arbol.eliminar(nodo);
        System.out.println("\nRecorriendo en orden (sin el numero" + nodo + " :");
        arbol.recorrerEnOrden(arbol.getRaiz());
        System.out.println("\nRecorriendo postorden(sin el numero" + nodo + " :");
        arbol.recorrerPostOrden(arbol.getRaiz());
        System.out.println("\nRecorriendo preorden(sin el numero" + nodo + " :");
        arbol.recorrerPreOrden(arbol.getRaiz());
        System.out.println("\nEl tamaño del arbol es de: " + arbol.obtenerTamano());
        System.out.println("\nEl nodo raiz es " + arbol.obtenerRaiz());

    }
}