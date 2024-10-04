package controllers;

import models.services.Subject;

public interface Observer {
    void update(Subject subject);
}
