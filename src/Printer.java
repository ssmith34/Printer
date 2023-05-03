public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel < -1 || tonerLevel > 100) {
            this.tonerLevel = -1;
        } else {
            this.tonerLevel = tonerLevel;
        }
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            return (tonerAmount + tonerLevel > 100) ? -1 : (tonerLevel += tonerAmount);
        }
        return -1;
    }

    public int printPages (int pages) {
        int pagesToPrint = pages;

        if (duplex) {
            if (pages % 2 == 0) {
                pagesToPrint = pages / 2;
            }
            else {
                pagesToPrint = pages / 2 + 1;
            }
            pagesPrinted += pagesToPrint;
        }
        else {
            pagesPrinted += pagesToPrint;
        }
        return pagesToPrint;
    }

    public int getPagesPrinted () {
        return pagesPrinted;
    }
}