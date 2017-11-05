package com.acv.randomuser.domain.mapper;

public interface TwoWaysMapper<M, P> extends Mapper<M, P> {
    M inverseMap(P model);
}