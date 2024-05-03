import java.util.Scanner;

class VolumeCalculation{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welche Form wird berechnet (Zylinder, Kugel oder Quader) = ");
        String user_input_shape = scan.next();
        
        if(user_input_shape.equals("Zylinder")){
            
            double user_input_height = user_input("Höhe");

            double user_input_radius = user_input("Radius");

            double cylinder_floor_area = Math.PI * Math.pow(user_input_radius,2);
            double cylinder_side_surface_area = 2 * Math.PI * user_input_radius * user_input_height;
            double cylinder_total_area = 2 * cylinder_floor_area + cylinder_side_surface_area;

            double cylinder_volume = cylinder_floor_area * user_input_height;

            System.out.println("Oberfläche des Zylinders= " +  cylinder_total_area + " cm²");
            System.out.println("Volume des Zylinders= " +  cylinder_volume + " cm³");
        }
        else if (user_input_shape.equals("Kugel")){
            double user_input_radius = user_input("Radius");

            double sphere_circumference = 2 * Math.PI * user_input_radius;
            double sphere_volume = (4/3) * Math.PI * Math.pow(user_input_radius, 3);
            double sphere_surface = 4 * Math.PI * Math.pow(user_input_radius, 2);

            System.out.println("Umfang des Kugel= " +  sphere_circumference + " cm");
            System.out.println("Oberfläche des Kugel= " +  sphere_surface + " cm²");
            System.out.println("Volume des Kugel= " +  sphere_volume + " cm³");
        }
        else if (user_input_shape.equals("Quader")){
            double user_input_height = user_input("Höhe");
            double user_input_wide = user_input("Breite");
            double user_input_depth = user_input("Tiefe");

            double rectangular_total_edge_length = 4 * (user_input_depth + user_input_height + user_input_wide);
            double rectangular_area = 2 * (user_input_depth * user_input_height + user_input_depth * user_input_wide + user_input_height *user_input_wide);
            double rectangular_volume = user_input_depth * user_input_height * user_input_wide;

            System.out.println("Gesamtkantenlänge des Quaders= " +  rectangular_total_edge_length + " cm");
            System.out.println("Oberfläche des Quaders= " +  rectangular_area + " cm²");
            System.out.println("Volume des Quaders= " +  rectangular_volume + " cm³");
        }else{
            System.out.println(help());
        }
    }
    public static double user_input(String measure){
        Scanner measureScanner = new Scanner(System.in);
        System.out.println(measure + " (cm):");
        return measureScanner.nextInt();
    }

    public static String help() {
        return "Der Form name muss mit einem Großbuchstaben beginnen und einer der Folgenden sein; Zylinder, Kugel, Quader";
        }
        
        
    
}
