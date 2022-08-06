package package3;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{

    String getBelief();
    void eat(String food);
}

// 被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I belief I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

// 动态代理类:
// 要想实现动态代理，需要解决的问题？
// 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
// 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。
class ProxyFactory{

    // 此方法创建一个代理类的对象(根据被代理类的对象动态的创建代理类对象)
    public static Object getProxyInstance(Object obj){ // obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        // 通过 Proxy.newProxyInstance和InvocationHandler动态创建了被代理类的 "代理类"，
        // 此时代理类和被代理类拥有同一套接口的方法，调用该代理类的方法的同时会调用被代理类中的同名的方法，
        // 返回值也即为被代理类方法中的返回值
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }

}

class MyInvocationHandler implements InvocationHandler{

    private Object obj; // 需要通过被代理类对象实例化

    public void bind(Object obj){
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法
    // 将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 此时该方法为代理类调用的方法。在此方法中，调用了被代理类的method方法。obj:被代理类的对象
        System.out.println("代理类经过一些初始操作~");

        Object invoke = method.invoke(obj, args);
        // 上述方法返回值为该方法返回值


        return invoke;
    }
}


public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superMan);
        // 通过代理类方法会自动调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief+"\n");
        proxyInstance.eat("虾~");

        System.out.println("-------------");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory)ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();
    }
}
