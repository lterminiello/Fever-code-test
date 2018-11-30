package com.lterminiello.ferverstar.usecase.crew;

import com.lterminiello.ferverstar.model.Member;
import com.lterminiello.ferverstar.repository.CrewRepository;
import com.lterminiello.ferverstar.usecase.AbstractBaseUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class CrewUseCase extends AbstractBaseUseCase<List<Member>> {

    private CrewRepository crewRepository;

    public CrewUseCase(final CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    @Override
    public Disposable doExecute() {
        if (useCaseDisposable == null || useCaseDisposable.isDisposed()) {
            getDefaultUseCaseCallback().onStart();
            useCaseDisposable = crewRepository.getCrew()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    crewList -> {
                        getDefaultUseCaseCallback().onSuccess(crewList);
                    },
                    throwable -> getDefaultUseCaseCallback().onError(throwable.getMessage())
                );
        }
        return useCaseDisposable;
    }
}
