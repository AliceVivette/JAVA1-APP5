import java.util.HashMap; // import the HashMap class


public class Medicament {
    String reference;
    String libelle;
    String description;
    String prix_vente;
    int quantite;

    public Medicament(String ref, String lib, String descript, String prix, int qt){
        this.reference=ref;
        this.libelle=lib;
        this.description=descript;
        this.prix_vente=prix;
        this.quantite=qt;
        
    }

    public String affichage_médoc(){
        return "Référence : " + this.reference + "\nLibellé : " + this.libelle + "\nDescription : " + this.description + "\nPrix de vente : " + this.prix_vente + "\nQuantité : " + this.quantite;
    }

}
