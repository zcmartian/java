/**
 * Created by marszhou on 16/2/3.
 */
public abstract class Shape {
    //桥接模式在两个维度上变化,一个是抽象一个是具体,通过组合的方式将抽象引入到具体里面
    //抽象就是 DrawApi,它在自己的维度独立的变化
    //具体就是 Shape 对象及其子类,它也在自己的维度独立的变化
    //桥接模式将这两个维度解耦并桥接在一起
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
