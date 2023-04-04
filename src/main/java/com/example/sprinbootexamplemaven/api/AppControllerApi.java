package com.example.sprinbootexamplemaven.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/data")
public interface AppControllerApi {

    @Operation(description = "Get a list of strings")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "return list of strings for id and pagination params",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = String.class)
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "empty list found for given parameter",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "no resources found for given id",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<List<String>> getData(@PathVariable String id, @RequestParam Integer skip, @RequestParam Integer top);
}
