package com.spittr.controller;

import com.spittr.model.SpittleService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SpittleServlet", urlPatterns = "/spittles")

public class SpittleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private SpittleService spittleService = null;

    public void init() {
        spittleService = new SpittleService();
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("spittles", spittleService.getSpittles());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/spittles.jsp");
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