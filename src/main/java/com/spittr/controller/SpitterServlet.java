package com.spittr.controller;

import com.spittr.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SpitterServlet", urlPatterns = "/spitters")
public class SpitterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Autowired
    private SpitterService spitterService;

    @Override
    public void init() throws ServletException{
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("spitters", spitterService.getSpitters());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/spitters.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
    /*private static final long serialVersionUID = 1L;

    private SpitterService spitterService = null;

    public void init() {
        spitterService = new SpitterService();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("spitters", spitterService.getSpitters());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/spitters.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }*/
