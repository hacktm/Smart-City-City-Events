package org.smartcity.cityevents.service.locations;

public interface LocationService {
    public String getById(Integer id);

    public String getByName(String name);

    public String get(Integer startIndex, Integer pageSize);
}
