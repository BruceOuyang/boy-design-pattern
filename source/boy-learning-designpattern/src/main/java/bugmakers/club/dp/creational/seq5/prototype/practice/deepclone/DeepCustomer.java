package bugmakers.club.dp.creational.seq5.prototype.practice.deepclone;

import java.io.*;

/**
 * @Description: 客户类
 * @Author: Bruce
 * @Datetime: 2018/3/8 11:36
 */
public class DeepCustomer implements Serializable {

    private String name;
    private DeepAddress addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepAddress getAddr() {
        return addr;
    }

    public void setAddr(DeepAddress addr) {
        this.addr = addr;
    }

    protected DeepCustomer deepClone() throws IOException, ClassNotFoundException {

        // 将对象写入流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        // 将对象从流中取出
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (DeepCustomer) ois.readObject();
    }
}
