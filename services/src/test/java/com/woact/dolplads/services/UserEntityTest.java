package com.woact.dolplads.services;

import com.woact.dolplads.domain.Post;
import com.woact.dolplads.domain.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Arquillian test that is creating a test.war with a h2 datasource activated, eventually the ExampleDS DS bundled
 * with Widlfy 8.1 Server.
 * <p>
 * Created by papo on 6/15/14.
 */
@Transactional(TransactionMode.ROLLBACK)
@RunWith(Arquillian.class)
public class UserEntityTest {


    @PersistenceContext(name = "test")
    private EntityManager em;

    private User theSimpleUser;

    @Before
    public void init() {
        theSimpleUser = new User();
        theSimpleUser.setUserName("thomas");
        em.persist(theSimpleUser);

    }

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")//.addAsWebInfResource("web.xml")
                .addClass(User.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testGetUser() {
        User testSimpleUser = em.find(User.class, theSimpleUser.getId());
        Assert.assertEquals("thomas", testSimpleUser.getUserName());
    }

    @Test
    public void addPostToUser() {
        System.out.println("hello");
    }

}