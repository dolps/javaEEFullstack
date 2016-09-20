package com.woact.dolplads.services;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import static org.junit.Assert.*;

/**
 * Created by dolplads on 20/09/16.
 */
@RunWith(Arquillian.class)
public class UserEJBTest {
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "com.woact.dolplads")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        System.out.println(jar.toString(true));
        return jar;
    }

    @EJB
    private UserEJB userEJB;

    @Test
    public void test() {
        Assert.assertTrue(userEJB.sayHello().equals("hello"));
    }

}