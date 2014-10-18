package org.smartcity.cityevents.presentation.locations;

import org.smartcity.cityevents.service.locations.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
public class LocationsController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(method = RequestMethod.GET, value = "/id/{userId}")
    public @ResponseBody
    String getById(@PathVariable Integer userId) {
        return locationService.getById(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
    public @ResponseBody String getByName(@PathVariable String name) {
        return locationService.getByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{startIndex}/{pageSize}")
    public @ResponseBody String get(@PathVariable Integer startIndex, @PathVariable Integer pageSize) {
        return locationService.get(startIndex, pageSize);
    }
}
