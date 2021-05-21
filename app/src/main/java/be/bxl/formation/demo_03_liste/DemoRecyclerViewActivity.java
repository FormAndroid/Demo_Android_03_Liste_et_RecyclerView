package be.bxl.formation.demo_03_liste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

import be.bxl.formation.demo_03_liste.adapters.PersonAdapter;
import be.bxl.formation.demo_03_liste.models.Person;

public class DemoRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_recycler_view);

        // Créer les données
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Zaza", "Vanderquack", Person.Gender.FEMALE));
        people.add(new Person("Donald", "Duck", Person.Gender.MALE));
        people.add(new Person("Daisy", "Duck",  Person.Gender.FEMALE));
        people.add(new Person("Balthazar", "Picsou", Person.Gender.MALE));
        people.add(new Person("Della", "Duck",  Person.Gender.FEMALE));

        // Liaison avec le layout
        rvDemo = findViewById(R.id.rv_demo_recyclerview);
        rvDemo.setHasFixedSize(false);

        // Définir du type de layout que le RecyclerView utilise (Linear/Grid/StaggeredGrid)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvDemo.setLayoutManager(layoutManager);

        // Création de l'adpater (-> Classe qu'on va créer)
        PersonAdapter adapter = new PersonAdapter(people);

        // Definir l'adapter de la Recycler View
        rvDemo.setAdapter(adapter);
    }
}