package com.ebay.calculator.controller;

import com.ebay.calculator.entity.ChainRequest;
import com.ebay.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calService;

    /**
     * handle one operation get request
     * @param op
     * @param num1
     * @param num2
     * @return
     * @throws Exception
     */
    @GetMapping("/cal")
    public ResponseEntity<?> cal(@RequestParam(value = "op") String op, @RequestParam(value = "num1") double num1, @RequestParam(value = "num2") double num2) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(calService.cal(op, num1, num2));
    }

    /**
     * handle a chain operation post request
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/chain")
    public ResponseEntity<?> chain(@RequestBody ChainRequest request) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(calService.chain(request));
    }
}
