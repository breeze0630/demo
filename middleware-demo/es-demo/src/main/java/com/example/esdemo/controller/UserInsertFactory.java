package com.example.esdemo.controller;

import java.util.concurrent.ThreadFactory;

public class UserInsertFactory implements ThreadFactory
{
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(new UserInsertThread());
    }
}
