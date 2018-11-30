package com.lterminiello.ferverstar.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import com.lterminiello.ferverstar.usecase.UseCaseFactory;
import com.lterminiello.ferverstar.viewmodel.list.CrewListViewModel;

public class CrewViewModelFactory implements ViewModelProvider.Factory {

    private Context context;
    private UseCaseFactory useCaseFactory;

    public CrewViewModelFactory(final Context context, final UseCaseFactory useCaseFactory) {
        this.context = context;
        this.useCaseFactory = useCaseFactory;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull final Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CrewListViewModel.class)) {
            return (T) new CrewListViewModel(useCaseFactory.getCrewUseCase(), context);
        }
        throw new IllegalArgumentException("Wrong ViewModel class");
    }
}
