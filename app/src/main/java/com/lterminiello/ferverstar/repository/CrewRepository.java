package com.lterminiello.ferverstar.repository;

import com.lterminiello.ferverstar.model.Member;
import io.reactivex.Single;
import java.util.List;

public interface CrewRepository {

    Single<List<Member>> getCrew();

}
