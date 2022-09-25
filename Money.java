package machine;

class Money {
    private int wallet;

    Money() {
        this.wallet = 550;
    }

    int getWallet() {
        return wallet;
    }

    void setWallet(int wallet) {
        this.wallet = wallet;
    }

    String getUnitInfo() {
        return " of money";
    }
}
