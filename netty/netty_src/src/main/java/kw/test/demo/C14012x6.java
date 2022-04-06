package kw.test.demo;

import java.lang.reflect.Array;

public class C14012x6 extends C13251e {
    C14012x6() {
    }
    /* renamed from: k */
    public final C14012x6 mo76736k() {
        return this;
    }

    /* renamed from: n */
    public final void mo76737n(int i, int[] iArr, int i2, int i3) {
        if (i + i3 > mo70744a()) {
            i3 = mo70744a() - i;
        }
        if (i2 + i3 > m45675e(iArr)) {
            i3 = m45675e(iArr) - i2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = mo70745b(i + i4);
        }
    }

    static int m45675e(Object obj) {
        if (obj != null) {
            return Array.getLength(obj);
        }
        return 0;
    }


    /* renamed from: o */
    public final int[] mo76738o(int i, int i2) {
        if (i + i2 > mo70744a()) {
            i2 = mo70744a() - i;
        }
        int[] iArr = new int[i2];
        mo76737n(i, iArr, 0, i2);
        return iArr;
    }

    /* renamed from: p */
    public final String mo76739p(int i, int i2, String str) {
        boolean z;
        int i3;
        if (str.compareTo("utf8") == 0) {
            int[] o = mo76738o(i, i2);
            int e = m45675e(o);
            int[] iArr = new int[e];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                z = true;
                if (i4 >= e) {
                    z = false;
                    break;
                }
                int i6 = o[i4] & 255;
                i4++;
                if ((i6 & 128) != 0) {
                    if ((i6 & 224) != 192) {
                        if (!((i6 & 240) == 224 && (i3 = i4 + 1) < e && (o[i4] & -64) == 128 && (192 & o[i3]) == 128)) {
                            break;
                        }
                        i6 = (o[i3] & 63) | ((i6 & 15) << 12) | ((o[i4] & 63) << 6);
                        i4 += 2;
                    } else if (i4 >= e || (o[i4] & -64) != 128) {
                        break;
                    } else {
                        i6 = (o[i4] & 63) | ((i6 & 31) << 6);
                        i4++;
                    }
                }
                iArr[i5] = i6;
                i5++;
            }
            if (z) {
                return m45673c(o);
            }
            if (i5 < e) {
                iArr = (int[]) m45683m(iArr, 0, i5);
            }
            return m45673c(iArr);
        } else if (str.compareTo("ascii") == 0) {
            int[] o2 = mo76738o(i, i2);
            for (int i7 = 0; i7 < m45675e(o2); i7++) {
                o2[i7] = o2[i7] & 255;
            }
            return m45673c(o2);
        } else {
//            m45672b("Invalid string encoding:" + str);
            throw null;
        }
    }


    /* renamed from: m */
    static Object m45683m(Object obj, int i, int i2) {
        if (obj == null) {
            return null;
        }
        int length = Array.getLength(obj);
        if (i < 0) {
            i += length;
            if (i < 0) {
                i = 0;
            }
        } else if (i > length) {
            i = length;
        }
        if (i2 < 0) {
            i2 += length;
        } else if (i2 > length) {
            i2 = length;
        }
        if (i2 < i) {
            i2 = i;
        }
        int i3 = i2 - i;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i3);
        if (i3 > 0) {
            System.arraycopy(obj, i, newInstance, 0, i3);
        }
        return newInstance;
    }


    public static String m45673c(int[] iArr) {
        int length = iArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) iArr[i];
        }
        return new String(cArr, 0, length);
    }


    /* renamed from: q */
    public final String mo76740q(int i, String str) {
        return mo76739p(i, mo70744a() - i, str);
    }
}
