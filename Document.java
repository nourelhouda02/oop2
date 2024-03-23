public class Document {
    public String titre;
    public static int nbr = 0;

    public Document() {
        nbr++;
    }

    public Document(String titre) {
        this.titre = titre;
        nbr++;
    }

    public void affiche() {
        System.out.println("Le Titre est : " + titre);
    }

    public static class Livre extends Document {
        String editeur;
        String auteur;

        public Livre(String titre, String editeur, String auteur) {
            super(titre);
            this.editeur = editeur;
            this.auteur = auteur;
        }
    }

    public static class Internet extends Document {
        String URL;

        public Internet(String titre, String URL) {
            super(titre);
            this.URL = URL;
        }
    }

    static class Bibliotheque {
        Document[] documents;
        int n;

        Bibliotheque(int n) {
            documents = new Document[n];
            this.n = n;
        }

        void ajouter(Document d) {
            // stop condition
            for (int i = 0; i < n; i++) {
                if (documents[i] == null) {
                    documents[i] = d;
                    return;
                }
            }
        }

        void listing() {
            System.out.println("Contenu de la bibliotheque est\n:");
            for (int i = 0; i < n; i++) {
                Document d = documents[i];
                if (d != null) {
                    d.affiche();
                    System.out.println();
                }
            }
        }

    }

    public static void main(String[] args) {

        Bibliotheque library = new Bibliotheque(5);

        library.ajouter(new Document("Document 1"));

        library.ajouter(new Document.Livre("Livre 1", "Editeur 1", "Auteur 1"));

        library.ajouter(new Document.Internet("Internet 1", "https://example.com"));

        library.ajouter(new Document.Livre("Livre 2", "Editeur 2", "Auteur 2"));

        library.ajouter(new Document("Document 2"));

        library.listing();
    }
}
