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

import com.aws.codestar.projecttemplates.entities.Disk;
import com.aws.codestar.projecttemplates.repositories.DiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;


@RestController
@EnableWebMvc
public class DiskController {
    @Autowired
    DiskRepository diskRepository;

    @RequestMapping(path = "/disk", method = RequestMethod.POST)
    public Disk createDisk(@RequestBody Disk newDisk) {
        Disk dbDisk = diskRepository.saveAndFlush(newDisk);
        return dbDisk;
    }

    @RequestMapping(path = "/disk", method = RequestMethod.GET)
    public List<Disk> listDisks() {
        List<Disk> diskList = diskRepository.findAll();

        return diskList;
    }

    @RequestMapping(path = "/disk/{diskId}", method = RequestMethod.GET)
    public Disk listDisk(@PathVariable int diskId) {
        return diskRepository.findOne(diskId);
    }

}
