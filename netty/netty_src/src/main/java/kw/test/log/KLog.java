package kw.test.log;

import javafx.application.Application;

import java.util.ArrayList;

public class KLog{
    private static KLog kLog;
    private static ArrayList<BaseLog> printers = new ArrayList<>();

    public static void setPrint(NettyLog log) {
        printers.add(log);
    }

    public void printer(int type,String target,String value) {
        for (BaseLog printer : printers) {
            if (type == BaseLog.DEBUG) {
                printer.debug(target, value);
            }else if (type == BaseLog.WARNING){
                printer.warning(target, value);
            }else if (type == BaseLog.ERROR){
                printer.error(target, value);
            }else if (type == BaseLog.INFO){
                printer.info(target, value);
            }
        }
    }

    public static void info(String target,String value){
        if (kLog == null){
            kLog = new KLog();
        }
        kLog.printer(BaseLog.INFO,target,value);
    }

    public static void warning(String target,String value){
        if (kLog == null){
            kLog = new KLog();
        }
        kLog.printer(BaseLog.WARNING,target,value);
    }

    public static void error(String target,String value){
        if (kLog == null){
            kLog = new KLog();
        }
        kLog.printer(BaseLog.ERROR,target,value);
    }

    public static void debug(String target,String value){
        if (kLog == null){
            kLog = new KLog();
        }
        kLog.printer(BaseLog.DEBUG,target,value);
    }
}