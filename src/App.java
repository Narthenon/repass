import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        nevjegy();
        //Fejrész kiírása
        System.out.println("Jelszavak");
        //Verzió kiírása
        System.out.println("Verzió: 0.0.1");
        
        //Az a objektummal kérhetünk be a konzolról
        Scanner String = new Scanner(System.in);

        System.out.print("Felhasználónév: ");
        // A jelszó változó tárolja a jelszót
        String név = String.nextLine();
        System.out.print("Jelszó: ");
        String jelszó = String.nextLine();
        System.out.print("Hely: ");
        String hely = String.nextLine();
        String.close();
        int Siker = 0;
        try {
            /* 
            A jelszó, a felhasználónév és a 
            használati helye a passList 
            objektumban van tárolva            
            */
            Store passList = new Store(név, jelszó, hely);
            FileWriter szöveg = new FileWriter("pass.txt");
            PrintWriter kiír = new PrintWriter(szöveg);
            kiír.print(passList.user);
            if(!passList.hollow()) { kiír.print(passList.retrieval()); }
            kiír.print(passList.place);
            kiír.close();
            Siker = 1;
        } catch (IOException e) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
        }

        if(Siker == 1) { System.out.println("Ok. A kiírás sikeres.");  }else {  System.out.println("Hiba! A kiírás sikertelen"); }

    }

    public static void nevjegy() {
        System.out.println("Nagy János");
    }
}
