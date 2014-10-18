package org.smartcity.cityevents.service.locations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smartcity.cityevents.dao.locations.LocationDAO;
import org.smartcity.cityevents.entities.locations.Location;
import org.smartcity.cityevents.service.transport.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = IllegalArgumentException.class)
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationDAO locationDAO;

    @Autowired
    private JSONSerializer jsonSerializer;

    @Override
    public String getById(Integer id) {
        Location location = locationDAO.get(id);
        if (location == null) {
            throw new IllegalArgumentException("There is no location with the ID " + id);
        }

        return jsonSerializer.serialize(location);
    }

    @Override
    public String getByName(String name) {
        Location location = locationDAO.getByName(name);
        if (location == null) {
            throw new IllegalArgumentException("There is no location with the name " + name);
        }

        return jsonSerializer.serialize(location);
    }

    @Override
    public String get(Integer startIndex, Integer pageSize) {
        List<Location> locations = locationDAO.get(startIndex, pageSize);
        if (CollectionUtils.isEmpty(locations)) {
            LOGGER.info("There are no {} locations starting from {}", pageSize, startIndex);
            locations = new ArrayList<>();
        }

        return jsonSerializer.serialize(locations);
    }

}
