/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vj.wlweb;

import com.vj.wlweb.work.HelloWrlWork;
import com.vj.wlweb.service.DBVersionService;
import commonj.work.WorkException;
import commonj.work.WorkManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author vijay
 */
public class HelloWrlServlet extends HttpServlet {
    
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String version = DBVersionService.getMySQLVersion();
        System.out.println("Version ==> " + version);

        try {
            InitialContext ic = new InitialContext();
            WorkManager wm = (WorkManager) ic.lookup("java:comp/env/wm/WorkManager");
            System.out.println("## got Java EE work manager !!!!");
            wm.schedule(new HelloWrlWork());
            
        }
        catch (Exception ne) {
            ne.printStackTrace();
        }
        out.println("<h1>Hello World Work Manager!</h1>");
    }
}
