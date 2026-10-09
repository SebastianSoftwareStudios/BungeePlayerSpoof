package com.sebastiangrupo.studios.BungeePlayerSpoof;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerCounter {
    private int fakepla = 0;
    private int rangeMin = 0;
    private int rangeMax = 1;
    public synchronized int get() {
        return fakepla;
    }
    public synchronized int getMin() { return rangeMin; }
    public synchronized int getMax() { return rangeMax; }
    public synchronized boolean add(int n) {
        long result = (long) fakepla + n;
        if (result < 0 || n < 1 || result > Integer.MAX_VALUE) {
            return false;
        }
        fakepla = (int) result;
        return true;
    }
    public synchronized boolean subtract(int n) {
        if (n < 1 || n > fakepla) {
            return false;
        }
        fakepla -= n;
        return true;
    }
    public synchronized boolean set(int n) {
        if (n < 0) {
            return false;
        }
        fakepla = n;
        return true;
    }
    public synchronized void drop() {
        fakepla = 0;
    }
    public synchronized boolean setRange(int min, int max) {
        if (min < 0 || max < min || max == Integer.MAX_VALUE) {
            return false;
        }
        rangeMin = min;
        rangeMax = max;
        return true;
    }

    public synchronized void nextChange() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if(random.nextBoolean()) {
            int amount = random.nextInt(rangeMin, rangeMax + 1);
            if(random.nextBoolean()) {
                add(amount);
            } else {
                subtract(amount);
            }
        }
    }
}
