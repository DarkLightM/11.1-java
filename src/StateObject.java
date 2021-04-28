public class StateObject {
    private int x = 0;
    private int count = 0;

    public void incX(){
        x++;
    }

    public void incCount(){
        count++;
    }

    public int getX(){
        return x;
    }

    public int getCount(){
        return count;
    }
}
