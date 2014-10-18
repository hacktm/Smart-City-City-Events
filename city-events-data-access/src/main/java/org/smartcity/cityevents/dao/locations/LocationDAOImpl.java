package org.smartcity.cityevents.dao.locations;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.smartcity.cityevents.dao.BaseDAO;
import org.smartcity.cityevents.entities.locations.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class LocationDAOImpl extends BaseDAO implements LocationDAO {

    @Override
    public Integer save(Location location) {
        return saveEntity(location);
    }

    @Override
    public Location get(Integer primaryKey) {
        return (Location) get(Location.class, primaryKey);
    }

    @Override
    public void update(Location location) {
        updateEntity(location);
    }

    @Override
    public void delete(Integer primaryKey) {
        deleteEntity(Location.class, primaryKey);
    }

    @Override
    public Location getById(Integer id) {
        return get(id);
    }

    @Override
    public Location getByName(String name) {
        return (Location) getByProperty(Location.class, "name", name);
    }

    @Override
    public List<Location> get(Integer startIndex, Integer pageSize) {
        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(Location.class);
        criteria.setMaxResults(pageSize);
        criteria.setFirstResult(startIndex);

        return (List<Location>) criteria.list();
    }
}
