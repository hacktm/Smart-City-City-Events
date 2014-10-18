package org.smartcity.cityevents.dao.events;

import org.hibernate.Query;
import org.hibernate.Session;
import org.smartcity.cityevents.dao.BaseDAO;
import org.smartcity.cityevents.entities.locations.Location;
import org.smartcity.cityevents.entities.events.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class EventDAOImpl extends BaseDAO implements EventDAO {

    @Override
    public Integer save(Event event) {
        return saveEntity(event);
    }

    @Override
    public Event get(Integer primaryKey) {
        return (Event) get(Event.class, primaryKey);
    }

    @Override
    public void update(Event event) {
        updateEntity(event);
    }

    @Override
    public void delete(Integer primaryKey) {
        deleteEntity(Event.class, primaryKey);
    }

    @Override
    public Event getById(Integer id) {
        return get(id);
    }

    @Override
    public Event getByName(String name) {
        return (Event) getByProperty(Event.class, "name", name);
    }

    @Override
    public List<Event> getByLocation(String location) {
        Session session = sessionFactory.getCurrentSession();

        Query queryObject = session.getNamedQuery("Event.getByLocation");
        queryObject.setParameter("location", location);

        return (List<Event>) queryObject.list();
    }

    @Override
    public List<Event> getByLocation(Location location) {
        return getByLocation(location.getName());
    }

    @Override
    public List<Event> getByDate(String date) {
        return (List<Event>) getListByProperty(Event.class, "date", date);
    }
}
