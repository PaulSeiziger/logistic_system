package com.dremanovich.logistic_system.api;


import javax.ejb.Remote;

/**
 * Created by PavelDremanovich on 13.05.17.
 */
@Remote
public interface IAuthorizationService {
    String authorize(String login, String password);
}
