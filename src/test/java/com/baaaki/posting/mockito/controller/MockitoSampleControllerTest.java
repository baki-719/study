package com.baaaki.posting.mockito.controller;

import com.baaaki.posting.mockito.dto.SampleDto;
import com.baaaki.posting.mockito.service.SampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MockitoSampleControllerTest {

    MockitoSampleController mockitoSampleController;

    @Mock SampleService sampleService;

    @BeforeEach
    void setUp() {
        mockitoSampleController = new MockitoSampleController(sampleService);
    }

    @Test
    void givenTest() {
        //given
        SampleDto givenDto = SampleDto.builder()
                .no(1L)
                .name("baaaki")
                .build();

        given(sampleService.findSomething()).willReturn("Mock method called");

        //when
        String result = mockitoSampleController.sampleApi(givenDto);

        //then
        assertEquals("Mock method called", result);
    }
}