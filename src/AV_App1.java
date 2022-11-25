import java.util.Scanner;

public class AV_App1 {

    public static void main(String[] args) {

        System.out.println("\nChoose the unit for the conversion : \n  1-Gallons to litres \n  2-Litres to gallons \nEnter 1 or 2 : ");
        try (Scanner read1 = new Scanner(System.in)) { 
            int m = read1.nextInt();

            if (m==1) {
        
                Scanner read2 = new Scanner(System.in); 
                System.out.println("\nEnter the value you want to convert: ");
                int n = read2.nextInt(); 

                convert ("litre",n);
                read2.close();
                 }

            if (m==2) {

                Scanner read2 = new Scanner(System.in); 
                System.out.println("\nEnter the value you want to convert: ");
                int n = read2.nextInt(); 

                convert ("gallon",n); 
                read2.close();
                }

            read1.close();
            }

        System.out.println(" ") ;
            
        }
        

    public static void convert(String unit, int vol ) {
        
        if (unit=="litre") {
            float l = (float) (vol * 3.785412) ;
            System.out.println("\n -->  "+ vol + " gallons est équivalent à " + l + " litres ");
        }

        else {
            float l = (float) (vol * 0.264172) ;
            System.out.println("\n -->  "+ vol + " litres est équivalent à " + l + " gallons ");
        }
   
}


}
 



