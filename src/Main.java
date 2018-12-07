public class Main {

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};

        longestIncSubsequenceTab(arr);
        lisEntryPoint(arr);
    }

    private static void longestIncSubsequenceTab(int[] arr) {
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

    private static void lisEntryPoint(int[] arr) {
        int overallMax = Integer.MIN_VALUE;
        int[] quesBank = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int lisEndignAtI = lisEndingAtAPoint(arr, i, quesBank);
            if (lisEndignAtI > overallMax) {
                overallMax = lisEndignAtI;
            }
        }

        System.out.println("The length of LIS is: " + overallMax);
    }

    private static int lisEndingAtAPoint(int[] arr, int point, int[] qb) {

        if (point == 0) {
            return 1;
        }

        if (qb[point] != 0) {
            return qb[point];
        }

        int lisEndingAtPt = 0;
        for (int i = 0; i < point; i++) {
            if (arr[i] < arr[point]) {
                int lengthOfLisEndingAtI = lisEndingAtAPoint(arr, i, qb);
                if (lengthOfLisEndingAtI > lisEndingAtPt) {
                    lisEndingAtPt = lengthOfLisEndingAtI;
                }
            }
        }
        lisEndingAtPt += 1;

        qb[point] = lisEndingAtPt;
        return lisEndingAtPt;
    }
}