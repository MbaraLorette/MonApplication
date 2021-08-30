package controleur;

import modele.Profil;
import vue.MainActivity;

public final class Controle {

    private static Controle instance = null;
    private  Profil profil ;

    /**
     * constructeur private
     */

    private Controle(){
        super();
    }

    /**
     * création de l'instance
     * @return instance
     */

    public static final
    Controle getInstance(){
        if(Controle.instance == null){
            Controle.instance=new Controle();
        }
        return Controle.instance;
    }

    /**
     * création du profil
     * @param Poids
     * @param Taille en cm
     * @param Age
     * @param Sexe 1pour homme et 0 pour femme
     */

    public void creerProfil(Integer Poids, Integer Taille, Integer Age, Integer Sexe){
        profil= new Profil(Poids,Taille,Age,Sexe);
    }

    //public void setProfil(Profil profil){
       // Controle.profil=profil;
       // ((MainActivity) contexte).recupProfil();
   // }

    /**
     * récupération img de profil
     * @return img
     */

    public float getIMG(){
        return profil.getIMG();
    }

    /**
     * récupération img de profil
     * @return message
     */
    public  String getMessage(){
        return profil.getMessage();
    }
}
