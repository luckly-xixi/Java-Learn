import java.util.HashMap;

public class hashAndhashMap {


// 设计一种结构，在该结构中有以下三个功能
//insert(key):将某个key加入到该结构，做到不重复加入
//delete(key):将原来在结构中的某个key移除
//getRandom():等概率随即返回结构中的任何一个key
//以上方法时间复杂度都是O(1)
    public static class Pool<K> {
        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<K,Integer>();
            this.indexKeyMap = new HashMap<Integer,K>();
            this.size = 0;
        }

        public void insert(K key) {
            if(!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key,this.size);
                this.indexKeyMap.put(this.size++,key);
            }
        }

        public void delete(K key) {
            if(this.keyIndexMap.containsKey(key)) {
                int deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey,deleteIndex);
                this.indexKeyMap.put(deleteIndex,lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom() {
            if(this.size == 0) {
                return null;
            }
            int randomIndex = (int)(Math.random()*this.size);
            return this.indexKeyMap.get(randomIndex);
        }
    }




}
