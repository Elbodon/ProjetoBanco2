package br.com.ifpb.cantinaonline.control;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class InicioListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }
}
