package package3;


interface ClothFactory{

    void produceCloth();

}

// 代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory; // 用被代理的对象实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作!");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续工作!");
    }
}

// 被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产了一批衣服~");
    }

}

public class staticProxyTest {

    public static void main(String[] args) {
        // 创建被代理的对象
        NikeClothFactory nike = new NikeClothFactory();
        // 创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }

}


