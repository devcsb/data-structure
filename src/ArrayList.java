public class ArrayList {
    private Object[] data; // 배열에 들어갈 데이터
    private int size; // 배열 사이즈
    private int index; // 다음 데이터를 추가할 위치를 기억하는 index

    public ArrayList() {
        this.size = 1;
        this.data = new Object[this.size];
        this.index = 0;
    }

    public void add(Object obj) {
        System.out.println("index: " + this.index + ", size: " + this.size + ", data size: " + this.data.length);
        if (this.index == this.size - 1) {
            doubling();
        }
        data[this.index] = obj;
        this.index++;
    }

    private void doubling() {
        this.size = this.size * 2;
        Object[] newData = new Object[this.size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
        System.out.println("*** index: " + this.index + ", size: " + this.size + ", data size: " + this.data.length);
    }

    public Object get(int i) throws Exception {
        if (i > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        } else if (i < 0) {
            throw new Exception("Negative Value");
        }
        return this.data[i];
    }

    public void remove(int i) throws Exception {
        if (i > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        } else if (i < 0) {
            throw new Exception("Negative Value");
        }
        System.out.println("data removed: " + this.data[i]);
        for (int x = i;  x < this.data.length - 1; x++) {
            data[x] = data[x + 1]; // 한칸씩 앞으로 당김
        }
        this.index--;
    }
}
