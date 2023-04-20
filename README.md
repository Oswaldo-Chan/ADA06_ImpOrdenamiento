# ADA06_ImpOrdenamiento

## Descripcion

Este es un programa que ordena un dataset de películas mediante los algoritmos de ordenamiento (BinaryInsertionSort, MergeSort, QuickSort y RadixSort) implementando listas doblemente ligadas.

El programa se ejecutará desde la clase 'MoviesApp.java', dentro de esta clase se pide como entrada el numero de la columna a ordenar y el tipo de orden que tendrá, dentro del código se crea un objeto de tipo ```Controller``` que permitirá todas las operaciones del programa, luego se tendrá que llamar a la función ```Controller.read``` el cual leerá el dataset.

Una vez que se hayan cargado los datos se le pide al controlador que los ordene, para llamar a la funcion ```Controller.order``` el cual tiene dos parámetros, el primero es la columna a ordenar y el segundo es el boleano que indicará si se ordena de manera ascendente o descendente.

Por ultimo se generará el csv ordenado y la función ```Controller.generateTable``` generará las métricas de cada algoritmo.

## Uso

Ejecutar desde la linea de comandos el siguiente comando para generar las clases Java, pero primero asegúrate de estar en la ruta del proyecto.

```shell
javac MoviesApp.java
```

Luego ejecuta el siguiente comando para ejecutar el programa:

```shell
java MoviesApp
```

### Contribuidores

- [Oswaldo-Chan](https://github.com/Oswaldo-Chan)
- [Francisc0Ramos](https://github.com/Francisc0Ramos)

link del repositorio: https://github.com/Oswaldo-Chan/ADA06_ImpOrdenamiento
