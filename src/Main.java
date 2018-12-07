public class Main {

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};

        longestIncSubsequenceTab(arr);
    }

    public static void longestIncSubsequenceTab(int[] arr) {
        int[] lis = new int[arr.length];
        String[] pathLIS = new String[arr.length];

        lis[0] = 1;
        pathLIS[0] = "" + arr[0];

        int maxLength = Integer.MIN_VALUE;
        String longestSubs = "";

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                // only those elements may participate that are smaller than this element
                if (arr[j] < arr[i]) { // are you valid ?
                    if (lis[j] > lis[i]) {  // are you longer ?
                        lis[i] = lis[j]; // if yes, update myself, with your values
                        pathLIS[i] = pathLIS[j]; // and my path
                    }
                }
            }

            // the inner loop finds the largest subsequence BEFORE i, so now we add 1 to its length and current val to path
            lis[i] = lis[i] + 1;
            pathLIS[i] = pathLIS[i] + " " + arr[i];

            if (lis[i] > maxLength) {
                maxLength = lis[i];
                longestSubs = pathLIS[i];
            }
        }

        System.out.println("Length of Longest Increasing Subsequence is: " + maxLength);
        System.out.println("The required Subsequence is: " + longestSubs);
    }

    public static void lisEntryPoint(int[] arr) {

    }

    public static int lisEndingAtAPoint(int[] arr, int point) {
        return 0;
    }
}