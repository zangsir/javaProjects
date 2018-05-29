package com.weely.zangsir.test_shuo;

public class SingleEntityResult<T> {
	private final T idResult;
    private final T nameResult;
    

    public static <T> SingleEntityResult<T> create(T idResult, T nameResult) {
        return new SingleEntityResult<>(idResult, nameResult);
    }

    private SingleEntityResult(T idResult, T nameResult) {
        this.idResult = idResult;
        this.nameResult = nameResult;
       
    }

    public T getIdResult() {
        return idResult;
    }

    public T getNameResult() {
        return nameResult;
    }

    
}
