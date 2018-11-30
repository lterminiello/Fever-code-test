package com.lterminiello.ferverstar.repository;

import com.lterminiello.ferverstar.model.Member;
import com.lterminiello.ferverstar.utils.GeneratorCrew;
import io.reactivex.Single;
import java.util.List;

public class CrewRepositoryImp implements CrewRepository {

    private static CrewRepositoryImp instance;

    public static CrewRepositoryImp getInstance() {
        if (instance == null) {
            instance = new CrewRepositoryImp();
        }

        return instance;
    }

    public CrewRepositoryImp() {
    }

    @Override
    public Single<List<Member>> getCrew() {
        Single<List<Member>> resultSingle = Single.just(GeneratorCrew.getCrew());
        return resultSingle;
    }
}
