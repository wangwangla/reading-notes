package kw.test.log;

public class NettyLog implements BaseLog {

    public NettyLog(){
        KLog.setPrint(this);
    }

    @Override
    public void printer(String tag, String value) {
        System.out.println(tag+" : "+value);
    }

    @Override
    public void info(String target, String value) {
        System.out.println(target+" : "+value);
    }

    @Override
    public void warning(String target, String value) {
        System.out.println(target+" : "+value);
    }

    @Override
    public void error(String target, String value) {
        System.err.println(target +" : "+value);
    }

    @Override
    public void debug(String target, String value) {
        System.out.println(target+" : "+value);
    }
}
