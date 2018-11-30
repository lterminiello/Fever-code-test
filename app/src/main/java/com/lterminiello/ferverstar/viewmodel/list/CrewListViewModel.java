package com.lterminiello.ferverstar.viewmodel.list;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableBoolean;
import com.lterminiello.ferverstar.model.Member;
import com.lterminiello.ferverstar.usecase.DefaultUseCaseCallback;
import com.lterminiello.ferverstar.usecase.UseCaseUtils;
import com.lterminiello.ferverstar.usecase.crew.CrewUseCase;
import com.lterminiello.ferverstar.utils.Lists;
import java.util.List;

public class CrewListViewModel extends ViewModel implements DefaultUseCaseCallback<List<Member>> {

    private CrewUseCase crewUseCase;

    private ObservableBoolean availabilityItems = new ObservableBoolean(false);
    private ObservableBoolean loading = new ObservableBoolean(false);

    private MutableLiveData<List<Member>> memberData = new MutableLiveData<>();

    public CrewListViewModel(CrewUseCase crewUseCase, final Context context) {
        this.crewUseCase = crewUseCase;
        this.crewUseCase.setDefaultUseCaseCallback(this);
    }

    public void getCrew() {
        crewUseCase.cancel();
        UseCaseUtils.execute(crewUseCase);
    }

    @Override
    public void onStart() {
        loading.set(Lists.isNullOrEmpty(memberData.getValue()));
        availabilityItems.set(!Lists.isNullOrEmpty(memberData.getValue()));
    }

    @Override
    public void onSuccess(final List<Member> response) {
        loading.set(false);
        memberData.setValue(response);
            availabilityItems.set(true);
    }

    @Override
    public void onError(final String message) {
    }

    public ObservableBoolean getAvailabilityItems() {
        return availabilityItems;
    }

    public ObservableBoolean getLoading() {
        return loading;
    }

    public MutableLiveData<List<Member>> getMemberData() {
        return memberData;
    }
}
