import java.util.Scanner;

public class Main {

    public static String[] guests = new String[ 10 ];
//    static String[] guests;

    public static Scanner scanner = new Scanner ( System.in );
    public static int option=0;
    public static int counter=0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner ( System.in );
        insertTestName ();


        do {

            guestList ( );
            displayMenu ();
            getOption ();

            int option = scanner.nextInt ( );
            scanner.nextLine();
            System.out.println ( );

            if ( option == 1 ) {
                addGuest ();
            } else if ( option == 2 ) {
//                removeGuest ();
                removeByCounter ();
            } else if ( option == 3 ) {
                renameGuest ();
                break;
            } else if (option == 4) {
                insertGuest ();
            } else if (option == 5){
                exitProgram ();
            }

        } while (true);


    }

    public static void guestList() {

        System.out.println ( "-----------------------" );
        System.out.println ( "Here is the Guest List:" );
        System.out.println ( "-----------------------" );
        System.out.println ( );

        for ( int i = 0 ; i < guests.length ; i++ ) {

//            System.out.println ( (i+1) + ". " + (guests[ i ] == null ? "--" : guests[ i ] ));
            if (guests[i]!= null){
                System.out.println ((i+1) + ". " + guests[i] );
//                break;
            } else if (guests[0]==null){
                System.out.println ("Guest List is empty." );
                break;
            }

        }
    }

    public static void displayMenu(){
        System.out.println ( "------------------------ Menu ---------------------------" );
        System.out.println ( "Select one of the operations you would like to perform: " );
        System.out.println ( "---------------------------------------------------------" );

        System.out.println ( );
        System.out.println ( "1 - Add Guest" );
        System.out.println ( "2 - Remove Guest" );
        System.out.println ( "3 - Rename Guest" );
        System.out.println ( "4 - Add new guest to the list" );
        System.out.println ( "5 - Exit" );
        System.out.println ( "Option: " );
    }

    public static int getOption(){
        return option;
    }

    public static void addGuest(){

            for ( int i = 0 ; i < guests.length ; i++ ) {
                if ( guests[ i ] == null ) {
                    System.out.println ( "Enter the Name of the Guest you wish to add to the list: " );
                    String name = scanner.nextLine ( );
                    guests[ i ] = name;
                    break;
                }
            }



    }

    public static void removeGuest(){
        System.out.println ( "------------------------------------------------" );
        System.out.println ( "Name of guest you wish to delete from the list: " );
        System.out.println ( "------------------------------------------------" );
        String tempGuest[] = new String[guests.length];
        String name = scanner.next ( );
        for ( int i = 0 ; i < guests.length ; i++ ) {
            if ( guests[ i ] != null && guests[ i ].equals ( name ) ) {
                guests[ i ] = null;
                int counter=0;
                for (int x=0; x<guests.length; x++){
                    if (guests[x] != null){

                        tempGuest[counter] = guests[x];
                        counter++;


                    }
                }

                guests=tempGuest;
                break;
            }
        }
    }

    public static void insertTestName(){
        guests[ 0 ] = "Jacob";
        guests[ 1 ] = "Sami";
        guests[ 2 ] = "Dani";
        guests[ 3 ] = "Lestat";
        guests[ 4 ] = "Voldemord";

    }

    public static void exitProgram(){

        System.out.println ( );
        System.out.println ( "Shutting Down. Thank you! " );
        System.out.println ( "--------------------------" );

    }

    public static void removeByCounter() {
        System.out.println ( "------------------------------------------------" );
        System.out.println ( "Number of guest you wish to delete from the list: " );
        System.out.println ( "------------------------------------------------" );

        int possitionNumber = scanner.nextInt ( );

        if (possitionNumber < 0 || possitionNumber > 10){
            System.out.println ("Number not valid.\nInsert another number" );
            System.out.println ( );
            guestList ();
            removeByCounter ();
        } else if ( possitionNumber > 0 ){
            for (int i=0;i<guests.length;i++){
                if (guests[i]!=null && (i==(possitionNumber-1))){
                    guests[i] = null;
                    sortArray ();
                    break;
                }

            }



        }
    }

    public static void sortArray(){
        String tempGuest[] = new String[guests.length];
        int counter=0;
        for (int x=0; x<guests.length; x++)
        {
            if (guests[x] != null)
            {

                tempGuest[counter] = guests[x];
                counter++;
//                        System.out.println (counter );

            }


        }
        guests=tempGuest;

    }

    public static void renameGuest(){
        System.out.println ("Enter number of the Guest you'd like to RENAME" );

        int guestNumber = scanner.nextInt ();
        scanner.nextLine ();
        if (guestNumber < 0 || guestNumber > 10){
            System.out.println ("Number not valid.\nInsert another number" );
            System.out.println ( );
            guestList ();
            renameGuest ();
        } else {
//            for (int i=0; i<guests.length;i++){
              if ( guests[ guestNumber-1] != null ){
                  System.out.println ("you have selected to change the name of "+guests[guestNumber-1] );
                  System.out.println ("Please Enter a New Name" );
                  String newName = scanner.nextLine ( );
                  guests[ guestNumber-1 ] = newName;
                  guestList ();

              }

//            }

        }
    }

    public static void insertGuest(){
        System.out.println ("you have chosen to add a new guest in a certain position." );
        System.out.println ("First enter the position number: " );
        int posNumber = scanner.nextInt ();
        scanner.nextLine();
            if (posNumber>=1 && posNumber<=10 && guests[posNumber-1]!=null){
                System.out.println ("Enter the name you wish to insert: " );
                String name =scanner.nextLine ();

                for(int i = guests.length-1;i>posNumber-1;i--){
                    guests[i]=guests[i-1];
                }
                guests[posNumber - 1] = name;
            } else {
                System.out.println ("there is no position with that number." );
            }




    }
}