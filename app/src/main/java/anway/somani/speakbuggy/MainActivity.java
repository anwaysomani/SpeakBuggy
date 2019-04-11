package anway.somani.speakbuggy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView carsObjects;
    Spinner categories;
    ArrayAdapter<BuggyCategory> adapter;

    // Write the names of car brands in here
    String[] allCategories = {"A1", "A2", "A3", "A4", "A5", "A6"};

    private void initializeViews() {

        categories = (Spinner) findViewById(R.id.category);
        categories.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allCategories));

//        loadSpinnerData();

        carsObjects = (ListView) findViewById(R.id.carItems);
        carsObjects.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getBuggies()));

        categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0 && position < allCategories.length) { getSelectedCategoryData(position); }
                else { Toast.makeText(MainActivity.this, "Selected Category has no data!", Toast.LENGTH_SHORT).show(); }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        carsObjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, WebLinkViewer.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<BuggyCategory> getBuggies() {
        ArrayList<BuggyCategory> data = new ArrayList<>();
        data.clear();

        data.add(new BuggyCategory("A1", 1));
        data.add(new BuggyCategory("A2", 2));
        data.add(new BuggyCategory("A3", 3));
        data.add(new BuggyCategory("A4", 4));
        data.add(new BuggyCategory("A5", 5));
        data.add(new BuggyCategory("A6", 1));
        data.add(new BuggyCategory("A7", 2));
        data.add(new BuggyCategory("A8", 3));
        data.add(new BuggyCategory("A9", 4));
        data.add(new BuggyCategory("A10", 5));
        data.add(new BuggyCategory("A11", 1));
        data.add(new BuggyCategory("A12", 2));
        data.add(new BuggyCategory("A13", 3));
        data.add(new BuggyCategory("A14", 4));
        data.add(new BuggyCategory("A15", 5));

        return data;
    }

    private void getSelectedCategoryData(int categoryID) {
        ArrayList<BuggyCategory> getBuggies = new ArrayList<>();
        if(categoryID == 0) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getBuggies);
        } else {
            for(BuggyCategory buggyCategory: getBuggies()) {
                if(buggyCategory.getCategoryID() == categoryID) {
                    getBuggies.add(buggyCategory);
                }
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getBuggies);
        }

        carsObjects.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }
}

class BuggyCategory {
    private String name;
    private int categoryID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public BuggyCategory(String name, int categoryID) {
        this.name = name;
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return name;
    }


}
