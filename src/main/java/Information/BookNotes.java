package Information;

import util.LinkedList;

public class BookNotes extends Notes {

    private int bookId = 0;
    
    private LinkedList<Notes> bookNotes;
    
    public BookNotes() {
    }

    public BookNotes(int bookId) {
        bookNotes= new LinkedList<Notes>();
        this.bookId = bookId;
    }
    public void addNote(Notes newNote){
        this.bookNotes.insertEnd(newNote);
    }
    
    public String paintBookNotes(){
        //add note to string into a note
        String s = " {";
        for(int i = 0; i<this.bookNotes.count;i++){
            s= s + " [" + this.bookNotes.elementPosition(i).paintNote()+ "] ";
        }
        s = s+ "} ";
        return " [ *"+ this.bookId+ "* , *"+ s +"* ]";
    }

}
