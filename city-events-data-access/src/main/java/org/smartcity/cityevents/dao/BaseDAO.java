package org.smartcity.cityevents.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.smartcity.cityevents.entities.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;

@Repository
@SuppressWarnings("unchecked")
public abstract class BaseDAO<PK extends Serializable, Entity extends BaseEntity> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Integer saveEntity(Entity entity) {
        Assert.notNull(entity, "Invalid / null entity");

        Session session = sessionFactory.getCurrentSession();

        return (Integer) session.save(entity);
    }

    protected Entity get(Class<Entity> entityClass, PK primaryKey) {
        Assert.notNull(primaryKey, "Invalid / null primary key");

        Session session = sessionFactory.getCurrentSession();

        return (Entity) session.get(entityClass, primaryKey);
    }

    protected Entity getByProperty(Class<Entity> entityClass, String filterName, String filterValue) {
        Assert.notNull(filterName, "Invalid filter name");
        Assert.notNull(filterValue, "Invalid filter value");

        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(entityClass);
        criteria.add(Restrictions.eq(filterName, filterValue));

        List<Entity> entities = (List<Entity>) criteria.list();
        if (CollectionUtils.isEmpty(entities)) {
            return null;
        }

        return entities.iterator().next();
    }

    protected List<Entity> getListByProperty(Class<Entity> entityClass, String filterName, String filterValue) {
        Assert.notNull(filterName, "Invalid filter name");
        Assert.notNull(filterValue, "Invalid filter value");

        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(entityClass);
        criteria.add(Restrictions.eq(filterName, filterValue));

        return (List<Entity>) criteria.list();
    }

    protected void updateEntity(Entity entity) {
        Assert.notNull(entity, "Null entity");

        Session session = sessionFactory.getCurrentSession();

        session.update(entity);
        session.flush();
    }

    protected void deleteEntity(Class<Entity> entityClass, PK primaryKey) {
        Assert.notNull(primaryKey, "Null primaryKey");

        Session session = sessionFactory.getCurrentSession();

        Entity entity = (Entity) session.load(entityClass, primaryKey);

        assertNotNull(entity, entityClass, primaryKey);

        session.delete(entity);
        session.flush();
    }

    private void assertNotNull(Entity entity, Class<Entity> entityClass, PK primaryKey) {
        Assert.notNull(entity, "There is no '" + entityClass.getSimpleName() + "' with the primary key '" + primaryKey + "'");
    }
}
