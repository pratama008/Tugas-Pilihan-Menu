package com.example.pilihanmenu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMenu;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMenu = findViewById(R.id.recyclerViewMenu);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));

        List<MenuItem> menuItems = generateSampleMenuItems();

        menuAdapter = new MenuAdapter(menuItems, this);
        recyclerViewMenu.setAdapter(menuAdapter);
    }


    private List<MenuItem> generateSampleMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem(R.drawable.food1, "Tempe Bacem",
                "Tempe yang dibacem.", 2000));

        menuItems.add(new MenuItem(R.drawable.food2, "Ayam Bakar",
                "Ayam dibakar kecap.", 8000));

        menuItems.add(new MenuItem(R.drawable.food3, "Lontong Tuyuhan",
                "Lontong opor + ayam.", 15000));

        return menuItems;
    }

}
