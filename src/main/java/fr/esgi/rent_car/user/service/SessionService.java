package fr.esgi.rent_car.user.service;

import fr.esgi.rent_car.user.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    private User user;

    public void setCurrentUser(User user) {
        this.user = user;
    }

    public User getCurrentUser()
    {
        return this.user;
    }

    private SessionService(){

    }
}
