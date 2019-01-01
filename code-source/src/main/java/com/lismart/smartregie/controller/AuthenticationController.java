package com.lismart.smartregie.controller;

import org.omnifaces.util.Messages;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class AuthenticationController implements Serializable {

    private boolean errorParam;

    public boolean isErrorParam() {
        return errorParam;
    }

    public void setErrorParam(boolean errorParam) {
        this.errorParam = errorParam;
    }

    public void onLoad() {
        if (errorParam) {
            Messages.create("authentication.errorTitle")
                    .detail("authentication.errorDetail")
                    .flash().error().add();
        }
    }
}
