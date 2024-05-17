package com.spittr.controller;

import com.spittr.model.SpitterService;
import com.spittr.model.SpittleService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SpitterServlet", urlPatterns = "/spitters")

public class SpitterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
    }
}