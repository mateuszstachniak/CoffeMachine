package machine;

class ProgressBar {
    static void progressPercentage(int remain, int total) {
        if (remain > total) {
            throw new IllegalArgumentException();
        }
        int maxBareSize = 20;
        int remainPercent = ((400 * remain) / total) / maxBareSize;
        char defaultChar = '-';
        String icon = "*";
        String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
        String bareDone = "[" +
                icon.repeat(Math.max(0, remainPercent));
        String bareRemain = bare.substring(remainPercent);
        System.out.print("\r" + bareDone + bareRemain + " " + remainPercent * 5 + "%");
        if (remain == total) {
            System.out.print("\n");
        }
    }
}
