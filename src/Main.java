import ColaPrioridad.ColaP;
import ColaPrioridad.Nodo;

import java.util.Scanner;

public class Main {
    /*public static void mostrarCola(ColaP cola){        //Muestra cola
        ColaP aux = new ColaP();
        aux.InicializarCola();
        while (!cola.ColaVacia()){
            System.out.println(cola.Prioridad());
            aux.Acolar(cola.PrimerNodo());
            cola.Desacolar();}
        while(!aux.ColaVacia()){
            cola.Acolar(aux.PrimerNodo());
            aux.Desacolar();
        }
        System.out.println("-------------------------");
    }

     */

    public static void codificacion(Nodo raiz, String code){
        if (raiz ==  null){
            return;
        }
        if (raiz.getHijoDer() == null && raiz.getHijoIzq() == null) {
            System.out.print(raiz.getLetra());
            System.out.println(" -->  " + code);
        }

        codificacion(raiz.getHijoDer(), code+"1");
        codificacion(raiz.getHijoIzq(), code + "0");
    }

    public static Nodo armarArbol(ColaP cola){         //Arma el arbol
        Nodo raiz = new Nodo();
        if (cola.tamanioCola() == 1){
            System.out.println(cola.Primero() + " 1");
        }
        while (cola.tamanioCola() >= 2){
            //mostrarCola(cola);
            Nodo nuevo = new Nodo();
            nuevo.setHijoDer(cola.PrimerNodo());
            int frecuencia1 = cola.Prioridad();
            cola.Desacolar();
            nuevo.setHijoIzq(cola.PrimerNodo());
            int frecuencia2 = cola.Prioridad();
            cola.Desacolar();
            nuevo.setFrecuencia(frecuencia1 + frecuencia2);
            cola.Acolar(nuevo);
            raiz = nuevo;
        }
        return raiz;
    }

    public static void main(String[] args) {
        ColaP fL = new ColaP();
        fL.InicializarCola();
        System.out.println("        BIENVENIDOS         ");
        Scanner sc =new Scanner(System.in);System.out.println();
        System.out.println("Cargar letras y frecuencia (-1 para dejar de cargar): "); //Carga las letras y frecuencias
        String letra = "";
        int frecuencia = 0;
        while (frecuencia != -1) {
            System.out.print("Frecuencia: ");
            frecuencia = sc.nextInt();
            if (frecuencia != -1){
                System.out.print("Letras:");
                letra = sc.next();
                Nodo n = new Nodo();
                n.setFrecuencia(frecuencia);
                n.setLetra(letra);
                fL.Acolar(n);
            }
        }

        Nodo raiz = armarArbol(fL);
        codificacion(raiz, "");

    }

}