import java.util.*;
import java.util.HashMap; // import the HashMap class


public class Client {
    String nom, prenom;
    String numero_secu;
    String adresse;
    String num_tel;
    ArrayList<Medicament> liste_achat = new ArrayList();

    public Client(String n, String p, String secu, String ad, String tel){
        this.nom=n;
        this.prenom=p;
        this.numero_secu=secu; 
        this.adresse=ad;
        this.num_tel=tel;

    }

    public void affichage_client(){
        System.out.println("Nom : " + this.nom + "\nPrénom : " + this.prenom + "\nNuméro de sécurité sociale : " + this.numero_secu + "\nAdresse : " + this.adresse + "\nNuméro de téléphone : " + this.num_tel);
    }

    
    
}
