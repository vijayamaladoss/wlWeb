/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vj.wlweb.work;

import commonj.work.Work;
import com.vj.wlweb.dao.InsertNotesDao;
import com.vj.wlweb.model.Notes;
import java.util.logging.Logger;
/**
 *
 * @author vijay
 */
public class InsertNotesWork implements Work{
    
    private final Notes note;
    InsertNotesDao notesDao = new InsertNotesDao();
    private volatile int result = -1;
    
    private final static Logger LOGGER = Logger.getLogger(InsertNotesWork.class.getName());
    
    public InsertNotesWork(Notes note){
        this.note = note;
    }
    
    public int getResult() {
        return result;
    }

    @Override
    public void release() {
    }

    @Override
    public boolean isDaemon() {
        return false;
    }

    @Override
    public void run() {
        result =  notesDao.insertNotes(note);
        LOGGER.info("Insert Notes Task Executed");
    }

    
}
