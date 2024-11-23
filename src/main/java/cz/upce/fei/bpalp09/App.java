package cz.upce.fei.bpalp09;

public class App {
    public static void main(String[] args) {
        Kino kinoSvet = new Kino(3, 6);

        System.out.println("Rezervace mista 1 a 2: " + kinoSvet.rezervujSedadlo(1, 2));
        System.out.println("Rezervace mista 1 a 5: " + kinoSvet.rezervujSedadlo(1, 5));
        System.out.println("Rezervace mista 2 a 3: " + kinoSvet.rezervujSedadlo(2, 3));
        System.out.println("Rezervace mista 1 a 2: " + kinoSvet.rezervujSedadlo(1, 2));
        
        System.out.print("Rady kde jsou alespon 3 volna mista vedle sebe: ");
        kinoSvet.vypisRadySouvislaMista(3);
        
        kinoSvet.vypisSedadla();
    }
}
