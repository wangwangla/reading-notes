//package kw.test.demo;
//package com.peoplefun.wordstacks;
//
///* access modifiers changed from: package-private */
///* renamed from: com.peoplefun.wordstacks.r8 */
//public class C13786r8 extends AbstractC13900u8 {
//
//    /* renamed from: a */
//    nh0 f37965a = null;
//
//    C13786r8() {
//    }
//
//    /* renamed from: A */
//    public final int mo75134A(String str, int i) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        return r != null ? r.mo74371e() : i;
//    }
//
//    /* renamed from: B */
//    public final C13786r8 mo75135B(String str) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        if (r != null) {
//            return r.mo75146f();
//        }
//        return null;
//    }
//
//    /* renamed from: C */
//    public final String mo75136C(String str, String str2) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        return r != null ? r.mo74372h() : str2;
//    }
//
//    /* renamed from: D */
//    public final boolean mo75137D() {
//        return this.f37965a.mo75063e() <= 0;
//    }
//
//    /* renamed from: E */
//    public final boolean mo75138E() {
//        return this.f37965a.mo75063e() > 0;
//    }
//
//    /* renamed from: F */
//    public final z00 mo75139F() {
//        return this.f37965a.mo75068j();
//    }
//
//    /* renamed from: G */
//    public final int mo75140G() {
//        return this.f37965a.mo75063e();
//    }
//
//    /* renamed from: H */
//    public final void mo75141H(String str, AbstractC13900u8 u8Var) {
//        this.f37965a.mo75072n(str, u8Var);
//    }
//
//    /* renamed from: I */
//    public final void mo75142I(String str, String str2) {
//        C13863t8 t8Var = new C13863t8();
//        t8Var.mo75654j(str2);
//        mo75141H(str, t8Var);
//    }
//
//    /* renamed from: J */
//    public final void mo75143J(String str, float f) {
//        C13750q8 q8Var = new C13750q8();
//        q8Var.mo74889l(f);
//        mo75141H(str, q8Var);
//    }
//
//    /* renamed from: K */
//    public final void mo75144K(String str, int i) {
//        C13750q8 q8Var = new C13750q8();
//        q8Var.mo74888k(i);
//        mo75141H(str, q8Var);
//    }
//
//    /* renamed from: L */
//    public final void mo75145L(String str, boolean z) {
//        C13675o8 o8Var = new C13675o8();
//        o8Var.mo74374j(z);
//        mo75141H(str, o8Var);
//    }
//
//    @Override // com.peoplefun.wordstacks.AbstractC13900u8
//    /* renamed from: f */
//    public final C13786r8 mo75146f() {
//        return this;
//    }
//
//    @Override // com.peoplefun.wordstacks.AbstractC13900u8
//    /* renamed from: g */
//    public final void mo73972g(ph0 ph0) {
//        ph0.mo71725h("{");
//        n30 k = this.f37965a.mo75069k();
//        boolean z = false;
//        while (k.mo73946b()) {
//            b30 c = k.mo73947c();
//            if (z) {
//                ph0.mo71725h(",");
//            }
//            ph0.mo71725h("\"" + C13779r1.m45677g(c.mo69987c(), "\"", "\\\"") + "\":");
//            if (c.mo69989e() != null) {
//                c.mo69989e().mo73972g(ph0);
//            } else {
//                ph0.mo71725h("null");
//            }
//            z = true;
//        }
//        ph0.mo71725h("}");
//    }
//
//    /* renamed from: j */
//    public final C13786r8 mo75147j() {
//        super.mo75890a();
//        nh0 nh0 = new nh0();
//        nh0.mo74118o();
//        this.f37965a = nh0;
//        return this;
//    }
//
//    /* renamed from: k */
//    public final C13786r8 mo75148k(nh0 nh0) {
//        super.mo75890a();
//        this.f37965a = nh0;
//        return this;
//    }
//
//    /* renamed from: l */
//    public final C13786r8 mo75149l(C13786r8 r8Var) {
//        super.mo75890a();
//        if (r8Var != null) {
//            mo75154q(r8Var.mo74373i());
//        } else {
//            nh0 nh0 = new nh0();
//            nh0.mo74118o();
//            this.f37965a = nh0;
//        }
//        return this;
//    }
//
//    /* renamed from: m */
//    public final C13786r8 mo75150m(String str) {
//        super.mo75890a();
//        if (str.length() != 0) {
//            C13826s8 s8Var = new C13826s8();
//            s8Var.mo75385a(str);
//            this.f37965a = s8Var.mo75395k();
//        } else {
//            nh0 nh0 = new nh0();
//            nh0.mo74118o();
//            this.f37965a = nh0;
//        }
//        return this;
//    }
//
//    /* renamed from: n */
//    public final int mo75151n() {
//        this.f37965a.mo75061b();
//        return 0;
//    }
//
//    /* renamed from: o */
//    public final boolean mo75152o(String str) {
//        return this.f37965a.mo75062d(str);
//    }
//
//    /* renamed from: p */
//    public final int mo75153p(String str) {
//        mo75154q(C13855t0.m46407f(str));
//        return 0;
//    }
//
//    /* renamed from: q */
//    public final int mo75154q(String str) {
//        if (str.length() != 0) {
//            C13826s8 s8Var = new C13826s8();
//            s8Var.mo75385a(str);
//            this.f37965a = s8Var.mo75395k();
//            return 0;
//        }
//        nh0 nh0 = new nh0();
//        nh0.mo74118o();
//        this.f37965a = nh0;
//        return 0;
//    }
//
//    /* renamed from: r */
//    public final AbstractC13900u8 mo75155r(String str, AbstractC13900u8 u8Var) {
//        AbstractC13900u8 h = this.f37965a.mo75066h(str);
//        return h != null ? h : u8Var;
//    }
//
//    /* renamed from: s */
//    public final String mo75156s(String str, String str2) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        return r != null ? r.mo74372h() : str2;
//    }
//
//    /* renamed from: t */
//    public final float mo75157t(String str, float f) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        return r != null ? r.mo74370d() : f;
//    }
//
//    /* renamed from: u */
//    public final int mo75158u(String str, int i) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        return r != null ? r.mo74371e() : i;
//    }
//
//    /* renamed from: v */
//    public final boolean mo75159v(String str, boolean z) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        return r != null ? r.mo74369c() : z;
//    }
//
//    /* renamed from: w */
//    public final C13632n8 mo75160w(String str) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        if (r != null) {
//            return r.mo73971b();
//        }
//        return null;
//    }
//
//    /* renamed from: x */
//    public final boolean mo75161x(String str, boolean z) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        return r != null ? r.mo74369c() : z;
//    }
//
//    /* renamed from: y */
//    public final int mo75162y(String str, int i) {
//        int E;
//        int E2;
//        int i2;
//        String C = mo75136C(str, "");
//        if (C.length() != 0) {
//            if (C.indexOf(",") != -1) {
//                String[] n = C13779r1.m45684n(C, ",");
//                if (C13779r1.m45675e(n) == 3) {
//                    int parseInt = Integer.parseInt(n[0].trim());
//                    E = Integer.parseInt(n[1].trim());
//                    E2 = Integer.parseInt(n[2].trim());
//                    i2 = parseInt << 16;
//                }
//            } else if (C.length() == 6 || (C.length() == 7 && C13779r1.m45681k(C, 0, 1).compareTo("#") == 0)) {
//                int b = C13348g1.m40320b(C.length() == 6, 0, 1);
//                int i3 = b + 2;
//                int E3 = oi0.m44561E(C13779r1.m45681k(C, b, i3));
//                int i4 = b + 4;
//                E = oi0.m44561E(C13779r1.m45681k(C, i3, i4));
//                E2 = oi0.m44561E(C13779r1.m45681k(C, i4, b + 6));
//                i2 = E3 << 16;
//            }
//            return E2 | i2 | (E << 8);
//        }
//        return i;
//    }
//
//    /* renamed from: z */
//    public final float mo75163z(String str, float f) {
//        AbstractC13900u8 r = mo75155r(str, null);
//        return r != null ? r.mo74370d() : f;
//    }
//}
