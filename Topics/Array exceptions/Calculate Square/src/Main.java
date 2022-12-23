class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        if (array!=null && index>=0 && index <=(array.length-1)){
            int answer = array[index]*array[index];
            System.out.println(answer);
        }

        else {System.out.println("Exception!");}

    }
}