//package kw.test.demo;
//
//
///* access modifiers changed from: package-private */
///* renamed from: com.peoplefun.wordstacks.n8 */
//public class C13632n8 extends AbstractC13900u8 {
//
//    /* renamed from: a */
//    C13238dn f36966a = null;
//
//    C13632n8() {
//    }
//
//    @Override // com.peoplefun.wordstacks.AbstractC13900u8
//    /* renamed from: b */
//    public final C13632n8 mo73971b() {
//        return this;
//    }
//
//    @Override // com.peoplefun.wordstacks.AbstractC13900u8
//    /* renamed from: g */
//    public final void mo73972g(ph0 ph0) {
//        ph0.mo71725h("[");
//        int c = this.f36966a.mo70708c();
//        int i = 0;
//        boolean z = false;
//        while (i < c) {
//            AbstractC13900u8 b = this.f36966a.mo70707b(i);
//            if (z) {
//                ph0.mo71725h(",");
//            }
//            if (b != null) {
//                b.mo73972g(ph0);
//            } else {
//                ph0.mo71725h("null");
//            }
//            i++;
//            z = true;
//        }
//        ph0.mo71725h("]");
//    }
//
//    /* renamed from: j */
//    public final C13632n8 mo73973j() {
//        super.mo75890a();
//        C13238dn dnVar = new C13238dn();
//        dnVar.mo70706a();
//        this.f36966a = dnVar;
//        return this;
//    }
//
//    /* renamed from: k */
//    public final C13632n8 mo73974k(String str) {
//        super.mo75890a();
//        if (str.length() != 0) {
//            C13826s8 s8Var = new C13826s8();
//            s8Var.mo75385a(str);
//            this.f36966a = s8Var.mo75392h();
//        } else {
//            C13238dn dnVar = new C13238dn();
//            dnVar.mo70706a();
//            this.f36966a = dnVar;
//        }
//        return this;
//    }
//
//    /* renamed from: l */
//    public final C13632n8 mo73975l(C13238dn dnVar) {
//        super.mo75890a();
//        this.f36966a = dnVar;
//        return this;
//    }
//
//    /* renamed from: m */
//    public final int mo73976m(AbstractC13900u8 u8Var) {
//        this.f36966a.mo70709d(u8Var);
//        return 0;
//    }
//
//    /* renamed from: n */
//    public final int mo73977n(int i) {
//        C13238dn dnVar = this.f36966a;
//        C13750q8 q8Var = new C13750q8();
//        q8Var.mo74888k(i);
//        dnVar.mo70709d(q8Var);
//        return 0;
//    }
//
//    /* renamed from: o */
//    public final int mo73978o(String str) {
//        C13238dn dnVar = this.f36966a;
//        C13863t8 t8Var = new C13863t8();
//        t8Var.mo75654j(str);
//        dnVar.mo70709d(t8Var);
//        return 0;
//    }
//
//    /* renamed from: p */
//    public final int mo73979p(String str) {
//        mo73980q(C13855t0.m46407f(str));
//        return 0;
//    }
//
//    /* renamed from: q */
//    public final int mo73980q(String str) {
//        if (str.length() != 0) {
//            C13826s8 s8Var = new C13826s8();
//            s8Var.mo75385a(str);
//            this.f36966a = s8Var.mo75392h();
//            return 0;
//        }
//        C13238dn dnVar = new C13238dn();
//        dnVar.mo70706a();
//        this.f36966a = dnVar;
//        return 0;
//    }
//
//    /* renamed from: r */
//    public final AbstractC13900u8 mo73981r(int i) {
//        if (i < 0 || i >= this.f36966a.mo70708c()) {
//            return C13713p8.m44992k();
//        }
//        AbstractC13900u8 b = this.f36966a.mo70707b(i);
//        if (b != null) {
//            return b;
//        }
//        return C13713p8.m44992k();
//    }
//
//    /* renamed from: s */
//    public final int mo73982s(int i, int i2) {
//        AbstractC13900u8 r = mo73981r(i);
//        return r != null ? r.mo74371e() : i2;
//    }
//
//    /* renamed from: t */
//    public final String mo73983t(int i, String str) {
//        AbstractC13900u8 r = mo73981r(i);
//        return r != null ? r.mo74372h() : str;
//    }
//
//    /* renamed from: u */
//    public final C13632n8 mo73984u(int i) {
//        AbstractC13900u8 r = mo73981r(i);
//        if (r != null) {
//            return r.mo73971b();
//        }
//        return null;
//    }
//
//    /* renamed from: v */
//    public final int mo73985v(int i, int i2) {
//        AbstractC13900u8 r = mo73981r(i);
//        return r != null ? r.mo74371e() : i2;
//    }
//
//    /* renamed from: w */
//    public final C13786r8 mo73986w(int i) {
//        AbstractC13900u8 r = mo73981r(i);
//        if (r != null) {
//            return r.mo75146f();
//        }
//        return null;
//    }
//
//    /* renamed from: x */
//    public final String mo73987x(int i, String str) {
//        AbstractC13900u8 r = mo73981r(i);
//        return r != null ? r.mo74372h() : str;
//    }
//
//    /* renamed from: y */
//    public final int mo73988y() {
//        return this.f36966a.mo70708c();
//    }
//}