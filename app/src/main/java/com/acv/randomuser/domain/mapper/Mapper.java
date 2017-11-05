package com.acv.randomuser.domain.mapper;

public interface Mapper<M, P> {
    P map(M model);
}