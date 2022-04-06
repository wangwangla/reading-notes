package kw.test.demo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* access modifiers changed from: package-private */
/* renamed from: com.peoplefun.wordstacks.e */
public class C13251e {

    /* renamed from: a */
    ByteBuffer f34171a;

    /* renamed from: b */
    int f34172b;

    C13251e() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo70744a() {
        return this.f34172b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo70745b(int i) {
        return this.f34171a.get(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo70746c(int i) {
        return this.f34171a.getFloat(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo70747d(int i) {
        return this.f34171a.getInt(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
//    public void mo70748e(int i, int[] iArr, int i2, int i3) {
//        if ((i3 * 4) + i > mo70744a()) {
//            i3 = (mo70744a() - i) / 4;
//        }
//        if (i2 + i3 > C13779r1.m45675e(iArr)) {
//            i3 = C13779r1.m45675e(iArr) - i2;
//        }
//        this.f34171a.position(i);
//        this.f34171a.asIntBuffer().get(iArr, 0, i3);
//    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo70749f(int i, int i2) {
        this.f34171a.put(i, (byte) i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo70750g(byte[]j) {
        System.arraycopy(j, 0, this.f34171a.array(), 0, j.length);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
//    public void mo70751h(String str, RunnableC13498k kVar) {
//        if (mo70750g(str)) {
//            kVar.mo72983f(this);
//        }
//    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo70752i(int i) {
        if (this.f34171a != null) {
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        this.f34171a = allocate;
        allocate.order(ByteOrder.nativeOrder());
        this.f34172b = i;
        return true;
    }
}
