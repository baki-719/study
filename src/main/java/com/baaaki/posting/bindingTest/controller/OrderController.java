package com.baaaki.posting.bindingTest.controller;

import com.baaaki.posting.dto.ApiResult;
import com.baaaki.posting.bindingTest.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.baaaki.posting.dto.ApiResult.failed;
import static com.baaaki.posting.dto.ApiResult.succeed;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

    @PostMapping(path = "requestBodyTest")
    public ApiResult<String> setOrderByRequestBody(@RequestBody @Valid OrderDto orderDto, BindingResult bindingResult) {

        log.info("Request data by RequestBody: {}", orderDto.toString());

        if(bindingResult.hasErrors())
            return (ApiResult<String>) failed(bindingResult.getFieldError().getDefaultMessage());

        return succeed(orderDto.toString());
    }

    @PostMapping(path = "modelAttributeTest")
    public ApiResult<String> setOrderByModelAttribute(@ModelAttribute @Valid OrderDto orderDto, BindingResult bindingResult) {

        log.info("Request data by ModelAttribute : {}", orderDto.toString());

        if(bindingResult.hasErrors())
            return (ApiResult<String>) failed(bindingResult.getFieldError().getDefaultMessage());

        return succeed(orderDto.toString());
    }
}
