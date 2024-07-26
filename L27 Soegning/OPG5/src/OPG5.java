import java.util.ArrayList;

public class OPG5 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        String str1 = "Test";
        list.add(str1);

        for (int i = 0; i < 5; i++) {
            String str = "String";
            list.add(str);
        }

        String str2 = "Test";
        list.add(str2);

        System.out.println(findAllIndices(list, "Test"));

    }

    /* Write a method that returns all indexes of a given String in a given ArrayList<String>. */
    public static ArrayList<Integer> findAllIndices(ArrayList<String> list, String target) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.equals(target)) {
                indices.add(i);
            }
        }
        return indices;
    }

}
