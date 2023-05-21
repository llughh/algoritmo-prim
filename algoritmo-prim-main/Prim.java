import java.util.ArrayList;
import java.util.List;

public class Prim {

    public static int algoritmoPrim(Grafo<String, String, Integer> g, Lista<Par<String, String>> aristas) {

        //no se si podemos poner String en vez de clave
        return 0;
    }

    /**
     * Escribe por pantalla las aristas seleccionadas
     * @param aristas Lista de pares atributo-valor
     */
    public static void escribirLista(Lista<Par<String, String>> aristas) {
        for (int i = 1; i <= aristas.longitud(); i++) {
            Par<String, String> arista = aristas.consultar(i);
            String atributo = arista.getAtributo();
            String valor = arista.getValor();
            System.out.println(atributo + " -> " + valor);
        }
    }

    //Realizamos las pruebas aqui
    public static void main(String[] args) {
        //No se que hay que poner en info vertice hay que preguntar
        Grafo<String, String, Integer> grafo = new Grafo<>();
        grafo.insertarVertice("A", "B");
        grafo.insertarVertice("B", "C");
        grafo.insertarVertice("C", "C");
        grafo.insertarVertice("D", "C");
        grafo.insertarVertice("E", "C");
        grafo.insertarVertice("F", "C");
        grafo.insertarVertice("G", "C");
        grafo.insertarArista("A", "B", 10);
        grafo.insertarArista("A", "D", 7);
        grafo.insertarArista("A", "C", 4);
        grafo.insertarArista("B", "E", 10);
        grafo.insertarArista("C", "F", 3);
        grafo.insertarArista("D", "G", 5);
        grafo.insertarArista("F", "G", 5);
        grafo.insertarArista("E", "G", 2);
        grafo.insertarArista("D", "B", 2);
        grafo.insertarArista("D", "C", 2);

        Lista<Par<String, String>> aristas = new Lista<>();
        int peso = algoritmoPrim(grafo, aristas);
        escribirLista(aristas);
        System.out.println("Peso total: " + peso);









        //Agregamos los vertices y aristas y despues sacamos el peso
        //Las clases lo toman como grafo dirigido, tenemos que hacer que las pruebas lo interprese como grafo no dirigido

    }
}
