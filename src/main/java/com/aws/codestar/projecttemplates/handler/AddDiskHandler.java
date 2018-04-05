package com.aws.codestar.projecttemplates.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.codestar.projecttemplates.GatewayResponse;
import com.aws.codestar.projecttemplates.entities.Disk;
import com.aws.codestar.projecttemplates.repositories.DiskRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Handler for requests to Lambda function.
 */
@Component
public class AddDiskHandler implements RequestHandler<Disk, Object> {
    private DiskRepository diskRepository;

    public AddDiskHandler(@Autowired DiskRepository diskRepository){
        this.diskRepository = diskRepository;
    }

    @Override
    public Object handleRequest(final Disk input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Disk resultDisk = diskRepository.saveAndFlush(input);

        return new GatewayResponse<String>(
                new JSONObject().put("Output", "Disk Added")
                        .put("name", resultDisk.getName())
                        .put("description", resultDisk.getDescription())
                        .put("materials", resultDisk.getMaterials()).toString(),
                headers,
                200);
    }
}
