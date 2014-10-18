package org.smartcity.cityevents.presentation.accounts;

import org.smartcity.cityevents.service.accounts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/id/{userId}")
    public @ResponseBody String getById(@PathVariable Integer userId) {
        return userService.getById(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/username/{userName}")
    public @ResponseBody String getByUserName(@PathVariable String userName) {
        return userService.getByUserName(userName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/email/{email:.+}")
    public @ResponseBody String getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }
}
