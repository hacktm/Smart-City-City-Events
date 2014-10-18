package org.smartcity.cityevents.service.events;

public interface EventService {
    public String getById(Integer id);

    public String getByName(String name);

    public String getByLocation(String location);

    public String getByDate(String date);
}
