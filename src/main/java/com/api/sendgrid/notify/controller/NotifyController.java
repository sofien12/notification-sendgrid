package com.api.sendgrid.notify.controller;

import com.api.sendgrid.notify.service.serviceworkflow.WorkFlow;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Notify" ,tags = {"Notify"})

@RequestMapping("notify")
public class NotifyController {

    @Autowired
    private WorkFlow workFlow ;

    @ApiOperation(value = " basic functionality for sending simple emails")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Registration Form Returned"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!!!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 500, message = "Database error!!!")})
    @PostMapping("{event}")
    public ResponseEntity<String> notify(@RequestBody List<Object> param , @PathVariable String event)  {
        try{
            workFlow.notifyCode(event , param) ;
            return new ResponseEntity<>("vérifier votre adresse email",HttpStatus.OK) ;
        }catch (Exception msg){
            return new ResponseEntity<>(msg.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR) ;
        }

    }


}
