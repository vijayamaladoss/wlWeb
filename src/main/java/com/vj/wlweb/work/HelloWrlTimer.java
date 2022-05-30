/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vj.wlweb.work;

import commonj.timers.Timer;
import commonj.timers.TimerListener;
import java.util.logging.Logger;

/**
 *
 * @author vijay
 */
public class HelloWrlTimer implements TimerListener{

    private final static Logger LOGGER = Logger.getLogger(HelloWrlTimer.class.getName());
    
    @Override
    public void timerExpired(Timer timer) {
        LOGGER.info("Hello work Timer invoked ");
        //Business logic goes here..
        //Work executed

    }
    
}
