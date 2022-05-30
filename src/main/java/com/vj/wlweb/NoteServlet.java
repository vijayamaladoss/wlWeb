package com.vj.wlweb;

import com.vj.wlweb.model.Notes;
import com.vj.wlweb.work.InsertNotesWork;
import commonj.work.WorkException;
import commonj.work.WorkItem;
import commonj.work.WorkManager;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "notesServlet", value = "/notes-servlet")
public class NoteServlet extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(NoteServlet.class.getName());

    @Resource(name = "java:comp/env/wm/WorkManager")
    WorkManager workManager;

    public void init() {

        LOGGER.log(Level.INFO, "Notes Servlet Initialized");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        int numUpdates = -1;
        // Hello
        Notes note = new Notes("Test Weblogic Note", true);
        try {
            WorkItem workItem = workManager.schedule(new InsertNotesWork(note));
            if (workManager.waitForAll(Collections.singletonList(workItem), 1000)) {
                InsertNotesWork work = (InsertNotesWork) workItem.getResult();
                numUpdates = work.getResult();
            }
        } catch (WorkException ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Notes Servlet</h1>");
        out.println("<h2>" + numUpdates + "</h2>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
