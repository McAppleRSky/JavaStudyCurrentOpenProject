package edu.sgu.lab2.buffer.comps;

public abstract class CBuffer{

    protected int bufID;

    // max size of buffer
    protected int bufSize;
    protected static int bufCount = 0;

    public int getBufID() {
        return bufID;
    }

    public int getBufCount() {
        return bufCount;
    }

    public CBuffer(int count) {
        bufID   = ++bufCount;
        bufSize = count;
    }

    public abstract void generate(int count);
    public abstract void close();

}
