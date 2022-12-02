import java.util.*;

import java.util.HashMap; // import the HashMap class

public class Pharmacie {

    public HashMap<String, Integer> liste_médoc = new HashMap<String, Integer>();
   
    public void appro_stock(){
        
    }
    

    public void retrait_achat(){

    }

    public void ajout_ref_medoc() {

    }

    public void ajout_client() {

    }

    public static void recherche_client(ArrayList<Client> liste_clients, String secu) {
        for(int i = 0 ; i < liste_clients.size(); i++){
            if (secu.equals(liste_clients.get(i).numero_secu)){
                liste_clients.get(i).affichage_client();
            }

        }

    }

    public void achat_medoc(String ref, int qt, ArrayList<Medicament> liste_achat){

    }


    static void check_num (String n) throws Num_Exception{ 
        if(n.length() < 13){  
            throw new Num_Exception("Erreur sur le numéro de sécurité social, sa longueur est inférieur à 13 ");   
            // on throw une nouvelle exception si length n < 13
        }  
        else {     
            // sinon tout va bien
        }   
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Client> liste_clients=new ArrayList<Client>();;

        Medicament m1 = new Medicament("DLP500", "doliprane 500mg", "antalgique", "2,86 €", 1);

        Client c1 = new Client("ROY", "Victorine", "2020778158258", "Chateau de Versailles", "06 62 03 12 96");
        Client c2 = new Client("VIVET", "Alice", "1234567898765", "Chateau de Versailles", "06 62 03 12 96");

        // Verifier Exception sur numero sécu
        try {     
        check_num(c2.numero_secu);  
        liste_clients.add(c2);
        }  
        catch (Num_Exception ex){     
        System.out.println(ex);  
        }
        

        recherche_client(liste_clients, "1234567898765");

        
    }

    
}



