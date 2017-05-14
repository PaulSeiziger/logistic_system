package com.dremanovich.logistic_system.client;

import com.dremanovich.logistic_system.api.IAuthorizationService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by PavelDremanovich on 14.05.17.
 */
public class Main {
    public static void main(String[] args) {
        try {
//            Properties props = new Properties();
//            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            Context context = new InitialContext();

            IAuthorizationService authorizationService = (IAuthorizationService) context.lookup("authorizationService");

            String hash = authorizationService.authorize("test", "passtest");
            System.out.println(hash);

        } catch (ClassCastException|NamingException e) {
            e.printStackTrace();
        }
    }
}
