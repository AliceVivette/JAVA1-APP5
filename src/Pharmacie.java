//import

import java.util.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.HashMap; // import the HashMap class

public class Pharmacie {

    

    public static void appro_stock(String ref,Integer quantité, HashMap<String,Integer> medoc, ArrayList<Medicament> hash_medoc){
        for (int i=0; i<hash_medoc.size(); i++ ){
            if(ref.equals(hash_medoc.get(i).reference)){
                Integer quantity = medoc.get(ref);
                quantity+=quantité;
                medoc.replace(ref, quantity);
            }
        }
    }

    public static void retrait_achat(ArrayList<Client> liste_clients, HashMap<String, Integer> array_medoc,ArrayList<Medicament> hash_medoc, String num_c, String num_m, int q){
        for(int i = 0 ; i < liste_clients.size(); i++){
            if (num_c.equals(liste_clients.get(i).numero_secu)){
                // on trouve le client
                if (array_medoc.get(num_m)!=null){
                    // si la ref existe, on retire la quantité désirée au stock
                    int q_av = array_medoc.get(num_m);
                    int q_ap = q_av - q;
                    if (q_ap < 0){
                        System.out.println("Il n'y a plus assez de stock sur ce médicament");
                    }
                    else{
                        array_medoc.replace(num_m, q_av, q_ap);
                        for(int j = 0 ; j < hash_medoc.size(); j++){
                            if (num_m.equals(hash_medoc.get(j).reference)){
                                // ajout de cet achat à l'historique du client
                                liste_clients.get(i).liste_achat.add(hash_medoc.get(j));
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

    public static void ajout_medoc(String ref, String lib, String descrip, String prix, Integer Qt, HashMap<String,Integer> medocs,ArrayList<Medicament> list_m ) {
        Medicament m= new Medicament(ref, lib, descrip, prix, Qt);
        list_m.add(m);
        medocs.put(lib,Qt);
    }

    public void ajout_client(String nom, String prenom, String num_secu, String adresse, String tel, ArrayList<Client> list_c){
        Client c = new Client(nom, prenom, num_secu, adresse, tel);
        list_c.add(c);
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
        ArrayList<Medicament> hash_medoc=new ArrayList<Medicament>();
        HashMap<String, Integer> array_medoc = new HashMap<String, Integer>();


        

        //Médicament 
        Medicament doliprane = new Medicament("DLP500", "doliprane 500mg", "antalgique", "2,86 €", 1);
        Medicament maxilase = new Medicament("MAX", " maxilase", "toux", "5 €", 6);
        Medicament ibuprofene = new Medicament("IBU", " ibuprofène", "anti-inflamatoire", "4,5 €", 10);
        
        //ajout des médoc dans une ArrayList
        hash_medoc.add(doliprane);
        hash_medoc.add(maxilase);
        hash_medoc.add(ibuprofene);

        //ajout des médoc dans la Hashmap
        for( Medicament medoc : hash_medoc){
            array_medoc.put(medoc.reference,medoc.quantite);
        }

        //création de Clients
       // Client c1 = new Client("ROY", "Victorine", "2020778158258", "Chateau de Versailles", "06 62 03 12 96");
        //Client c2 = new Client("VIVET", "Alice", "1234567898765", "Chateau de Versailles", "06 62 03 12 96");

        
        
        //Création de la fenêtre
        JFrame f=new JFrame();
	
		// JMenuBar menu=new JMenuBar();
        // menu.setLayout(new GridLayout(0,1));
        
        JToolBar toolbar = new JToolBar("Applications");
        
        JButton AddMedicament = new JButton();
        JButton AddClient = new JButton();
        JButton AddStock = new JButton();
        JButton Buy = new JButton();
        JButton SearchCustomer = new JButton();
        JButton Exit = new JButton();

        toolbar.add(AddMedicament);
        toolbar.add(AddClient);
        toolbar.add(AddStock);
        toolbar.add(Buy);
        toolbar.add(SearchCustomer);
        toolbar.add(Exit);
        toolbar.setRollover(true);
        ;
        // JMenuItem AddMedicament=new JMenuItem("+ Médicaments");
		// JMenuItem AddClient=new JMenuItem("+ Client");
		// JMenuItem AddStock =new JMenuItem("Ajout stock");
		// JMenuItem Buy=new JMenuItem("Achat");
		// JMenuItem SearchCustumer=new JMenuItem("Recherche client");
		// JMenuItem Exit=new JMenuItem("Fermer");

		// menu.add(AddMedicament);
		// menu.add(AddClient);
		// menu.add(AddStock);
        // menu.add(Buy);
		// menu.add(SearchCustumer);
		// menu.add(Exit);

        //Action items 
		Exit.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});


        f.setLayout(new BorderLayout());
        f.getContentPane().add(toolbar, BorderLayout.PAGE_START);
		f.setVisible(true);
		f.setSize(600,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Best Pharmacie");



        
		AddClient.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                JFrame jf=new JFrame();
				JTextField getNOM = new JTextField ("Entrez le nom du client");
                JTextField getPRENOM = new JTextField ("Entrez le prenom du client");
                JTextField getSECU = new JTextField ("Entrez le numéro de sécurité sociale du client");
                JTextField getADRESSE = new JTextField ("Entrez l'adresse du client");
                JTextField getTEL = new JTextField ("Entrez le numéro de téléphone du client");

				
                jf.add(getNOM);
                jf.add(getPRENOM);
                jf.add(getSECU);
                jf.add(getADRESSE);
                jf.add(getTEL);

                jf.setSize(150,250);
				jf.setLocationRelativeTo(null);
				jf.setVisible(true);
                Client C = new Client(getNOM.getText(), getPRENOM.getText(), getSECU.getText(), getADRESSE.getText(), getTEL.getText());

                
                // Verifier Exception sur numero sécu
                try {     
                check_num(C.numero_secu);  
                liste_clients.add(C);
                }  
                catch (Num_Exception ex){     
                System.out.println(ex);  
                }

            }
        });

        AddMedicament.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                JFrame f =new JFrame();                
                
                JTextField Ref,Lib, Des, Prix, Qtt; 
                Ref=new JTextField("Référence médicament");
                Ref.setBounds(50,100, 200,30); 
                f.add(Ref);

                Lib=new JTextField("Libellé médicament");
                Lib.setBounds(50,100, 200,30);
                f.add(Lib);

                Des=new JTextField("Description médicament");
                Des.setBounds(50,100, 200,30);
                f.add(Des);

                Prix=new JTextField("Prix médicament");
                Prix.setBounds(50,100, 200,30);
                f.add(Prix);

                Qtt=new JTextField("Quantité médicament");
                Qtt.setBounds(50,100, 200,30);
                f.add(Qtt);
                Integer Qt = Integer.parseInt(Qtt.getText());

                f.setSize(400,400);
                f.setLayout(null);
                f.setVisible(true);
				ajout_medoc(Ref.getText(), Lib.getText(), Des.getText(), Prix.getText(), Qt, array_medoc, hash_medoc);
                
            }});
            
        AddStock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

                JFrame jf=new JFrame();

				String ref = JOptionPane.showInputDialog(jf, "Entrez la référence du médicament");
            	String Qt = JOptionPane.showInputDialog(jf, "Entrez la quantité à ajouter au stock");
                Integer qt=Integer.parseInt(Qt);
                appro_stock(ref, qt, array_medoc, hash_medoc);
                
            }});


       SearchCustomer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
                JFrame jFrame=new JFrame();
                String sécu = JOptionPane.showInputDialog(jFrame, "Entrez le numéro de sécu ");
                recherche_client(liste_clients, sécu);
                
            }});

        Buy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){


            }});
        
        
        //recherche_client(liste_clients, "1234567898765");
        
        //retrait_achat(liste_clients,array_medoc,hash_medoc,"1234567898765","IBU", 12);

        // System.out.println(array_medoc);

    

        
    }

    
}



