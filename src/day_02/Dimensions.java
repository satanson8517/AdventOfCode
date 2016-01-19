package day_02;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 15/12/2015
 */
class Dimensions {

    private final int[] dims = new int[3];
    private final int wrapper;
    private final int ribbon;

    Dimensions(String[] dimensions) {
        for (int i = 0; i < this.dims.length; i++) {
            this.dims[i] = Integer.parseInt(dimensions[i]);
        }
        orderNumbers();
        wrapper = 2 * dims[0] * dims[1]
                + 2 * dims[1] * dims[2]
                + 2 * dims[0] * dims[2]
                + dims[1] * dims[2];
        ribbon = 2 * dims[1] + 2 * dims[2] + dims[0] * dims[1] * dims[2];
    }

    int getWrapper() {
        return wrapper;
    }

    int getRibbon() {
        return ribbon;
    }
    
    private void orderNumbers() {
        for (int i = 0; i < dims.length - 1; i++) {
            for (int j = 0; j < dims.length - i - 1; j++) {
                if (dims[j] < dims[j + 1]) {
                    int tmp = dims[j];
                    dims[j] = dims[j + 1];
                    dims[j + 1] = tmp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Dimensions{" + "result=" + wrapper + '}';
    }
}
