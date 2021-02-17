package com.controller;

import com.LogProxy.Proxy;
import com.dto.User;
import com.service.UserInterface;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {
    private Proxy proxy;
    private UserInterface userInterface;

    public UserController(Proxy proxy, UserInterface userInterface) {
        this.proxy = proxy;
        this.userInterface = userInterface;
    }

    @GetMapping("v1/information-user/{id}")
    public User getInformation(@RequestHeader Map<String, String> headers, @PathVariable Long id){
        saveHeaderInLog(headers);
        return userInterface.getUser(id);
    }

    private void saveHeaderInLog(Map<String, String> headers) {
        StringBuilder headerString = new StringBuilder();
        headerString.append(headers.get("content-type")).append("+").append(headers.get("user-agent")).append("+").append(headers.get("accept")).append("+").
                append(headers.get("host")).append("+").append(headers.get("accept-encoding")).append("+").append(headers.get("connection"));
        proxy.registryLog(headerString.toString());
    }
}
