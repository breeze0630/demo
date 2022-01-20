package com.example.service;

import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;

public class MyGenericService implements GenericService {

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        if ("get".equals(method)) {
            return "Welcome " + args[0];
        }
        return null;
    }
}
