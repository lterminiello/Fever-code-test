package com.lterminiello.ferverstar.usecase;

import com.lterminiello.ferverstar.repository.CrewRepositoryImp;
import com.lterminiello.ferverstar.usecase.crew.CrewUseCase;

public class UseCaseFactory {


    public CrewUseCase getCrewUseCase() {
        return new CrewUseCase(CrewRepositoryImp.getInstance());
    }
}
