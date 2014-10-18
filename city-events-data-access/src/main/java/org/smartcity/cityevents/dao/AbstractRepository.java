package org.smartcity.cityevents.dao;

import org.smartcity.cityevents.entities.BaseEntity;

import java.io.Serializable;

public interface AbstractRepository<PK extends Serializable, Entity extends BaseEntity> {

    // Create operations
    public Integer save(Entity entity);

    // Read operations
    public Entity get(PK primaryKey);

    // Update operations
    public void update(Entity entity);

    // Delete operations
    public void delete(PK primaryKey);
}
