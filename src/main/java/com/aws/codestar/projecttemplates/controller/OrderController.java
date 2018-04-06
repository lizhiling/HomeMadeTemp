/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.entities.OrderRequest;
import com.aws.codestar.projecttemplates.repositories.OrderRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.UUID;


@RestController
@EnableWebMvc
public class OrderController {
    @Autowired
    OrderRequestRepository orderRequestRepository;

    @RequestMapping(path = "/orderRequest", method = RequestMethod.POST)
    public OrderRequest createOrderRequest(@RequestBody OrderRequest newOrderRequest) {
        OrderRequest dbOrderRequest = orderRequestRepository.saveAndFlush(newOrderRequest);
        return dbOrderRequest;
    }

    @RequestMapping(path = "/orderRequest", method = RequestMethod.GET)
    public List<OrderRequest> listOrderRequests() {
        List<OrderRequest> orderRequestList = orderRequestRepository.findAll();

        return orderRequestList;
    }

    @RequestMapping(path = "/orderRequest/{orderRequestId}", method = RequestMethod.GET)
    public OrderRequest listOrderRequest(@PathVariable UUID orderRequestId) {
        return orderRequestRepository.findOne(orderRequestId);
    }

}
