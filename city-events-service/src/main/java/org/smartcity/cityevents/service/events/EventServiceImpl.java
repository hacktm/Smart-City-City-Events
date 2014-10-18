package org.smartcity.cityevents.service.events;

import org.smartcity.cityevents.dao.events.EventDAO;
import org.smartcity.cityevents.entities.events.Event;
import org.smartcity.cityevents.service.transport.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = IllegalArgumentException.class)
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private JSONSerializer jsonSerializer;

    @Override
    public String getById(Integer id) {
        Event event = eventDAO.get(id);
        if (event == null) {
            throw new IllegalArgumentException("There is no event with the ID " + id);
        }

        return jsonSerializer.serialize(event);
    }

    @Override
    public String getByName(String name) {
        List<Event> events = eventDAO.getByLocation(name);
        if (CollectionUtils.isEmpty(events)) {
            throw new IllegalArgumentException("There are no events with the name '" + name + "'");
        }

        return jsonSerializer.serialize(events);
    }

    @Override
    public String getByLocation(String location) {
        List<Event> events = eventDAO.getByLocation(location);
        if (CollectionUtils.isEmpty(events)) {
            throw new IllegalArgumentException("There are no events with the location '" + location + "'");
        }

        return jsonSerializer.serialize(events);
    }

    @Override
    public String getByDate(String date) {
        List<Event> events = eventDAO.getByDate(date);

        if (CollectionUtils.isEmpty(events)) {
            throw new IllegalArgumentException("There are no events on the date '" + date + "'");
        }

        return jsonSerializer.serialize(events);
    }
}
