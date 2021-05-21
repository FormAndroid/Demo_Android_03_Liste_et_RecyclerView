package be.bxl.formation.demo_03_liste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnListe, btnReclycer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListe = findViewById(R.id.btn_main_liste);
        btnReclycer = findViewById(R.id.btn_main_recyclerview);

        btnListe.setOnClickListener(this);
        btnReclycer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_liste:
                openListActivity();
                break;
            case R.id.btn_main_recyclerview:
                openRecyclerActivity();
        }
    }

    private void openListActivity() {
        Intent intentList = new Intent(getApplicationContext(), DemoListeActivity.class);
        startActivity(intentList);
    }

    private void openRecyclerActivity() {
        Intent intentRecycler = new Intent(getApplicationContext(), DemoRecyclerViewActivity.class);
        startActivity(intentRecycler);
    }
}