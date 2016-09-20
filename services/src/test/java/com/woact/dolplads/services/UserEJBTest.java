package com.woact.dolplads.services;

import com.woact.dolplads.domain.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

/**
 * Created by dolplads on 20/09/16.
 */
@RunWith(Arquillian.class)
public class UserEJBTest {
    @PersistenceContext(name = "test")
    private EntityManager entityManager;
    private User user = null;


    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "com.woact.dolplads")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        System.out.println(jar.toString(true));
        return jar;
    }

    @Before
    public void init() {
        user = new User();
        user.setUserName("thomas");
        entityManager.persist(user);
    }

    @EJB
    private UserEJB userEJB;

    @Test
    public void test() {
        Assert.assertTrue(userEJB.sayHello().equals("hello"));
    }

    @Test
    public void testGetUser() {
        User testUser = entityManager.find(User.class, user.getId());
        Assert.assertEquals("thomas", testUser.getUserName());
    }

}