package com.lterminiello.ferverstar.usecase;

public interface DefaultUseCaseCallback<T> {

    void onStart();
    void onSuccess(T response);
    void onError(String message);

}
