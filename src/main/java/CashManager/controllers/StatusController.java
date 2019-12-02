package CashManager.controllers;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    /**
     * Get the status of the API
     * @return 200 Http code
     */
    @GetMapping("/status")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "API is online"),
    })
    public ResponseEntity getStatus() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
