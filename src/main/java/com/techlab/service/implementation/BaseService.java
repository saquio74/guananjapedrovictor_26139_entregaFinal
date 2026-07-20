package com.techlab.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techlab.entity.EntityBase;
import com.techlab.filter.FilterBase;
import com.techlab.mapper.IBaseMapper;
import com.techlab.service.interfaces.IBaseService;

public abstract class BaseService<TId, TE extends EntityBase<TId>, TD, Repo extends JpaRepository<TE, TId>, TM extends IBaseMapper<TId, TE, TD>>
        implements IBaseService<TId, TE, FilterBase, TD> {
    protected final Repo repository;
    protected final TM mapper;

    public BaseService(Repo repository, TM mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TD addEntity(TD dto) {
        TE ent = createData(dto);
        repository.save(ent);
        return mapper.toDto(ent);
    }

    @Override
    public void delete(TId id) {
        repository.deleteById(id);
    }

    @Override
    public TD getById(TId id) throws Exception {
        TE ent = repository.getReferenceById(id);
        if (ent == null)
            throw new Exception("No se encontro la entidad");
        return mapper.toDto(ent);
    }

    @Override
    public Page<TD> getFiltered(FilterBase filter) {
        int page = filter.getPage();
        int pageSize = filter.getSize();
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<TD> lista = repository.findAll(pageable).map(mapper::toDto);
        return lista;
    }

    @Override
    public TD updateEntity(TId id, TD dto) throws Exception {
        TE entity = this.repository.getReferenceById(id);
        if (entity == null)
            throw new Exception("No se encontro la entidad");
        updateData(dto, entity);
        entity = repository.save(entity);
        return null;
    }
    

    protected TE createData(TD dto) {
        return mapper.toEntity(dto);
    }

    protected void updateData(TD dto, TE entity) {
        mapper.updateEntity(dto, entity);
    }
}
