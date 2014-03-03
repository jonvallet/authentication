package com.jonvallet.authentication;

/**
 * Created by jvalletw on 3/03/14.
 */
public interface Persister {
    public void persistUsers(Users users);

    public Users loadUsers();
}
