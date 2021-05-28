package com.baaaki.posting.bindingTest.controller;

import com.baaaki.posting.bindingTest.dto.OrderDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class OrderControllerTest {

    private MockMvc mockMvc;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void before() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new OrderController())
                .build();
    }

    @Test
    @DisplayName("1.RequestBody Binding test ")
    public void requestBodyTest() throws Exception {
        ResultActions result = mockMvc.perform(
                post("/order/requestBodyTest")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                                OrderDto.builder()
                                        .orderNo(1L)
                                        .build()
                        ))
        );

        result.andDo(print());
    }

    @Test
    @DisplayName("2.ModelAttribute Binding test ")
    public void modelAttributeTest() throws Exception {
        ResultActions result = mockMvc.perform(
                post("/order/modelAttributeTest")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("orderNo", "1")
        );

        result.andDo(print());
    }

    @Test
    @DisplayName("3.RequestBody @Valid 정상 test")
    public void requestBodyValidTest() throws Exception {

        //given
        String parameter = objectMapper.writeValueAsString(
                OrderDto.builder()
                        .orderNo(1L)
                        .build());

        //when
        ResultActions result = mockMvc.perform(
                post("/order/requestBodyTest")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(parameter)
        );

        //then
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    @DisplayName("4.RequestBody @Valid 비정상 test")
    public void requestBodyValidWrongTest() throws Exception {

        //given
        String parameter = objectMapper.writeValueAsString(
                OrderDto.builder()
                        .build());

        //when
        ResultActions result = mockMvc.perform(
                post("/order/requestBodyTest")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(parameter)
        );

        //then
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").exists());
    }

    @Test
    @DisplayName("5.ModelAttribute @Valid 정상 test")
    public void modelAttributeValidTest() throws Exception {

        //given
        String name = "orderNo";
        String value = "1";

        //when
        ResultActions result = mockMvc.perform(
                post("/order/modelAttributeTest")
                        .accept(MediaType.APPLICATION_JSON)
                        .param(name, value)
        );

        //then
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    @DisplayName("6.ModelAttribute @Valid 비정상 test")
    public void modelAttributeValidWrongTest() throws Exception {

        //given
        String name = "orderNo";
        String value = "";

        //when
        ResultActions result = mockMvc.perform(
                post("/order/modelAttributeTest")
                        .accept(MediaType.APPLICATION_JSON)
                        .param(name, value)
        );

        //then
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").exists());
    }
}