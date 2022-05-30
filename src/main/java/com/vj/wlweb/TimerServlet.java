/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vj.wlweb;

import com.vj.wlweb.model.Notes;
import com.vj.wlweb.work.HelloWrlTimer;
import com.vj.wlweb.work.InsertNotesWork;
import commonj.timers.TimerManager;
import commonj.work.WorkException;
import commonj.work.WorkItem;
import commonj.work.WorkManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vijay
 */
@WebServlet(name = "timerServlet", value = "/timer-servlet")
public class TimerServlet extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(TimerServlet.class.getName());

    @Resource(name = "java:comp/env/tm/default")
    TimerManager timerManager;

    public void init() {

        LOGGER.log(Level.INFO, "Timer Servlet Initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Timer Servlet</h1>");
        timerManager.schedule (new HelloWrlTimer(), 10 * 1000, 10*1000);
        out.println("<h4>Timer scheduled!</h4>");
        out.println("</body></html>");
    }

    public void destroy() {
    }

}