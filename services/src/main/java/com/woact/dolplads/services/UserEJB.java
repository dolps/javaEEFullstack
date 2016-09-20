package com.woact.dolplads.services;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

import javax.ejb.Stateless;

/**
 * Created by dolplads on 20/09/16.
 */
@Stateless
public class UserEJB {
    public String sayHello() {
        return "hello";
    }
}
