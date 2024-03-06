import java.util.Arrays;

public class OPG1 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int[] evens = {1, 2, 3, 4, 5};

        int[] a = new int[10];
        System.out.print("a.    ");
        System.out.println(Arrays.toString(a));

        int[] b = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};
        System.out.print("b.    ");
        System.out.println(Arrays.toString(b));

        int[] c = new int[10];
        for (int i = 1; i < c.length; i++) {
            c[i] = i;
        }
        System.out.print("c.    ");
        System.out.println(Arrays.toString(c));

        int[] d = new int[10];
        for (int i = 0; i < d.length; i++) {
            d[i] = (i + 1) * 2;
        }
        System.out.print("d.    ");
        System.out.println(Arrays.toString(d));

        int[] e = new int[10];
        for (int i = 0; i < e.length; i++) {
            e[i] = (i + 1) * (i + 1);
        }
        System.out.print("e.    ");
        System.out.println(Arrays.toString(e));

        int[] f = new int[10];
        for (int i = 0; i < f.length; i++) {
            f[i] = i % 2;
        }
        System.out.print("f.    ");
        System.out.println(Arrays.toString(f));

        int[] g = new int[10];
        for (int i = 0; i < g.length; i++) {
            g[i] = i % 5;
        }
        System.out.print("g.    ");
        System.out.println(Arrays.toString(g));

        int[] h = new int[10];
        for (int i = 0; i < h.length; i++) {
            if (i % 2 == 0) {
                h[i] = i * 2;
            } else h[i] = i * 2 + 1;
        }
        System.out.print("h.    ");
        System.out.println(Arrays.toString(h));
    }
}
