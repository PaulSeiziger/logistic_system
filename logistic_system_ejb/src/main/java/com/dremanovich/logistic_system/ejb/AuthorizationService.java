/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dremanovich.logistic_system.ejb;

import com.dremanovich.logistic_system.api.IAuthorizationService;
import com.dremanovich.logistic_system.ejb.entities.UserEntity;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author martin
 */
@Stateless(mappedName = "authorizationService")
@LocalBean
public class AuthorizationService implements IAuthorizationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String authorize(String login, String password) {

        UserEntity user = new UserEntity();
        user.setLogin(login);
        user.setPassword(password);

        entityManager.persist(user);

        return "hashed{" + user.getId() + "}(" + login + password + ")";
    }
}
