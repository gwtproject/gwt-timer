/*
 * Copyright © 2019 The GWT Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtproject.timer.client;

import com.google.gwt.junit.client.GWTTestCase;

public class TimerGwtTest extends GWTTestCase {
  @Override
  public String getModuleName() {
    return "org.gwtproject.timer.TimerGwt2Test";
  }

  public void testTimerSchedule() {
    delayTestFinish(500);
    Timer timer =
        new Timer() {
          @Override
          public void run() {
            finishTest();
          }
        };
    timer.schedule(100);
  }

  public void testTimerScheduleRepeating() {
    final int[] counter = {5};
    delayTestFinish(700);
    Timer timer =
        new Timer() {
          @Override
          public void run() {
            counter[0]--;
            if (counter[0] == 0) finishTest();
          }
        };
    timer.scheduleRepeating(100);
  }

  public void testTimerCancel() {

    delayTestFinish(900);
    Timer timer =
        new Timer() {
          @Override
          public void run() {
            fail("should not be called after cancellation");
          }
        };
    timer.scheduleRepeating(300);

    timer.cancel();

    new Timer() {
      @Override
      public void run() {
        finishTest();
      }
    }.schedule(600);
  }
}
