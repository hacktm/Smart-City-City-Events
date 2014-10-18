package org.smartcity.cityevents.dao.locations;

import org.smartcity.cityevents.dao.AbstractRepository;
import org.smartcity.cityevents.entities.locations.Location;

import java.util.List;

public interface LocationDAO extends AbstractRepository<Integer, Location> {

    public Location getById(Integer id);

    public Location getByName(String name);

    public List<Location> get(Integer startIndex, Integer pageSize);
}
