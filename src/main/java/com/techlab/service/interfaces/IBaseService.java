package com.techlab.service.interfaces;

import org.springframework.data.domain.Page;

import com.techlab.entity.EntityBase;
import com.techlab.filter.FilterBase;

public interface IBaseService<TId, E extends EntityBase<TId>, Filter extends FilterBase, TDto> {
    TDto getById(TId id) throws Exception;

    Page<TDto> getFiltered(Filter filter);

    TDto addEntity(TDto dto);

    void delete(TId id) throws Exception;

    TDto updateEntity(TId id, TDto dto) throws Exception;
}