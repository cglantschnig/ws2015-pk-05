import java.util.Arrays;

/*
    Aufgabe3) Eindimensionales Array

    Implementieren Sie folgende statische Methoden:

      - 'createArray' gibt ein neues Array zurück, dessen Länge gleich dem Argument der Methode ist. Das Array
        enthält Zufallszahlen größer oder gleich 0.0 und kleiner 100.0 (des diesen Literalen entsprechenden Typs).
        Zur Erzeugung von Zufallszahlen können Sie Math.random() verwenden:
        http://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#random

      - 'printArray' hat zwei Parameter, gibt aber kein Ergebnis zurück. Der erste Parameter A ist ein Array, das z.B.
        durch 'createArray' erzeugt wurde. Der zweite Parameter N ist eine ganze Zahl mit N > 0. 'printArray' zerlegt
        den Wertebereich [0.0, 100.0) in N gleich große Teilbereiche (z.B. für N gleich 4 in [0.0, 25.0), [25.0, 50.0),
        [50.0, 75.0) und [75.0, 100.0) ) und zählt die Zahlen im Array A, die in jeden dieser Wertebereiche fallen.
        Schließlich gibt 'printArray' für jeden dieser Teilbereiche eine Zeile aus, welche die Anzahl der Zahlen im
        entsprechenden Teilbereich enthält. Beispielsweise gibt 'printArray' für ein A der Länge 5 mit den Zahlen
        10.0, 60.0, 20.0, 80.0 und 70.0 und N gleich 4 folgende Zeilen aus:

            2
            0
            2
            1

        Hinweise: Verwenden Sie zum Zählen der Zahlen in den Teilbereichen am besten ein weiteres Array. Am einfachsten
        ist es, die Zuordnung einer Zahl zu einem Teilbereich in die Berechnung des Indexes für dieses Array einzubauen.
        A und N dienen zur Beschreibung der Methode. In Ihrer Implementierung können die Parameter anders heißen.

      - 'halveArray' hat ein Array (wie von 'createArray' zurückgegeben) als Parameter und gibt nichts zurück. Jeder
        Wert im Array wird halbiert.

    Zusatzfragen:
    1. Warum kann man in 'printArray' for-each-Schleifen (also Schleifen der Form for(... : ...) ...) verwenden,
       in 'createArray' und 'halveArray' aber nicht?
       in printArray haben wir nur lesenden Zugriff. In createArray und halveArray möchten wir den Wert ändern
    2. Warum ist es möglich, dass 'halveArray' kein Ergebnis zurückgibt, die Auswirkungen der Methode aber dennoch
       sichtbar werden?
       weil der Parameter nur ein Pointer ist und somit das Object, das gleiche ist wie im aufrufenden Programm
    3. Woran könnte man feststellen, ob die Lösung richtig ist, obwohl jeder Testlauf andere Ergebnisse liefert?
       Man kann Tests schreiben, wenn die immer durchlaufen, kann man davon ausgehen, dass alles passt
*/
public class Aufgabe3 {

    // Hier sollten die benötigten Methoden stehen.
    public static double[] createArray(int count) {
        double tmp[] = new double[count];
        for(int i = 0; i < count; i++) {
            tmp[i] = (Math.random() * 100) - 0;
        }
        return tmp;
    }

    public static void printArray(double[] array, int classes) {
        int classCounters[] = new int[classes];
        int size = 100 / classes; // size of every single class
        for(double item : array) {
            classCounters[ (int)(item / size) ] += 1;
        }
        for (int item : classCounters) {
            System.out.println(item);
        }
    }

    public static void halveArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] /= 2;
        }
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
        double[] test = createArray(10);
        System.out.println(Arrays.toString(test));
        printArray(test, 3);
        halveArray(test);
        System.out.println(Arrays.toString(test));
    }
}
