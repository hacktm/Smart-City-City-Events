package org.smartcity.cityevents.dao.events;

import org.smartcity.cityevents.dao.AbstractRepository;
import org.smartcity.cityevents.entities.locations.Location;
import org.smartcity.cityevents.entities.events.Event;

import java.util.List;

public interface EventDAO extends AbstractRepository<Integer, Event> {

    public Event getById(Integer id);

    public Event getByName(String name);

    public List<Event> getByLocation(String location);

    public List<Event> getByLocation(Location location);

    public List<Event> getByDate(String date);
}
