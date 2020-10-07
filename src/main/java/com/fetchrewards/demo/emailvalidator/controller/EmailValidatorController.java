package com.fetchrewards.demo.emailvalidator.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Chendi Zhang
 * @date: 10/7/20
 * @description:
 **/
@RestController
@Api(tags = "emails api", description = "")
public class EmailValidatorController {


    @GetMapping("/emails")
    @ApiOperation("get the number of unique email addresses")
    public ResponseEntity<Integer> getUniqueEmailNums(@RequestParam List<String> emailList) {

        Set<String> set = new HashSet<>();
        for (String email : emailList) {
            int i = email.indexOf('@');
            if (i == -1) {
                continue;
            }
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll("\\.", "");
            set.add(local + rest);
        }

        return new ResponseEntity<>(set.size(), HttpStatus.OK);
    }

}
