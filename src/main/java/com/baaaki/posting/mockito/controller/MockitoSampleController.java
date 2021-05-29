package com.baaaki.posting.mockito.controller;

import com.baaaki.posting.mockito.dto.SampleDto;
import com.baaaki.posting.mockito.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("mockito")
public class MockitoSampleController {

    private final SampleService sampleService;

    @GetMapping(path = "sampleApi")
    public String sampleApi(@RequestBody(required = false) SampleDto dto) {
        return sampleService.findSomething();
    }
}
