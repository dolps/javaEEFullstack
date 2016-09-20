package com.woact.dolplads.servlet;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * This is just a sample - demo, do not use in production!
 * Created by papo on 2/15/15.
 */
@ManagedBean(name="prolangtableview")
@ViewScoped
public class ProgLangTableBean{

    @EJB
    private ProgLangService langService;


    public List<ProgLang> getLangs() {
        return langService.getAllLangs();
    }

}