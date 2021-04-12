package util;

class Node<TypeOfData> {

    TypeOfData data;
    Node next;
    Node prev; //previous

    Node(TypeOfData data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

//Book[ bookinformation[], Actual page, BookNotes[], Status ],
public class LinkedList<TypeOfData> {

    Node<TypeOfData> head;
    Node<TypeOfData> tail;
    Integer count = 0;
    
    public LinkedList() {
        makeEmpty();
    }

    public LinkedList(TypeOfData[] array){ //se crean los nodos y se enlazan segun un array

         for(int i=array.length-1; i>=0; i--){
             insertBegin(array[i]);
         }
    }

    void makeEmpty(){ //vacia la Linkedlist
        count = 0;
        head = null;
        tail = null;
    }

    //k siempre hace referencia a un indice

    private Node<TypeOfData> read(int k){ //busca un nodo que se encuentra en la posicion K
        if(k < 0 || k >= count){
            System.out.println("No es posible realizar la búsqueda");
            return null;
        }
        Node<TypeOfData> aux = head;
        for(int i = 0; i < k; i++)
            aux = aux.next;
        return aux;
    }

    void insertBegin(TypeOfData toInsert){ //Inserta al principio de la Linkedlist
        Node<TypeOfData> newNode = new Node<>(toInsert);
        if(count == 0){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            newNode.prev = null;
        }
        count++;
    }

    public void insertEnd(TypeOfData toInsert){ //Inserta al final de la Linkedlist
        Node<TypeOfData> newNode = new Node<>(toInsert);
        if(count == 0){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            newNode.next = null;
        }
        count++;
    }

    void insertPosition(int k, TypeOfData toInsert){ //Inserta un elemento en una posicion k de la Linkedlist
        Node<TypeOfData> newNode = new Node<>(toInsert);
        if (count == 0){
            insertBegin(toInsert);
        }
        else if (k > (count-1)){
            System.out.println("El indice " + k + " no se encuentra en la lista, no es posible agregar el: " + toInsert);
        }
        else{
            Node<TypeOfData> aux = read(k);
            newNode.prev = aux.prev;
            aux.prev.next = newNode;
            aux.prev = newNode;
            newNode.next = aux;
            count++;
        }
    }


    void deleteBegin(){ //Elimina el elemento que esta al inicio de la Linkedlist
        if (count == 0){
            System.out.println("La lista esta vacia");
        }
        else if (count == 1){
            head = null;
            tail = null;
            count--;
        }
        else{
            head = head.next;
            count--;
        }
    }

    void deleteEnd(){ //Elimina el elemento que esta al final de la Linkedlist
        if (count == 0){
            System.out.println("La lista esta vacia");
        }
        else if (count == 1){
            head = null;
            tail = null;
            count--;
        }
        else{
            Node<TypeOfData> aux = tail;
            tail = aux.prev;
            tail.next = null;
            count--;
        }
    }

    void deletePosition(int k){ //Elimina el elemento que se encuentra en la posicion
        if (count == 0){
            System.out.println("La lista esta vacia");
        }
        else if (k > (count-1)){
            System.out.println("El indice " + k + " no se encuentra en la lista");
        }
        else if(count-1 == k){
            Node<TypeOfData> aux = read(k);
            aux.prev.next = null;
            count--;
        }
        else{
            Node<TypeOfData> aux = read(k);
            aux.next.prev = aux.prev;
            aux.prev.next = aux.next;
            count--;
        }
    }

    LinkedList<Integer> find(TypeOfData element){

        LinkedList<Integer> ret = new LinkedList<>();

        Node<TypeOfData> aux = head;

        int c = count;
        int index = 0;

        while(c-->0){
            if(aux.data == element){
                ret.insertEnd(index);
            }
            index++;
            aux = aux.next;
        }
        return ret;

    }

    TypeOfData headElement(){ //Consultar el elemento en el inicio de la lista
        return head.data;
    }

    TypeOfData tailElement(){ //Consultar el elemento al final de la lista
        return tail.data;
    }

    TypeOfData elementPosition(int k){ //Retorna únicamente el valor (no el nodo) del elemento en la posición K
        return read(k).data;
    }

    Integer numberOfElements(){ //Retorna el numero de elementos que hay en la Linkedlist
        return count;
    }

    Boolean isEmpty(){ //Retorna si la Linkedlist esta vacia
        if(count != 0){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){ //Imprime la Linkedlist

        StringBuilder str = new StringBuilder();
        str.append("[");

        Node<TypeOfData> aux = head;

        if (count == 0) {
            System.out.println("La lista esta vacia");
            return " ";
        }
        else{
            while (aux != null){
                str.append(aux.data);
                str.append(", ");
                aux = aux.next;
            }
        }

        String toReturn = str.toString();
        toReturn =  toReturn.substring(0, str.length() - 2);

        return toReturn + "]";
    }

}
