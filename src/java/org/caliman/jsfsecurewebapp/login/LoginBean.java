package org.caliman.jsfsecurewebapp.login;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    protected final static Logger logger = Logger.getLogger(LoginBean.class.getName());

    private String username;
    private String password;

    private boolean loggedIn;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    public void validate(String username, String password) {
        loggedIn = false;
        if (username != null && password != null && username.trim().equals("admin")
                && password.trim().equals("secret!")) {
            loggedIn = true;
            logger.log(Level.INFO,"account ok");
        }

        //logged ok stuff...
        if (this.loggedIn) {
            //TODO
        }
    }

    public String doLogin() {
        validate(username, password);
        if (loggedIn) {
            logger.log(Level.INFO,"logged!");
            return navigationBean.redirectToIndex();
        }
        FacesMessage msg = new FacesMessage("Login error: the user name or password for this app is incorrect!", "The user name or password for this app is incorrect!");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return navigationBean.toLogin();
    }

    public String doLogout() {
        loggedIn = false;
        //logout stuff..        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return navigationBean.toLogin();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

}
