package com.techlab.mapper;

import java.util.List;

import org.mapstruct.MappingTarget;

import com.techlab.entity.EntityBase;


public interface IBaseMapper<TId, TE extends EntityBase<TId>, Dto> {
    Dto toDto(TE entity);
    List<Dto> toListDto(List<TE> entities);
    TE toEntity(Dto dto);
    void updateEntity(Dto dto, @MappingTarget TE ent);

}
