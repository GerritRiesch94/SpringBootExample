package com.example.sprinbootexamplemaven.api;

import com.example.sprinbootexamplemaven.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController implements AppControllerApi {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    public ResponseEntity<List<String>> getData(@PathVariable String id, @RequestParam Integer skip, @RequestParam Integer top) {
        // should represent a database service, api call, etc.
        var data = this.appService.searchForIdAndPaginate(id, skip, top);

        if (!data.isEmpty()) {
            return ResponseEntity.ok(data);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}