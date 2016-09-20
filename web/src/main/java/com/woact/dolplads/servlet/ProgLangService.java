package com.woact.dolplads.servlet;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by dolplads on 20/09/16.
 */
@Stateless
public class ProgLangService {
    private List<ProgLang> allLangs;

    public List<ProgLang> getAllLangs() {
        return allLangs;
    }
}
