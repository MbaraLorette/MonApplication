package vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.orange.applilorette.R;

import controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controle = Controle.getInstance();
    }

    //propriétés
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgsmile;
    private Controle controle;

    /**
    initialisation des liens avec les objets graphiques
     */


    private void init(){
        txtPoids = (EditText)findViewById(R.id.txtPoids);
        txtTaille = (EditText)findViewById(R.id.txtTaille);
        txtAge = (EditText)findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgsmile=(ImageView) findViewById(R.id.imgSmile);
        ecouteCalcul();
        ecouteRetourMenu();
    }

    /**
     * Ecoute évènement sur bouton calcul
     */

    private void ecouteCalcul(){
        ((Button)findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "text", Toast.LENGTH_SHORT).show();

                Integer Poids = 0;
                Integer Taille= 0;
                Integer Age = 0;
                Integer Sexe = 0;
                //récupération des données saisies
                try{
                    Poids = Integer.parseInt(txtPoids.getText().toString());
                    Taille = Integer.parseInt(txtTaille.getText().toString());
                    Age = Integer.parseInt(txtAge.getText().toString());
                }catch (Exception e) { };
                if(rdHomme.isChecked()){
                    Sexe=0;
                }
                //controle des données saisies
                if(Poids==0 || Taille==0 || Age==0){
                    Toast.makeText(MainActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();
                }else{

                afficheResult(Poids,Taille,Age, Sexe);
                }


            }
        });

    }

    /**
     * Affichage de l'img du message et de l'image
     * @param Poids
     * @param Taille
     * @param Age
     * @param Sexe
     */
    private void afficheResult(Integer Poids, Integer Taille, Integer Age, Integer Sexe){
        //création du profil et récupération des informations
        this.controle.creerProfil(Poids,Taille,Age,Sexe);
        float IMG =this.controle.getIMG();
        String Message = this.controle.getMessage();
        //affichage
        if(Message=="normal"){
            imgsmile.setImageResource(R.drawable.image2);
            lblIMG.setTextColor(Color.GREEN);
        }else{
            lblIMG.setTextColor(Color.RED);
            if(Message=="trop faible"){
                imgsmile.setImageResource(R.drawable.image1);
            }else{
                imgsmile.setImageResource(R.drawable.image3);
            }
        }
        lblIMG.setText(String.format("%.01f",IMG)+ " :IMG " +Message);
    }
    //ecoute retour
    private void ecouteRetourMenu( ){
        ((ImageButton)findViewById(R.id.btnRetourCalcul)).setOnClickListener(new ImageButton.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });


    }
}