package com.lterminiello.ferverstar.view;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.lterminiello.ferverstar.R;
import com.lterminiello.ferverstar.usecase.UseCaseFactory;
import com.lterminiello.ferverstar.view.list.CrewListFragment;
import com.lterminiello.ferverstar.viewmodel.CrewViewModelFactory;

public class CrewActivity extends AppCompatActivity {

    private CrewViewModelFactory crewViewModelFactory;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.crew_activity);

        crewViewModelFactory = new CrewViewModelFactory(getApplicationContext(), new UseCaseFactory());

        if (savedInstanceState == null) {
            CrewListFragment fragment = CrewListFragment.newInstance(crewViewModelFactory);
            getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment, CrewListFragment.TAG).commit();
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
