/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *

/**
 *
 * @author mapv
 */
public class Arbol {

    Nodo raiz;

    public void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo nodoActual, int valor) {

        if (nodoActual == null) {
            return new Nodo(valor);
        }

        if (valor < nodoActual.getValor()) {
            nodoActual.setNodoIzquierdo(agregarRecursivo(nodoActual.getNodoIzquierdo(), valor));
        } else if (valor > nodoActual.getValor()) {
            nodoActual.setNodoDerecho(agregarRecursivo(nodoActual.getNodoDerecho(), valor));
        }

        return nodoActual;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public int obtenerTamano() {
        return obtenerTamanoRecursivo(raiz);
    }
    public int obtenerRaiz(){
        return raiz.getValor();
    }

    private int obtenerTamanoRecursivo(Nodo nodoActual) {
        return nodoActual == null ? 0 : obtenerTamanoRecursivo(nodoActual.getNodoIzquierdo()) + 1 + obtenerTamanoRecursivo(nodoActual.getNodoDerecho());
    }

    public boolean contieneNodo(int valor) {
        return contieneNodoRecursivo(raiz, valor);
    }

    private boolean contieneNodoRecursivo(Nodo nodoActual, int valor) {
        if (nodoActual == null) {
            return false;
        }

        if (valor == nodoActual.getValor()) {
            return true;
        }

        return valor < nodoActual.getValor()
                ? contieneNodoRecursivo(nodoActual.getNodoIzquierdo(), valor)
                : contieneNodoRecursivo(nodoActual.getNodoDerecho(), valor);
    }

    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo nodoActual, int valor) {
        if (nodoActual == null) {
            return null;
        }

        if (valor == nodoActual.getValor()) {
            // Caso 1: sin hijosge
            if (nodoActual.getNodoIzquierdo() == null && nodoActual.getNodoDerecho() == null) {
                return null;
            }

            // Caso 2: solo un hijo
            if (nodoActual.getNodoDerecho() == null) {
                return nodoActual.getNodoIzquierdo();
            }

            if (nodoActual.getNodoIzquierdo() == null) {
                return nodoActual.getNodoDerecho();
            }

            // Caso 3: 2 hijos
            int valorMasPequeno = encontrarValorMasPequeno(nodoActual.getNodoDerecho());
            nodoActual.setValor(valorMasPequeno);
            nodoActual.setNodoDerecho(eliminarRecursivo(nodoActual.getNodoDerecho(), valorMasPequeno));
            return nodoActual;
        }
        if (valor < nodoActual.getValor()) {
            nodoActual.setNodoIzquierdo(eliminarRecursivo(nodoActual.getNodoIzquierdo(), valor));
            return nodoActual;
        }

        nodoActual.setNodoDerecho(eliminarRecursivo(nodoActual.getNodoDerecho(), valor));
        return nodoActual;
    }

    private int encontrarValorMasPequeno(Nodo raiz) {
        return raiz.getNodoIzquierdo() == null ? raiz.getValor() : encontrarValorMasPequeno(raiz.getNodoIzquierdo());
    }

    public void recorrerEnOrden(Nodo nodo) {
        if (nodo != null) {
            recorrerEnOrden(nodo.getNodoIzquierdo());
            visit(nodo.getValor());
            recorrerEnOrden(nodo.getNodoDerecho());
        }
    }

    public void recorrerPreOrden(Nodo nodo) {
        if (nodo != null) {
            visit(nodo.getValor());
            recorrerPreOrden(nodo.getNodoIzquierdo());
            recorrerPreOrden(nodo.getNodoDerecho());
        }
    }

    public void recorrerPostOrden(Nodo nodo) {
        if (nodo != null) {
            recorrerPostOrden(nodo.getNodoIzquierdo());
            recorrerPostOrden(nodo.getNodoDerecho());
            visit(nodo.getValor());
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }


}
