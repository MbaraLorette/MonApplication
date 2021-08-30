package modele;

public class Profil {

    private static final Integer minFemme = 15;
    private static final Integer maxFemme = 30;
    private static final Integer minHomme = 10;
    private static final Integer maxHomme = 25;

    private Integer Poids;
    private Integer Taille;
    private Integer Age;
    private Integer Sexe;
    private  float IMG;
    private  String Message;

    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
       this.Poids = poids;
        this.Taille = taille;
        this.Age = age;
        this.Sexe = sexe;
        this.calculeIMG();
        this.resultIMG();
    }

    public Integer getPoids() {
        return Poids;
    }

    public Integer getTaille() {
        return Taille;
    }

    public Integer getAge() {
        return Age;
    }

    public Integer getSexe() {
        return Sexe;
    }

    public float getIMG() {
        return IMG;
    }

    public String getMessage() {
        return Message;
    }

    private void calculeIMG(){
        float TailleM = (float)Taille/100;
        this.IMG = (float) ((1.2*Poids /(TailleM*TailleM))+(0.23*Age)-(10.83*Sexe)-5.4);
    }

    private void resultIMG(){

        Integer min;
        Integer max;
        if(Sexe==0){//femme
            min=minFemme;
            max=maxFemme;
        }else{//homme
            min=minHomme;
            max=maxHomme;
        }
        //message correspondant
        if(IMG<min){
            Message = "trop faible";
        }else{
            if(IMG>max){
                Message = "trop élevé";
            }
        }
    }
}
