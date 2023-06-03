public class Prim {

    /**
     *
     * @param g grafo no dirigido
     * @param aristas lista de pares atributo-valor
     * @return suma de pesos
     */
    public static int algoritmoPrim(Grafo<String, String, Integer> g, Lista<Par<String, String>> aristas) {
        Lista<String> verticesVisitados = new Lista<>();
        verticesVisitados.insertar(1, g.listaVertices().consultar(1)); // Comenzamos desde el vértice A
        int pesoTotal = 0;
        Lista<String> elemVisitados = new Lista<>();
        elemVisitados.insertar(1, g.listaVertices().consultar(1)); //Añadimos A


        while (verticesVisitados.longitud() < g.numVertices()) {
            int menorPeso = Integer.MAX_VALUE;
            Par<String, String> menorArista = null;

            for (int i = 1; i <= verticesVisitados.longitud(); i++) {
                String vertice = verticesVisitados.consultar(i);
                Lista<String> sucesores = g.listaSucesores(vertice);

                for (int j = 1; j <= sucesores.longitud(); j++) {
                    String sucesor = sucesores.consultar(j);

                    boolean encontrado = false;
                    for (int k = 1; k <= verticesVisitados.longitud(); k++) {
                        if (verticesVisitados.consultar(k).equals(sucesor)) {
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        int peso = g.costeArista(vertice, sucesor);

                        if (peso < menorPeso) {
                            menorPeso = peso;
                            menorArista = new Par<>(vertice, sucesor);
                        }
                    }
                }
            }
            if (menorArista != null) {
                aristas.insertar(aristas.longitud() + 1, menorArista);
                pesoTotal += menorPeso;
                verticesVisitados.insertar(verticesVisitados.longitud() + 1, menorArista.getValor());
                elemVisitados.insertar(elemVisitados.longitud() + 1, menorArista.getValor()); // Agregar el elemento visitado a la lista local

            }
        }

        System.out.println("Elementos visitados:");
        for (int i = 1; i <= elemVisitados.longitud(); i++) {
            System.out.print(elemVisitados.consultar(i) + " ");
        }
        System.out.println();

        return pesoTotal;
    }



    /**
     * Escribe por pantalla las aristas
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
        /*
        //Grafo propio para pruebas de la funcion
        Grafo<String, String, Integer> grafoPrueba = new Grafo<>();
        grafoPrueba.insertarVertice("A", null);
        grafoPrueba.insertarVertice("B", null);
        grafoPrueba.insertarVertice("C", null);
        grafoPrueba.insertarVertice("D", null);
        grafoPrueba.insertarVertice("E", null);
        //Aristas grafo propio sin ordenar
        grafoPrueba.insertarArista("A", "B", 1);
        grafoPrueba.insertarArista("B", "A", 1);
        grafoPrueba.insertarArista("A", "C", 5);
        grafoPrueba.insertarArista("C", "A", 5);
        grafoPrueba.insertarArista("B", "D", 6);
        grafoPrueba.insertarArista("D", "B", 6);
        grafoPrueba.insertarArista("B", "E", 2);
        grafoPrueba.insertarArista("E", "B", 2);
        grafoPrueba.insertarArista("C", "D", 4);
        grafoPrueba.insertarArista("D", "C", 4);
        grafoPrueba.insertarArista("D", "E", 3);
        grafoPrueba.insertarArista("E", "D", 3);

        Lista<Par<String, String>> aristasPrueba = new Lista<>();
        int pesoPrueba = algoritmoPrim(grafoPrueba, aristasPrueba);
        escribirLista(aristasPrueba);
        System.out.println("Peso total: " + pesoPrueba);*/

        //Grafo proporcionado para el ejercicio
        Grafo<String, String, Integer> grafo = new Grafo<>();
        grafo.insertarVertice("A", null);
        grafo.insertarVertice("B", null);
        grafo.insertarVertice("C", null);
        grafo.insertarVertice("D", null);
        grafo.insertarVertice("E", null);
        grafo.insertarVertice("F", null);
        grafo.insertarVertice("G", null);

        // Aristas de A
        grafo.insertarArista("A", "B", 10);
        grafo.insertarArista("A", "C", 4);
        grafo.insertarArista("A", "D", 7);

        //Aristas de B
        grafo.insertarArista("B", "A", 10);
        grafo.insertarArista("B", "D", 2);
        grafo.insertarArista("B", "E", 10);

        //Aristas de C
        grafo.insertarArista("C", "A", 4);
        grafo.insertarArista("C", "D", 2);
        grafo.insertarArista("C", "F", 3);

        //Aristas de D
        grafo.insertarArista("D", "A", 7);
        grafo.insertarArista("D", "B", 2);
        grafo.insertarArista("D", "C", 2);
        grafo.insertarArista("D", "G", 5);

        //Aristas de E
        grafo.insertarArista("E", "B", 10);
        grafo.insertarArista("E", "G", 2);

        //Aristas de F
        grafo.insertarArista("F", "C", 3);
        grafo.insertarArista("F", "G", 5);

        //Aristas de G
        grafo.insertarArista("G", "D", 5);
        grafo.insertarArista("G", "E", 2);
        grafo.insertarArista("G", "F", 5);


        Lista<Par<String, String>> aristas = new Lista<>();
        int peso = algoritmoPrim(grafo, aristas);
        escribirLista(aristas);
        System.out.println("Peso total: " + peso);


        //Agregamos los vertices y aristas y despues sacamos el peso
        //Las clases lo toman como grafo dirigido, tenemos que hacer que las pruebas lo interprese como grafo no dirigido

    }
}
