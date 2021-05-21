package be.bxl.formation.demo_03_liste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import be.bxl.formation.demo_03_liste.models.Person;

public class DemoListeActivity extends AppCompatActivity {

    ListView lvDemo;
    Button btnAdd;

    //region Exemple 1
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_liste);

        // Récuperation de la listeView
        lvDemo = findViewById(R.id.lv_demo_liste);

        // Collection JAVA avec les données
        ArrayList<String> names = new ArrayList<>();
        names.add("Zaza");
        names.add("Riri");
        names.add("Daisy");
        names.add("Donald");
        names.add("Della");

        // Adapter -> Qui a le role d'effectuer la liaison entre les données et la vue
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                names
        );
        lvDemo.setAdapter(adapter);

        // Ajoute d'un element dans la liste
        btnAdd = findViewById(R.id.btn_demo_liste_add);
        btnAdd.setOnClickListener(v -> {
            names.add("Boum");
            adapter.notifyDataSetChanged();
        });
    }
    */
    //endregion

    //region Exemple 2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_liste);

        // Récuperation de la listeView
        lvDemo = findViewById(R.id.lv_demo_liste);

        // Collection JAVA avec les données
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Zaza", "Vanderquack", Person.Gender.FEMALE));
        people.add(new Person("Donald", "Duck", Person.Gender.MALE));
        people.add(new Person("Daisy", "Duck",  Person.Gender.FEMALE));
        people.add(new Person("Balthazar", "Picsou", Person.Gender.MALE));
        people.add(new Person("Della", "Duck",  Person.Gender.FEMALE));


        // Pour le SimpleAdpater => Il est necessaire de créer une liste de dico
        ArrayList<HashMap<String, String>> dataSource = new ArrayList<>();
        for(Person p : people) {
            HashMap<String, String> decomposition = new HashMap<>();
            decomposition.put("prenom", p.getFirstname());
            decomposition.put("nom", p.getLastname());
            dataSource.add(decomposition);
        }

        // Adapter -> Qui a le role d'effectuer la liaison entre les données et la vue
        SimpleAdapter adapter = new SimpleAdapter(
                getApplicationContext(),
                dataSource,
                android.R.layout.simple_list_item_2,
                new String[] { "prenom", "nom" },
                new int[] { android.R.id.text1, android.R.id.text2 }
        );
        lvDemo.setAdapter(adapter);


        // Ajoute d'un element dans la liste
        btnAdd = findViewById(R.id.btn_demo_liste_add);
        btnAdd.setOnClickListener(v -> {
            people.add(new Person("Riri", "Duck", Person.Gender.MALE));
            adapter.notifyDataSetChanged();
        });
    }
    //endregion
}