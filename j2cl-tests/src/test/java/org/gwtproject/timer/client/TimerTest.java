package org.gwtproject.timer.client;

import com.google.j2cl.junit.apt.J2clTestInput;
import elemental2.promise.Promise;
import org.junit.Test;

@J2clTestInput(TimerTest.class)
public class TimerTest {

    @Test(timeout = 500)
    public Promise<Void> testTimerSchedule() {
        return new Promise<>((resolve, reject) -> {

            Timer timer =
                    new Timer() {
                        @Override
                        public void run() {
                            resolve.onInvoke((Void) null);
                        }
                    };
            timer.schedule(100);
        });
    }

    @Test(timeout = 700)
    public Promise<Void> testTimerScheduleRepeating() {
        return new Promise<>((resolve, reject) -> {

            final int[] counter = {5};
            Timer timer =
                    new Timer() {
                        @Override
                        public void run() {
                            counter[0]--;
                            if (counter[0] == 0) resolve.onInvoke((Void) null);
                        }
                    };
            timer.scheduleRepeating(100);
        });

    }

    @Test(timeout = 900)
    public Promise<Void> testTimerCancel() {
        return new Promise<>((resolve, reject) -> {

            Timer timer =
                    new Timer() {
                        @Override
                        public void run() {
                            reject.onInvoke("should not be called after cancellation");
                        }
                    };
            timer.scheduleRepeating(300);

            timer.cancel();

            new Timer() {
                @Override
                public void run() {
                    resolve.onInvoke((Void) null);
                }
            }.schedule(600);
        });

    }
}

