package listas_circulares;

import javax.swing.JOptionPane;

public class Listas {
    // Puntero que indica el inicio de la lista o conocida tambien
    // como cabeza de la lista.

    private Nodos inicio;
    // Puntero que indica el final de la lista o el ultimo nodo.
    private Nodos ultimo;
    // Variable para registrar el tamaño de la lista.
    private int tamanio;

    public void Lista() {
        inicio = null;
        ultimo = null;
        tamanio = 0;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregarAlFinal(int valor) {
        // Define un nuevo nodo.
        Nodos nuevo = new Nodos();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            // De igual forma el ultimo nodo sera el nuevo.
            ultimo = nuevo;
            // Y el puntero del ultimo debe apuntar al primero.
            ultimo.setSiguiente(inicio);
            // Caso contrario el nodo se agrega al final de la lista.
        } else {
            // Apuntamos con el ultimo nodo de la lista al nuevo.
            ultimo.setSiguiente(nuevo);
            // Apuntamos con el nuevo nodo al inicio de la lista.
            nuevo.setSiguiente(inicio);
            // Como ahora como el nuevo nodo es el ultimo se actualiza
            // la variable ultimo.
            ultimo = nuevo;
        }
        // Incrementa el contador de tamaño de la lista
        tamanio++;
    }

    public void agregarAlInicio(int valor) {
        // Define un nuevo nodo.
        Nodos nuevo = new Nodos();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como inicio al nuevo nodo.
            inicio = nuevo;
            // De igual forma el ultimo nodo sera el nuevo.
            ultimo = nuevo;
            // Y el puntero del ultimo debe apuntar al primero.
            ultimo.setSiguiente(inicio);
            // Caso contrario va agregando los nodos al inicio de la lista.
        } else {
            // Une el nuevo nodo con la lista existente.
            nuevo.setSiguiente(inicio);
            // Renombra al nuevo nodo como el inicio de la lista.
            inicio = nuevo;
            // El puntero del ultimo debe apuntar al primero.
            ultimo.setSiguiente(inicio);
        }
        // Incrementa el contador de tamaño de la lista.
        tamanio++;
    }

    public void insertarPorReferencia(int referencia, int valor) {
        // Define un nuevo nodo.
        Nodos nuevo = new Nodos();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Verifica si la lista contiene elementos
        if (!esVacia()) {
            // Consulta si el valor existe en la lista.
            if (buscar(referencia)) {
                // Crea ua copia de la lista.
                Nodos aux = inicio;
                // Recorre la lista hasta llegar al nodo de referencia.
                while (aux.getValor() != referencia) {
                    aux = aux.getSiguiente();
                }
                // Consulta si el nodo a insertar va despues del ultimo
                if (aux == ultimo) {
                    // Apuntamos con el ultimo nodo de la lista al nuevo.
                    aux.setSiguiente(nuevo);
                    // Apuntamos con el nuevo nodo al inicio de la lista.
                    nuevo.setSiguiente(inicio);
                    // Como ahora como el nuevo nodo es el ultimo se actualiza
                    // la variable ultimo.
                    ultimo = nuevo;
                } else {
                    // Crea un respaldo de la continuación de la lista.
                    Nodos siguiente = aux.getSiguiente();
                    // Enlaza el nuevo nodo despues del nodo de referencia.
                    aux.setSiguiente(nuevo);
                    // Une la continuacion de la lista al nuevo nodo.
                    nuevo.setSiguiente(siguiente);
                }
                // Incrementa el contador de tamaño de la lista.
                tamanio++;
            }
        }
    }

    public void insrtarPorPosicion(int posicion, int valor) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y <= que el numero de elementos del la lista.
        if (posicion >= 0 && posicion <= tamanio) {
            Nodos nuevo = new Nodos();
            nuevo.setValor(valor);
            // Consulta si el nuevo nodo a ingresar va al inicio de la lista.
            if (posicion == 0) {
                // Une el nuevo nodo con la lista existente.
                nuevo.setSiguiente(inicio);
                // Renombra al nuevo nodo como el inicio de la lista.
                inicio = nuevo;
                // El puntero del ultimo debe apuntar al primero.
                ultimo.setSiguiente(inicio);
            } else {
                // Si el nodo a inserta va al final de la lista.
                if (posicion == tamanio) {
                    // Apuntamos con el ultimo nodo de la lista al nuevo.
                    ultimo.setSiguiente(nuevo);
                    // Apuntamos con el nuevo nodo al inicio de la lista.
                    nuevo.setSiguiente(inicio);
                    // Como ahora como el nuevo nodo es el ultimo se actualiza
                    // la variable ultimo.
                    ultimo = nuevo;
                } else {
                    // Si el nodo a insertar va en el medio de la lista.
                    Nodos aux = inicio;
                    // Recorre la lista hasta llegar al nodo anterior
                    // a la posicion en la cual se insertara el nuevo nodo.
                    for (int i = 0; i < (posicion - 1); i++) {
                        aux = aux.getSiguiente();
                    }
                    // Guarda el nodo siguiente al nodo en la posición
                    // en la cual va a insertar el nevo nodo.
                    Nodos siguiente = aux.getSiguiente();
                    // Inserta el nuevo nodo en la posición indicada.
                    aux.setSiguiente(nuevo);
                    // Une el nuevo nodo con el resto de la lista.
                    nuevo.setSiguiente(siguiente);
                }
            }
            // Incrementa el contador de tamaño de la lista.
            tamanio++;
        }
    }

    public int getValor(int posicion) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < tamanio) {
            // Consulta si la posicion es el inicio de la lista.
            if (posicion == 0) {
                // Retorna el valor del inicio de la lista.
                return inicio.getValor();
            } else {
                // Crea una copia de la lista.
                Nodos aux = inicio;
                // Recorre la lista hasta la posición ingresada.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                // Retorna el valor del nodo.
                return aux.getValor();
            }

        }
        return 0;
    }

    public boolean buscar(int referencia) {
        // Crea una copia de la lista.
        Nodos aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al primer nodo nuevamente.
        do {
            // Consulta si el valor del nodo es igual al de referencia.
            if (referencia == aux.getValor()) {
                // Canbia el valor de la bandera.
                encontrado = true;
            } else {
                // Avansa al siguiente. nodo.
                aux = aux.getSiguiente();
            }
        } while (aux != inicio && encontrado != true);
        // Retorna el resultado de la bandera.
        return encontrado;
    }

    public int getPosicion(int referencia) {
        // Crea una copia de la lista.
        Nodos aux = inicio;
        // COntado para almacenar la posición del nodo.
        int cont = 0;
        // Recoore la lista hasta llegar al nodo de referencia.
        while (referencia != aux.getValor()) {
            // Incrementa el contador.
            cont++;
            // Avansa al siguiente. nodo.
            aux = aux.getSiguiente();
        }
        // Retorna el valor del contador.
        return cont;
        // Crea una excepción de Valor inexistente en la lista.
    }

    public void editarPorReferencia(int referencia, int valor) {
        // Consulta si el valor existe en la lista.
        if (buscar(referencia)) {
            // Crea ua copia de la lista.
            Nodos aux = inicio;
            // Recorre la lista hasta llegar al nodo de referencia.
            while (aux.getValor() != referencia) {
                aux = aux.getSiguiente();
            }
            // Actualizamos el valor del nodo
            aux.setValor(valor);
        }
    }

    public void editarPorPosicion(int posicion, int valor) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < tamanio) {
            // Consulta si el nodo a eliminar es el primero.
            if (posicion == 0) {
                // Alctualiza el valor delprimer nodo.
                inicio.setValor(valor);
            } else {
                // En caso que el nodo a eliminar este por el medio 
                // o sea el ultimo
                Nodos aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                // Alctualiza el valor del nodo.
                aux.setValor(valor);
            }
        }
    }

    public void removerPorReferencia(int referencia) {
        // Consulta si el valor de referencia existe en la lista.
        if (buscar(referencia)) {
            // Consulta si el nodo a eliminar es el pirmero
            if (inicio.getValor() == referencia) {
                // El primer nodo apunta al siguiente.
                inicio = inicio.getSiguiente();
                // Apuntamos con el ultimo nodo de la lista al inicio.
                ultimo.setSiguiente(inicio);
            } else {
                // Crea ua copia de la lista.
                Nodos aux = inicio;
                // Recorre la lista hasta llegar al nodo anterior 
                // al de referencia.
                while (aux.getSiguiente().getValor() != referencia) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {
                    // Guarda el nodo siguiente del nodo a eliminar.
                    Nodos siguiente = aux.getSiguiente();
                    // Enlaza el nodo anterior al de eliminar con el 
                    // sguiente despues de el.
                    aux.setSiguiente(siguiente.getSiguiente());
                    // Actualizamos el puntero del ultimo nodo
                }
            }
            // Disminuye el contador de tamaño de la lista.
            tamanio--;
        }
    }

    public void removerPorPosicion(int posicion) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < tamanio) {
            // Consulta si el nodo a eliminar es el primero
            if (posicion == 0) {
                // Elimina el primer nodo apuntando al siguinte.
                inicio = inicio.getSiguiente();
                // Apuntamos con el ultimo nodo de la lista al inicio.
                ultimo.setSiguiente(inicio);
            } // En caso que el nodo a eliminar este por el medio 
            // o sea el ultimo
            else {
                // Crea una copia de la lista.
                Nodos aux = inicio;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {
                    // Guarda el nodo siguiente del nodo a eliminar.
                    Nodos siguiente = aux.getSiguiente();
                    // Enlaza el nodo anterior al de eliminar con el 
                    // sguiente despues de el.
                    aux.setSiguiente(siguiente.getSiguiente());
                    // Actualizamos el puntero del ultimo nodo
                }
            }
            // Disminuye el contador de tamaño de la lista.
            tamanio--;
        }
    }

    public void eliminar() {
        // Elimina el valor y la referencia a los demas nodos.
        inicio = null;
        // Elimina el valor y la referencia al primer nodo.
        ultimo = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tamanio = 0;
    }

    public void listar() {
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            int b;
            String[] opcion = {"Mostrar lista completa", "Mostrar valor a valor"};
            int list = JOptionPane.showOptionDialog(null, "Como quiere visualizar la lista?", "Menu de visualizacion", 1, 1, null, opcion, null);
            if (list == 0) {
                String YY = "";
                // Crea una copia de la lista.
                Nodos aux = inicio;
                // Posicion de los elementos de la lista.
                int i = 0;
                // Recorre la lista hasta llegar nuevamente al incio de la lista.       1 + n+1 + n
                do {
                    // Imprime en pantalla el valor del nodo.
                    YY += i + ".[ " + aux.getValor() + " ]\n";
                    // Avanza al siguiente nodo.
                    aux = aux.getSiguiente();
                    // Incrementa el contador de la posión.
                    i++;
                } while (aux != inicio);
                JOptionPane.showMessageDialog(null, YY, "Lista", 1);
            }
            if (list == 1) {
                // Crea una copia de la lista.
                Nodos aux = inicio;
                // Posicion de los elementos de la lista.
                int i = 0;
                // Recorre la lista hasta llegar nuevamente al incio de la lista.
                do {
                    // Imprime en pantalla el valor del nodo.
                    JOptionPane.showMessageDialog(null, i + ".[ " + aux.getValor() + " ]", "Lista", 1);
                    // Avanza al siguiente nodo.
                    aux = aux.getSiguiente();
                    // Incrementa el contador de la posión.
                    i++;
                } while (aux != inicio);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia", "Alerta", 2);
        }
    }
}
