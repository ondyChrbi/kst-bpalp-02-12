package cz.upce.fei.bpalp09;

public class Kino {
    // true = sedadlo je obsazene
    // false = sedadlo je volne
    private final boolean[][] obsazenostSedadel;
    private final int pocetRad;
    private final int pocetSedadelVRade;

    public Kino(int pocetRad, int pocetSedadelVRade) {
        this.obsazenostSedadel = new boolean[pocetRad][pocetSedadelVRade];
        this.pocetRad = pocetRad;
        this.pocetSedadelVRade = pocetSedadelVRade;
    }
    
    public void vypisSedadla() {
        System.out.print("  ");
        
        for (int sedadlo = 0; sedadlo < pocetSedadelVRade; sedadlo++) {
            System.out.print((sedadlo+1) + " ");
        }
        
        System.out.println();
        for (int rada = 0; rada < pocetRad; rada++) {
            System.out.print((rada+1) + " ");
            for (int sedadlo = 0; sedadlo < pocetSedadelVRade; sedadlo++) {
                if (obsazenostSedadel[rada][sedadlo]) {
                    System.out.print("X ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public boolean jeSedadloVolne(int rada, int sedadlo) {
        if (jeMimoRozsah(rada, sedadlo)) {
            return false;
        }
        
        return !this.obsazenostSedadel[rada - 1][sedadlo - 1];
    }

    public boolean rezervujSedadlo(int rada, int sedadlo) {
        if (!jeSedadloVolne(rada, sedadlo)) {
            return false;
        }

        return this.obsazenostSedadel[rada - 1][sedadlo - 1] = true;
    }

    public void vypisRadySouvislaMista(int pocetSouvislychMist) {
        if (pocetSouvislychMist > this.pocetSedadelVRade) {
            return;
        }
        
        for (int rada = 1; rada <= this.pocetRad; ++rada) {
            int souvisleVolnych = 0;

            for (int sedadlo = 1; sedadlo <= this.pocetSedadelVRade; ++sedadlo) {
                if (jeSedadloVolne(rada, sedadlo)) {
                    souvisleVolnych++;
                    if (souvisleVolnych == pocetSouvislychMist) {
                        System.out.print((rada) + " ");
                        break;
                    }
                } else {
                    souvisleVolnych = 0;
                }
            }
        }
        System.out.println();
    }
    
    private boolean jeMimoRozsah(int rada, int sedadlo) {
        return rada > this.pocetRad || sedadlo > this.pocetSedadelVRade;
    }
}
