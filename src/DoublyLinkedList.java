public class DoublyLinkedList<T> {
    private DoublyLink<T> first;
    private DoublyLink<T> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    //Methods

    public boolean isEmpty() { 
        return first == null;
    }

    public void insertFirst(T data) { //inserta un nodo al principio
        DoublyLink<T> newLink = new DoublyLink<>(data);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(T data) { //inserta un nodo al final
        DoublyLink<T> newLink = new DoublyLink<>(data);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public DoublyLink<T> deleteFirst() { //elimina el primer nodo
        DoublyLink<T> temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public DoublyLink<T> deleteLast() { //elimina el ultimo nodo
        DoublyLink<T> temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(T key, T data) { //inserta un nodo con el valor proporcionado despues del nodo indicado
        DoublyLink<T> current = first;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        DoublyLink<T> newLink = new DoublyLink<>(data);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public DoublyLink<T> deleteKey(T key) { //elimina el primer nodo con el valor del parametro
        DoublyLink<T> current = first;
        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }

    public void displayForward() { //Muestra la lista desde el primer al ultimo nodo
        System.out.print("List (first-->last): ");
        DoublyLink<T> current = first;
        while (current != null) {
            System.out.print(current.data + ",");
            current = current.next;
        }
        System.out.println("");
    }


    public void displayBackward() { //Muestra la lista desde el ultimo al primer nodo
        System.out.print("List (last-->first): ");
        DoublyLink<T> current = last;
        while(current != null) {
            System.out.println(current.getData());
            current = current.previous; 
        }
        System.out.println("");
    }

    //Metodos de la ADA 4 en el orden indicado en la ADA

    public DoublyLink<T> getFirst() {
        return first;
    }

    public DoublyLink<T> getLast() {
        return last;
    }

    public int size() {
        int count = 0;
        DoublyLink<T> current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean updateNode(T oldData, T newData) {
        DoublyLink<T> current = first;
        while (current != null) {
            if (current.data.equals(oldData)) {
                current.data = newData;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public boolean updateNodeData(T newData, int position) {
        DoublyLink<T> current = first;
        int currentPosition = 0;
        while (current != null && currentPosition != position) {
            current = current.next;
            currentPosition++;
        }
        if (current != null) {
            current.data = newData;
            return true;
        } else {
            return false;
        }
    }
    
    public DoublyLink<T> deleteByData(T data) {
        DoublyLink<T> current = first;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }

    public DoublyLink<T> deleteByPosition(int position) {
        DoublyLink<T> current = first;
        int currentPosition = 0;
        
        // Recorrer la lista hasta llegar al nodo correspondiente a la posición dada
        while (current != null && currentPosition < position) {
            current = current.next;
            currentPosition++;
        }
        
        // Si no se encontró el nodo correspondiente a la posición dada, retornar null
        if (current == null) {
            return null;
        }
        
        // Si el nodo a eliminar es el primer elemento de la lista
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        
        // Si el nodo a eliminar es el último elemento de la lista
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        
        // Retornar el nodo eliminado
        return current;
    }

    public void clear() {
        first = null;
        last = null;
    }
    
    public int findDataPosition(T data) {
        int position = -1;
        DoublyLink<T> current = first;
        while (current != null) {
            position++;
            if (current.data.equals(data)) {
                return position;
            }
            current = current.next;
        }
        return -1;
    }

    public void setFirst(DoublyLink<T> first) {
        this.first = first;
    }

    public void setLast(DoublyLink<T> last) {
        this.last = last;
    }
    
} 