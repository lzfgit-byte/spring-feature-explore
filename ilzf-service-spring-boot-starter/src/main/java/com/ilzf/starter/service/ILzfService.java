package com.ilzf.starter.service;

public class ILzfService {

    private String name;

    public ILzfService(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("starter service say");
    }

    public void sayProp() {
        System.out.println("starter service say" + this.name);
    }

    public String getName() {
        return this.name;
    }
}
