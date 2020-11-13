package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {


//        System.out.println("Test");
//
//        int solutionBinaryGap = solutionBinaryGapAlgo(1041);
//        int solutionBinaryGapAlgo = solutionBinaryGap(1041);
//        System.out.println(solutionBinaryGap);
//        System.out.println(solutionBinaryGapAlgo);
//
//        int [] array = {1, 2, 3, 4, 5, 6};
//        int solutionArrayPairs = solutionArrayPairs(array);
//        System.out.println(solutionArrayPairs);
//
//        System.out.println(Arrays.toString(cyclicRotation(array, 2)));
//        System.out.println(Arrays.toString(cyclicRotationAlgo(array, 2)));
//
//        System.out.println(frogJmp(10, 20, 30));
//
//        int [] array1 = {5, 2, 4, 1, 6}; //3
//        int [] array2 = {3, 2, 1, 4, 5}; //6
//        int [] array3 = {5, 6, 4, 1, 3}; //2
//
//        System.out.println(permMissingElem(array1));
//        System.out.println(permMissingElem(array2));
//        System.out.println(permMissingElem(array3));
//
//        int [] array4 = {3, 1, 2, 4, 3, 0};
//        System.out.println(tapeEquilibrium(array4));
//
//        int [] array5 = {1, 3, 1, 4, 2, 5, 5, 4}; //6
//        System.out.println(frogRiverOne(5, array5));
//
//        int [] array6 = {3, 4, 4, 6, 1, 4, 4};
//        System.out.println(Arrays.toString(maxCounters(5, array6)));
//
//        int[] array7 = {1, 3, 6, 4, 1, 2};
//        int[] array8 = {1, 2, 3};
//        int[] array9 = {-1, -3};
//        System.out.println(missingInteger(array7));
//        System.out.println(missingInteger(array8));
//        System.out.println(missingInteger(array9));
//
//        int[] array10 = {4, 1, 3, 2, 5};
//        int[] array11 = {4, 1, 3, 5};
//        System.out.println(permCheck(array10));
//        System.out.println(permCheck(array11));
//
//        System.out.println(countDiv(6, 11, 2));
//
//        String S = "CAGCCTA";
//        int[] P = {2, 5, 0};
//        int[] Q = {4, 5, 6};
//        System.out.println(Arrays.toString(genomicRangeQueryAlgo(S, P, Q)));
//
//        System.out.println(solutionPali(9, 3));

        int[] arrayA = {5, 3, 6, 1, 3};
        System.out.println("result = " + consec(arrayA, 2));


    }

    public static int solutionBinaryGap(int N) {
        String s = Long.toBinaryString(N);


        int modifier = 0;
        if(s.endsWith("0")) {
            modifier = 1;
        }

        System.out.println(s);

        String[] split = s.split("1");

        // 110100
        int max = 0;

        for (int i = 0; i < split.length-modifier; i++) {
            int length = split[i].length();
            if(length > max) {
                max = length;
            }

        }
        return max;
    }

    public static int solutionBinaryGapAlgo(int N) {

        int finalGap = 0;
        if (N == 1) {
            return 0;
        }
        char binaryRep[] = Integer.toBinaryString(N).toCharArray();
        int tempGap = 0;
        for (int i = 0; i < binaryRep.length; i++) {
            if(binaryRep[i]=='0') {
                tempGap++;
                continue;
            } else if(binaryRep[i]=='1') {
                if(tempGap>finalGap) {
                    finalGap = tempGap;
                }
                tempGap = 0;
            }
        }

        return finalGap;
    }

    public static int solutionArrayPairs(int[] A) {
        Set<Integer> ints = new HashSet<>();
        for (int a : A) {
            if(!ints.contains(a)) {
                ints.add(a);
                System.out.println(a + " added");
            } else {
                ints.remove(a);
                System.out.println(a + " removed");
            }
        }
        System.out.println(ints);

        for (int a: ints) {
            return a;
        }

        return 0;

    }

    public static int[] cyclicRotation(int[] A, int K) {

        int arrayLength = A.length;

        if(arrayLength == 0) {
            return A;
        }

        int[] rotatedArray = new int [arrayLength];


        K = K%arrayLength;

        if(K == 0) {
            return A;
        }

        System.arraycopy(A, arrayLength-K, rotatedArray,0, K);
        System.arraycopy(A, 0, rotatedArray,K, arrayLength-K);

        return rotatedArray;

    }

    public static int[] cyclicRotationAlgo(int[] A, int K ) {
        int arrayLength = A.length;
        int [] rotatedArray = new int[arrayLength];

        for(int i = 0; i < arrayLength; i++) {
            int newSpot = (i + K) % arrayLength;
            rotatedArray[newSpot] = A[i];
        }
        return rotatedArray;
    }

    public static int frogJmp(int X, int Y, int D) {
        int distanceToJump = Y-X;
        int numberOfJumps = distanceToJump/D;
        if(distanceToJump%D != 0) {
            numberOfJumps++;
        }
        return  numberOfJumps;
    }

    public static int permMissingElem(int[] A) {
        Arrays.sort(A);
        int N = A.length + 1;
        for (int i=1; i < N; i++) {
            if (A[i-1] != i) return i;
        }
        return N;
    }

    public static int tapeEquilibrium(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int diff = Integer.MAX_VALUE;
        int sumLeft = 0;
        int sumRight = sum;

        for(int j=1; j < A.length; j++) {
            sumLeft += A[j-1];
            sumRight -= A[j-1];
            if (Math.abs(sumLeft-sumRight) < diff) {

                diff = Math.abs(sumLeft-sumRight);

            }
        }
        return diff;
    }

    public static int frogRiverOne(int X, int[] A) {

        Set<Integer> crossPoints = new HashSet<>();
        crossPoints.size();

        for (int i = 0; i < A.length; i++) {

            crossPoints.add(A[i]);

            if (crossPoints.size() == X) {
                return i;
            }
        }
        return -1;

    }

    public static int[] maxCounters(int N, int[] A) {
        int[] result = new int[N];
        int maxCounter = 0;
        for (int i=0; i < A.length ; i++) {
            if (A[i] <= N ) {
                result[A[i]-1] += 1;
                maxCounter = Math.max(maxCounter, result[A[i]-1]);
            } else if (A[i] > N) {
                for (int j=0; j < result.length; j++) {
                    result[j] = maxCounter;
                }
            }
        }
        return result;
    }

    public static int missingInteger(int[] A) {
        int result = 1;
        Set<Integer> AToSet = new HashSet<>();
        int highestNumber = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            if (A[i] > highestNumber) {
                highestNumber = A[i];
            }
            AToSet.add(A[i]);
        }
        System.out.println(AToSet.toString());
        System.out.println("highest number = " + highestNumber);
       for (int j = 1; j <= highestNumber + 1; j++ ) {
           System.out.println("j = " + j);
           if (!AToSet.contains(j)) {
               result = j;
           }
       }
        return result;
    }

    public static int permCheck(int[] A) {
        Set<Integer> checkSet = new HashSet<>();
        for (int i = 1; i <= A.length; i++) {
            checkSet.add(i);
        }

        for (int j = 0; j < A.length; j++) {
            if (!checkSet.contains(A[j])) {
                return 0;
            }
        }

        return 1;
    }

    public static int countDiv(int A, int B, int K) {
        int result = 0;

        for(int i=A; i <= B; i++) {
            if (i % K == 0) {
                result++;
            }
        }

        return result;
    }

    public static int[] genomicRangeQuery(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        char[] SToChar = S.toCharArray();
        System.out.println(Arrays.toString(SToChar));
        int[] charToInt = new int[S.length()];
        for (int i=0; i < SToChar.length; i++) {
            if (SToChar[i] == 'A') charToInt[i] = 1;
            else if (SToChar[i] == 'C') charToInt[i] = 2;
            else if (SToChar[i] == 'G') charToInt[i] = 3;
            else if (SToChar[i] == 'T') charToInt[i] = 4;
        }
        System.out.println(Arrays.toString(charToInt));

        for (int j=0; j < P.length; j++) {
            int minValue = 4;
            for (int k = charToInt[P[j]]; k < charToInt[Q[j]]; k++) {
                minValue = Math.min(charToInt[k], minValue);
            }
            result[j] = minValue;
        }

        return  result;
    }

    public static int[] genomicRangeQueryAlgo(String S, int[] P, int[] Q) {
        int[][] array = new int[S.length()][4];
        int[] result = new int[P.length];
        int length = S.length();

        for(int i = 0; i < length; i++){
            char c = S.charAt(i);
            if(c == 'A') array[i][0] = 1;
            if(c == 'C') array[i][1] = 1;
            if(c == 'G') array[i][2] = 1;
            if(c == 'T') array[i][3] = 1;
        }
        System.out.println(Arrays.deepToString(array));
        for(int i = 1; i < length; i++) {
            for(int j=0; j<4; j++){
                array[i][j] += array[i-1][j];
            }
        }

        for(int i = 0; i < P.length; i++){
            int x = P[i];
            int y = Q[i];

            for(int a = 0; a < 4; a++){
                int sub = 0;
                if(x-1 >= 0) sub = array[x-1][a];
                if(array[y][a] - sub > 0){
                    result[i] = a+1;
                    break;
                }
            }

        }

        return result;
    }

    public static String solutionPali(int N, int K) {
        // write your code in Java SE 8
        String result;
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Set<Character> usedChars = new HashSet<>();
        Set<Character> unusedChars = new HashSet<>();
        alphabet.chars().forEach(e-> unusedChars.add((char) e));

        char[] palindrome = new char[N];

        for (int i = 0; i < N; i++) {

            if( i <= Math.ceil(N/2)) {
                if (usedChars.size() < K) {
                    
                    palindrome[i] = getRandomChar(unusedChars);
                    usedChars.add(palindrome[i]);
                    unusedChars.remove(palindrome[i]);
                    System.out.println(usedChars.size());

                } else if (usedChars.size() == K) {
                    palindrome[i] = getRandomChar(usedChars);
                }
            } else {
                palindrome[i] = palindrome[N-i-1];
            }

        }
        result = String.valueOf(palindrome);
        return result;
    }

     public static int solutionminmax(int[] A, int K) {
            int result;
            int minVal;
            int maxVal;
            List<Integer> AList = new ArrayList<>(A.length);
            for (int k : A) {
                AList.add(k);
            }
            Collections.sort(AList);

            for (int i = 0; i < K; i++) {
                int size = AList.size();
                int leftDiff = Math.abs(AList.get(0) - AList.get(1));
                int rightDiff = Math.abs(AList.get(size-1) - AList.get(size-2));
                if (leftDiff > rightDiff) {
                    AList.remove(0);
                } else if (rightDiff > leftDiff) {
                    AList.remove(size-1);
                } else if (rightDiff == leftDiff) {
                    int j = 1;
                    boolean found = false;
                    int checkLeftDiff;
                    int checkRightDiff;
                    while(found) {
                        checkLeftDiff = Math.abs(AList.get(j) - AList.get(j+1));
                        checkRightDiff = Math.abs(AList.get(size-j) - AList.get(size-j-1));
                        if (checkLeftDiff > checkRightDiff || checkLeftDiff < checkRightDiff) {
                            found = true;
                        }
                        if (leftDiff > rightDiff) {
                            AList.remove(0);
                        } else if (rightDiff > leftDiff) {
                            AList.remove(size - 1);
                        }
                    }
                }
            }
            minVal = AList.get(0);
            maxVal = AList.get(AList.size()-1);
            result = Math.abs(minVal-maxVal);
            

            return result;
        }

        public static char getRandomChar( Set<Character> set) {
            Random random = new Random();
            int l = 0;
            int rand = random.nextInt(set.size());

            char ch = '0';
            
            for (Character elem : set) {
                if (l == rand)
                    ch = elem;
                l++;
            }
            return ch;

        }

        public static int consec(int[] A, int K) {
            System.out.println("START");

            int comb = A.length - K + 1;
            int minDiff = Integer.MAX_VALUE;
            int diff;
            List<Integer> resultList = new ArrayList<>(A.length-K);
            for (int i = 0; i < comb; i++) {
                List<Integer> AList = new ArrayList<>(A.length);
                for (int k : A) {
                    AList.add(k);
                }
                for (int j=i; j<i+K; j++) {
                    AList.remove(i);

                }
                Collections.sort(AList);
                diff = Math.abs(AList.get(0) - AList.get(AList.size()-1));
                if (diff < minDiff) {
                    minDiff = diff;
                    resultList = AList;
                }
            }
            int minVal = resultList.get(0);
            int maxVal = resultList.get(resultList.size()-1);
            int result = Math.abs(minVal-maxVal);

            return result;
        }


    }

