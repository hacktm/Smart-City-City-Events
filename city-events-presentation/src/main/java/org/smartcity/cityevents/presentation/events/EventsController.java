package org.smartcity.cityevents.presentation.events;

import org.smartcity.cityevents.service.events.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/event", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventsController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET, value = "/id/{userId}")
    public @ResponseBody
    String getById(@PathVariable Integer userId) {
        return eventService.getById(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/location/{location}")
    public @ResponseBody String getByUserName(@PathVariable String location) {
        return eventService.getByLocation(location);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/date/{date}")
    public @ResponseBody String getByDate(@PathVariable String date) {
        return eventService.getByDate(date);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
    public @ResponseBody String getByName(@PathVariable String name) {
        return eventService.getByName(name);
    }
}
