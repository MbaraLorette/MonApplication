package vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.orange.applilorette.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ecouteMenu((ImageButton)findViewById(R.id.btnMenuIMG),MainActivity.class);
        //ecouteMenu((ImageButton)findViewById(R.id.btnMenuHistorique),HistoriqueActivity.class);
    }

    /**
     * Ouvrir l'activité correspondant
     * @param btn
     * @param classe
     */
    private void ecouteMenu(ImageButton btn, final Class classe ){
      btn.setOnClickListener(new ImageButton.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }
}