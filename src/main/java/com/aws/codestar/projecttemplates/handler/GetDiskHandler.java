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
import java.util.List;
import java.util.Map;

/**
 * Handler for requests to Lambda function.
 */
@Component
public class GetDiskHandler implements RequestHandler<Object, Object> {
    @Autowired
    private DiskRepository diskRepository;

    @Override
    public Object handleRequest(final Object input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        List<Disk> resultDisks = diskRepository.findAll();

        return new GatewayResponse<List>(
                resultDisks,
                headers,
                200);
    }
}
