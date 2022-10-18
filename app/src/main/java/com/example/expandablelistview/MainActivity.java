package com.example.expandablelistview;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expLV;
    private ExpLVAdapter adapter;
    private List<String> listCategorias;
    private Map<String, List<Animal>> mapChild;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expLV = findViewById(R.id.expLV);
        listCategorias = new ArrayList<>();
        mapChild = new HashMap<>();

        cargarDatos();
    }

    private void cargarDatos(){
        List<Animal> listAves = new ArrayList<>();
        List<Animal> listMamiferos = new ArrayList<>();
        List<Animal> listReptiles = new ArrayList<>();
        List<Animal> listPeces = new ArrayList<>();

        listCategorias.add("Aves");
        listCategorias.add("Mamiferos");
        listCategorias.add("Reptiles");
        listCategorias.add("Peces");

        listAves.add(new Animal("Loro", R.drawable.ave));
        listAves.add(new Animal("Aguila", R.drawable.ave));
        listAves.add(new Animal("Pajaros", R.drawable.ave));

        listMamiferos.add(new Animal("Perro", R.drawable.mamifero));
        listMamiferos.add(new Animal("Gato", R.drawable.mamifero));
        listMamiferos.add(new Animal("Ballena", R.drawable.mamifero));

        listReptiles.add(new Animal("Cocodrilo", R.drawable.reptil));
        listReptiles.add(new Animal("Lagartija", R.drawable.reptil));

        listPeces.add(new Animal("Caballa", R.drawable.peces));
        listPeces.add(new Animal("Jurel", R.drawable.peces));

        mapChild.put(listCategorias.get(0), listAves);
        mapChild.put(listCategorias.get(1), listMamiferos);
        mapChild.put(listCategorias.get(2), listReptiles);
        mapChild.put(listCategorias.get(3), listPeces);

        adapter = new ExpLVAdapter(this, listCategorias, mapChild);
        expLV.setGroupIndicator(null);
        expLV.setAdapter(adapter);
    }

    public class Animal {
        private String name;
        private int image;

        public Animal(String name, int image) {
            this.name = name;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public int getImage() {
            return image;
        }
    }
}
