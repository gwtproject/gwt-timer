package org.gwtproject.timer.client;

import com.google.gwt.junit.client.GWTTestCase;

public class TimerTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "org.gwtproject.timer.client.TimerTest";
    }

    public void testTimerSchedule(){
        delayTestFinish(500);
        Timer timer=new Timer() {
            @Override
            public void run() {
                finishTest();
            }
        };
        timer.schedule(100);
    }

    public void testTimerScheduleRepeating(){
        final int[] counter = {5};
        delayTestFinish(700);
        Timer timer=new Timer() {
            @Override
            public void run() {
                counter[0]--;
                if(counter[0]==0)
                    finishTest();
            }
        };
        timer.scheduleRepeating(100);
    }

    public void testTimerCancel(){

        delayTestFinish(900);
        Timer timer=new Timer() {
            @Override
            public void run() {
               fail("should not be called after cancellation");
            }
        };
        timer.scheduleRepeating(300);

        timer.cancel();

        new Timer(){
            @Override
            public void run() {
                finishTest();
            }
        }.schedule(600);
    }

}
