public class Pfad {
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++
    Lege 'path' als eindimensionales Integer Array an.
    Dieses dient der Erfassung der Bewegungsrichtungen zum
    erreichen des Target.
    Soll mit Werten von 0 bis 3 gefuellt werden:
    -------------------------------------------------------
    0 = NORD
    1 = OST
    2 = SÜD
    3 = WEST
    +++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    int[] path;
    String user;
    HamsterUser h;

    public Pfad (String user) {
        this.user = user;
        HamsterUser h = new HamsterUser(user);
    }

    void erstellePfad (int ind, int row, int col, int map[][]) {
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++
    Iteriere rueckwaerts durch alle Indizes, suche dabei
    ausgehend vom Target immer genau einen Nachbarn und
    speichere die Bewegungsrichtung in 'path'.
    +++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        int rows = map[0].length;
        int cols = map.length;
        path = new int[ind-1];
        for (int i = ind; i > 1; i--){
            //Pr?fe jeweils vorher, ob der Nachbar g?ltig ist
            if(row+1 < rows && map[col][row+1] == i-1) {
                row++;
                path[ind-i] = 0;
            } else if (row-1 >= 0 && map[col][row-1] == i-1) {
                row--;
                path[ind-i] = 2;
            } else if (col+1 < cols && map[col+1][row] == i-1) {
                col++;
                path[ind-i] = 3;
            } else if (col-1 >= 0 && map[col-1][row] == i-1) {
                col--;
                path[ind-i] = 1;
            }
        }
    }

    void hamsterLauf (Hamster h) {
    /*+++++++++++++++++++++++++++++++++++++++++++++++++++++
    Iteriere r?ckw?rts durch 'path'.
    +++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        for (int i = path.length-1; i >= 0; i--){

        /*+++++++++++++++++++++++++++++++++++++++++++++++++++++
        Lass den Hamster sich so oft drehen, bis er in die
        Richtung schaut, die an der aktuellen Position im
        'path' angegeben ist.
        +++++++++++++++++++++++++++++++++++++++++++++++++++++*/
            while (1 != path[i]){ // wenn Blickrichtung für Hamster vom path nicht nach Osten vorgesehen ist
                h.linksUm();
            }
            h.vor(); //Lass den Hamster einen Schritt laufen.
        }
        h.nimm();
    }
}
