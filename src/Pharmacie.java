import java.util.*;

import java.util.HashMap; // import the HashMap class

public class Pharmacie {

   
    public static void appro_stock(String ref,Integer quantité, HashMap<String,Integer> medoc, ArrayList<Medicament> liste_medocs){
        for (int i = 0 ; i < liste_medocs.size(); i++){
            if(ref.equals(liste_medocs.get(i).reference)){
                Integer quantity = medoc.get(ref);
                quantity+=quantité;
                medoc.replace(ref, quantity);
            }
        }
    }
    


    public static void retrait_achat(ArrayList<Client> liste_clients, HashMap<String, Integer> liste_médoc,ArrayList<Medicament> liste_medocs, String num_c, String num_m, int q){
        for(int i = 0 ; i < liste_clients.size(); i++){
            if (num_c.equals(liste_clients.get(i).numero_secu)){
                // on trouve le client
                if (liste_médoc.get(num_m)!=null){
                    // si la ref existe, on retire la quantité désirée au stock
                    int q_av = liste_médoc.get(num_m);
                    int q_ap = q_av - q;
                    if (q_ap < 0){
                        System.out.println("Il n'y a plus assez de stock sur ce médicament");
                    }
                    else{
                        liste_médoc.replace(num_m, q_av, q_ap);
                        for(int j = 0 ; j < liste_medocs.size(); j++){
                            if (num_m.equals(liste_medocs.get(j).reference)){
                                // ajout de cet achat à l'historique du client
                                liste_clients.get(i).liste_achat.add(liste_medocs.get(j));
                                System.out.println("achat réussi");
                            }
                        }  
                    }      
                }
                else {
                    System.out.println("la ref n'a pas été trouvé");
                }
            }
        }    
    }

    public void ajout_medoc(String ref, String lib, String descrip, String prix, Integer Qt, HashMap<String,Integer> medocs,ArrayList<Medicament> list_m ) {
        Medicament m= new Medicament(ref, lib, descrip, prix, Qt);
        list_m.add(m);
        medocs.put(lib,Qt);
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
        ArrayList<Client> liste_clients=new ArrayList<Client>();
        ArrayList<Medicament> liste_medocs=new ArrayList<Medicament>();
        HashMap<String, Integer> liste_médoc = new HashMap<String, Integer>();

        Medicament doliprane = new Medicament("DLP500", "doliprane 500mg", "antalgique", "2,86 €", 1);
        Medicament maxilase = new Medicament("MAX", " maxilase", "toux", "5 €", 6);
        Medicament ibuprofene = new Medicament("IBU", " ibuprofène", "anti-inflamatoire", "4,5 €", 10);
        
        liste_medocs.add(doliprane);
        liste_medocs.add(maxilase);
        liste_medocs.add(ibuprofene);

        for( Medicament medoc : liste_medocs){
            liste_médoc.put(medoc.reference,medoc.quantite);
        }


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
        

        //recherche_client(liste_clients, "1234567898765");
        
        retrait_achat(liste_clients,liste_médoc,liste_medocs,"1234567898765","IBU", 12);

        // System.out.println(liste_médoc);

    

        
    }

    
}



