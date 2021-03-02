/**
 * Copyright (C) 2016 Robinhood Markets, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jinatonic.confetti.sample;

import android.content.res.Resources;

import com.github.jinatonic.confetti.CommonConfetti;
import com.github.jinatonic.confetti.ConfettiManager;
import com.github.jinatonic.confetti.ConfettiSource;
import com.zzt.canvasconfettisample.R;

public class FallingConfettiFromPointActivity extends AbstractActivity {

    @Override
    protected ConfettiManager generateOnce() {
        return getCommonConfetti().oneShot();
    }

    @Override
    protected ConfettiManager generateStream() {
        return getCommonConfetti().stream(3000);
    }

    @Override
    protected ConfettiManager generateInfinite() {
        return getCommonConfetti().infinite();
    }

    private CommonConfetti getCommonConfetti() {
        final int size = getResources().getDimensionPixelSize(R.dimen.default_confetti_size);
        final ConfettiSource confettiSource = new ConfettiSource(10, 1200);
        final CommonConfetti commonConfetti =
                CommonConfetti.rainingConfetti(container, confettiSource, colors);

        final Resources res = getResources();
//        final int velocitySlow = res.getDimensionPixelOffset(R.dimen.default_velocity_slow);//150
//        final int velocityNormal = res.getDimensionPixelOffset(R.dimen.default_velocity_normal);// 300
//        final int velocityFast = res.getDimensionPixelOffset(R.dimen.default_velocity_fast);// 600

        // Further configure it
        commonConfetti.getConfettiManager()
                .setVelocityX(10, 50)
                .setAccelerationX(0, 10)
                .setTargetVelocityX(0, 100)
                .setVelocityY(0, -100);

        return commonConfetti;
    }
}
