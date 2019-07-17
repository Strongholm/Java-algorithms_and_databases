public class MyLinearProbingHashMap<Key, Value> {
    private int M = 97;
    private int size = 0;
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];

    private Object[] tmpKeys;
    private Object[] tmpValues;

    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (((Key)keys[i]).equals(key)) {
                return (Value) values[i];
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        int i;
        for (i = hash(key); keys != null; i = (i + 1) % M) {
            if(keys[i] == null){
                break;
            }else if (((Key)keys[i]).equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
        if(size == M){
            resize(M * 2);
        }
    }

    private void resize(int newSize){
        if((newSize % M) == 0){
            newSize += 1;
        }

        tmpKeys = keys;
        tmpValues = values;

        keys = new Object[newSize];
        values = new Object[newSize];

        for(int i = 0; i< M; i++){
            if((Key) tmpKeys[i] != null) {
                putV((Key) tmpKeys[i], getV((Key) tmpKeys[i]));
            }
        }

        M = newSize;
        tmpKeys = null;
        tmpValues = null;
    }

    private Value getV(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        for (int i = hash(key); tmpKeys[i] != null; i = (i + 1) % M) {
            if (((Key)tmpKeys[i]).equals(key)) {
                return (Value) tmpValues[i];
            }
        }
        return null;
    }

    public void putV(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        int i;
        for (i = hash(key); keys != null; i = (i + 1) % M) {

            if(keys[i] == null){
                break;
            }else if (((Key)keys[i]).equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
    }
}