/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vj.wlweb.work;

import com.vj.wlweb.NoteServlet;
import commonj.work.Work;
import java.util.logging.Logger;


/**
 *
 * @author vijay
 */
public class HelloWrlWork implements Work{

    private final static Logger LOGGER = Logger.getLogger(HelloWrlWork.class.getName());
    
    @Override
    public void release() {
    }

    @Override
    public boolean isDaemon() {
        return false;
    }

    @Override
    public void run() {
        LOGGER.info("*********Work Executed***********");
        // Your business logic goes here
    }
    
}
