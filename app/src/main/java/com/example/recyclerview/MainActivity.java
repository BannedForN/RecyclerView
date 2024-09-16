package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);

        StateAdapter.OnStateClickListener stateClickListener = new StateAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(State state, int position) {
                Toast.makeText(getApplicationContext(), "Выбрана " + state.getName(),
                        Toast.LENGTH_SHORT).show();
                if (state.getName() == "КНДР")
                {
                    Intent intent = new Intent(MainActivity.this, DPRKActivity.class);
                    startActivity(intent);
                } else if (state.getName() == "Республика Корея") {
                    Intent intent = new Intent(MainActivity.this, RKActivity.class);
                    startActivity(intent);
                } else if (state.getName() == "Монголия") {
                    Intent intent = new Intent(MainActivity.this, MongolActivity.class);
                    startActivity(intent);
                }
            }
        };

        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, states, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        states.add(new State ("КНДР", "Пхеньян", R.drawable.flag_of_north_korea));
        states.add(new State ("КНДР", "Пхеньян", R.drawable.flag_of_north_korea));
        states.add(new State ("КНДР", "Пхеньян", R.drawable.flag_of_north_korea));
        states.add(new State ("Республика Корея", "Сеул", R.drawable.flag_of_south_korea));
        states.add(new State ("КНДР", "Пхеньян", R.drawable.flag_of_north_korea));
        states.add(new State ("КНДР", "Пхеньян", R.drawable.flag_of_north_korea));
        states.add(new State ("Республика Корея", "Сеул", R.drawable.flag_of_south_korea));
        states.add(new State ("Республика Корея", "Сеул", R.drawable.flag_of_south_korea));
        states.add(new State ("Республика Корея", "Сеул", R.drawable.flag_of_south_korea));
        states.add(new State ("Монголия", "Улан-Батор", R.drawable.flag_of_mongolia));
        states.add(new State ("Монголия", "Улан-Батор", R.drawable.flag_of_mongolia));
        states.add(new State ("Монголия", "Улан-Батор", R.drawable.flag_of_mongolia));
        states.add(new State ("Монголия", "Улан-Батор", R.drawable.flag_of_mongolia));

    }
}