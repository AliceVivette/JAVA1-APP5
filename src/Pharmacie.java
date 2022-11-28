import java.util.*;


public class Pharmacie {

    public void appro_stock(){

    }
    

    public void retrait_achat(){

    }

    public void achat_medoc(String ref, int qt, ArrayList liste_achat){

    }

    public static void main(String[] args) throws Exception {

        Client c1 = new Client("ROY", "Victorine", "2020778158258", "Chateau de Versailles", "06 62 03 12 96");
        Medicament m1 = new Medicament("DLP500", "doliprane 500mg", "antalgique", "2,86 €", 1);

        System.out.println(c1.affichage_client());
        
    }

    
}



