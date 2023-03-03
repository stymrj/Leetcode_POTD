class Solution {

    public static int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);

    }

    public static void main(String[] args) {

        String haystack = "sadbutsad";

        String needle = "sad";

        int index = strStr(haystack, needle);

        System.out.println(index);

    }

}
