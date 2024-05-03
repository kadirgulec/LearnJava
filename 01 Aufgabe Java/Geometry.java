public class Geometry {
    public static void main(String[] args) {
        /*
         * wir wollen die Argumente "Zylinder r h" oder Kugel r ...
         */
        if (args.length == 0) {
            help();
        } else if (args[0].equals("Zylinder")) {
            /*
             * hier kannst du deine Methode zur Zylinderberechnung einfügen ich
             * habe dir ein Grundgerüst vorgegeben
             */
            if (args.length >= 3) { // haben wir genügend Argumente?
                double r = Double.valueOf(args[1]);
                double h = Double.valueOf(args[2]);
                String ergebnis = zylinder(r, h);
                System.out.println(ergebnis);
            } else {
                help();
            }
        } else if (args[0].equals("Kugel")) {
            if (args.length >= 2) { // haben wir genügend Argumente?
                double r = Double.valueOf(args[1]);
                String ergebnis = kugel(r);
                System.out.println(ergebnis);
            } else {
                help();
            }
        } else if (args[0].equals("Quader")) {
            if (args.length >= 4) { // haben wir genügend Argumente?
                double a = Double.valueOf(args[1]);
                double b = Double.valueOf(args[2]);
                double c = Double.valueOf(args[3]);
                String ergebnis = quader(a, b, c);
                System.out.println(ergebnis);
            } else {
                help();
            }
        } else {
            help();
        }
    }

    public static void help() {
    System.out.println("Folgende Parameteruebergaben werden akzeptiert:");
    System.out.println("Zylinder(String) radius(double) hoehe(double)");
    System.out.println("Kugel(String) radius(double)");
    System.out.println("Quader(String) kante(double) kante(double) kante(double)");
    }

    public static String zylinder(double r, double h) {
    // Grundflaeche und Umfang bestimmen
    double g = Math.PI * r * r;
    double u = 2 * Math.PI * r;
    double volumen = g * h;
    double oberflaeche = u * h + 2 * g;
    return "Der Zylinder hat ein Volumen von: " + volumen + " und eine Oberflaeche von " + oberflaeche + " Einheiten.";
    }

    public static String kugel(double r) {
        // Umfang
        double u = 2 * Math.PI * r;
        // Volumen
        double v = (4 * Math.PI * r * r * r) / 3;
        // Oberflaeche
        double g = 4 * Math.PI * r * r;
        return "Die Kugel hat einen Umfang von: " + u + ", ein Volumen von " + v + "und eine Oberflaeche von " + g + " Einheiten.";
    }

    public static String quader(double a, double b, double c) {
    // Volumen
    double v = a * b * c;
    // Oberflaeche
    double g = 2 * (a * b + a * c + b * c);
    // Laenge der Raumdiagonalen
    double d = Math.sqrt(a * a + b * b + c * c);
    // Gesamte Kantenlaenge
    double k = 4 * a + 4 * b + 4 * c;
    return "Volumen: " + v + ", Oberflaeche: " + g + ", Raumdiagonale: " + d + ", Kantenlaenge: " + k;
    }
}