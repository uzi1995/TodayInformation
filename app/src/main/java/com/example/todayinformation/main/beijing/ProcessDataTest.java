package com.example.todayinformation.main.beijing;


public class ProcessDataTest {

    private static ProcessDataTest mInstance;

    private String processDec;

    private ProcessDataTest() {
//        Log.e("ShanghaiDetailActivity","pid = " + android.os.Process.myPid());
    }

    public static synchronized ProcessDataTest getIntance() {
        if (mInstance == null) {
            mInstance = new ProcessDataTest();
        }
        return mInstance;
    }

    public String getProcessDec() {
        return processDec;
    }

    public ProcessDataTest setProcessDec(String processDec) {
        this.processDec = processDec;
        return this;
    }
}
