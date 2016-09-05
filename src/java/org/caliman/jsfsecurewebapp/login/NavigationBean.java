package org.caliman.jsfsecurewebapp.login;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class NavigationBean implements Serializable {

    protected final static Logger logger = Logger.getLogger(NavigationBean.class.getName());

    private static final long serialVersionUID = 2L;

    public String redirectToLogin() {
        return "/login.xhtml?faces-redirect=true";
    }

    public String toLogin() {
        return "/login.xhtml";
    }

    public String redirectToIndex() {
        return "/pages/index.xhtml?faces-redirect=true";
    }

    public String toIndex() {
        return "/pages/index.xhtml";
    }

}
