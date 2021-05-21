package be.bxl.formation.demo_03_liste.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.bxl.formation.demo_03_liste.R;
import be.bxl.formation.demo_03_liste.models.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> peopleData;

    //region Création du type ViewHolder
    // -> Permet de définir les interactions possible
    //    sur les vues contenue par le RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvFirstname, tvLastname;

        public ViewHolder(View v) {
            super(v);

            // Liaison avec le layout
            tvFirstname = v.findViewById(R.id.tv_item_person_firstname);
            tvLastname = v.findViewById(R.id.tv_item_person_lastname);
        }

        public TextView getTvFirstname() {
            return tvFirstname;
        }

        public TextView getTvLastname() {
            return tvLastname;
        }
    }
    //endregion

    // Constructeur pour créer l'adapter avec des données
    public PersonAdapter(ArrayList<Person> people) {
        this.peopleData = people;
    }

    // Méthode qui permet de créer les vues contenue dans la liste
    // -> Utiliser par le LayoutManager
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Création de la vue sur base du layout qu'on a créer « item_person.xml »
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);

        // Renvoie la vue créée encapsuler dans un ViewHolder
        return new ViewHolder(v);
    }

    // Méthode qui permet de mettre à jours la vue avec les données
    // -> Utiliser par le LayoutManager
    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        // Récuperation des données a utiliser
        Person target = peopleData.get(position);

        // Mise a jours de la vue via le ViewHolder
        holder.getTvFirstname().setText(target.getFirstname());
        holder.getTvLastname().setText(target.getLastname());
    }

    // Méthode qui permet d'obtenir le nombre d'element dans la liste
    // -> Utiliser par le LayoutManager
    @Override
    public int getItemCount() {
        return peopleData.size();
    }
}
