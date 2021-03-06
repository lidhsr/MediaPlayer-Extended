/*
 * Copyright (c) 2014 Mario Guggenberger <mg@protyposis.net>
 *
 * This file is part of MediaPlayer-Extended.
 *
 * MediaPlayer-Extended is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MediaPlayer-Extended is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MediaPlayer-Extended.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.protyposis.android.mediaplayer.effects;

/**
 * Created by maguggen on 21.08.2014.
 */
public class FloatParameter extends Parameter {

    public interface Delegate {
        void setValue(float value);
    }

    private float mMin;
    private float mMax;
    private float mDefault;
    private float mValue;
    private Delegate mDelegate;

    public FloatParameter(String name, float min, float max, float init, Delegate delegate) {
        super(name, Type.FLOAT);
        mMin = min;
        mMax = max;
        mDefault = init;
        mValue = init;
        mDelegate = delegate;
    }

    public float getValue() {
        return mValue;
    }

    public void setValue(float value) {
        mValue = value;
        setDelegateValue();
    }

    public float getMin() {
        return mMin;
    }

    public float getMax() {
        return mMax;
    }

    public float getDefault() {
        return mDefault;
    }

    @Override
    public void reset() {
        mValue = mDefault;
        setDelegateValue();
    }

    private void setDelegateValue() {
        mDelegate.setValue(mValue);
        fireParameterChanged();
    }
}
