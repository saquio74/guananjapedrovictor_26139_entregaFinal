package com.techlab.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.entity.EntityBase;
import com.techlab.filter.FilterBase;
import com.techlab.mapper.IBaseMapper;
import com.techlab.service.implementation.BaseService;

@RestController
public abstract class BaseController<TId, TE extends EntityBase<TId>, Dto, Repo extends JpaRepository<TE, TId>, Map extends IBaseMapper<TId, TE, Dto>, TS extends BaseService<TId, TE, Dto, Repo, Map>, TF extends FilterBase> {
    protected TS service;

    public BaseController(TS service) {
        this.service = service;
    }
    
    @GetMapping
    public Page<Dto> getAll( TF filter){
        return this.service.getFiltered(filter);
    }

    @GetMapping("/{id}")
    public Dto getById(@PathVariable TId id) throws Exception {
        return this.service.getById(id);
    }

    @PostMapping()
    public Dto createResource(@RequestBody Dto dto) {
        return this.service.addEntity(dto);
    }

    @PutMapping("/{id}")
    public Dto updateResource(@RequestBody Dto dto, @PathVariable TId id) throws Exception{
        return this.service.updateEntity(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable TId id)  {
        this.service.delete(id);
    }
}
