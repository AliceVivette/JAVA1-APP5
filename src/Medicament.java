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

    
}
