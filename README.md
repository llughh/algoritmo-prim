# Algoritmo de Prim

Este repositorio contiene la implementación del Algoritmo de Prim en Java. El Algoritmo de Prim es un método para encontrar el árbol de expansión mínima de un grafo no dirigido, es decir, el subconjunto de aristas que conecta todos los nodos con el costo total más bajo posible.

## Contenido del Repositorio

- `Grafo.java`: Clase que representa el grafo y sus operaciones básicas.
- `Lista.java`: Clase que maneja listas de adyacencia para representar el grafo.
- `Par.java`: Clase auxiliar para manejar pares de nodos y costos.
- `Prim.java`: Implementación principal del Algoritmo de Prim.

## Requisitos

- Java Development Kit (JDK) 8 o superior.

## Cómo Usar

1. Clona el repositorio:
    ```bash
    git clone https://github.com/llughh/algoritmo-prim.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd algoritmo-prim
    ```
3. Compila los archivos Java:
    ```bash
    javac *.java
    ```
4. Ejecuta el programa:
    ```bash
    java Prim
    ```

## Ejemplo de Uso

Asegúrate de que el archivo `Prim.java` contenga un método `main` que inicialice un grafo, agregue aristas y llame al algoritmo de Prim para mostrar el árbol de expansión mínima.

```java
public static void main(String[] args) {
    Grafo grafo = new Grafo(5);
    grafo.agregarArista(0, 1, 10);
    grafo.agregarArista(0, 2, 6);
    grafo.agregarArista(0, 3, 5);
    grafo.agregarArista(1, 3, 15);
    grafo.agregarArista(2, 3, 4);

    Prim prim = new Prim(grafo);
    prim.algoritmo();
}
