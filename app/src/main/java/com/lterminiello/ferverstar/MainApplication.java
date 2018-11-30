package com.lterminiello.ferverstar;

import android.app.Application;
import android.content.Context;

import com.lterminiello.ferverstar.usecase.UseCaseFactory;
import com.lterminiello.ferverstar.viewmodel.CrewViewModelFactory;

public class MainApplication extends Application {

    private static CrewViewModelFactory crewViewModelFactory;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static CrewViewModelFactory getCrewViewModelFactory() {
        if (crewViewModelFactory == null) {
            crewViewModelFactory = new CrewViewModelFactory(getAppContext(), new UseCaseFactory());
        }
        return crewViewModelFactory;
    }

    public static Context getAppContext() {
        return context;
    }
}
