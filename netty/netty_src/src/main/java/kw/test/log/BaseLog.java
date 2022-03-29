package kw.test.log;

public interface BaseLog {
    int INFO = 1;
    int WARNING = 2;
    int ERROR = 3;
    int DEBUG = 4;


    void printer(String tag,String value);
    void info(String target,String value);
    void warning(String target,String value);
    void error(String target,String value);
    void debug(String target,String value);
}
