package com.xiao.java8.function;

//import org.apache.dubbo.config.bootstrap.DubboBootstrap;
//import org.apache.dubbo.config.bootstrap.builders.RegistryBuilder;
//import org.apache.dubbo.metadata.rest.ServiceRestMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName ConsumersExample
 * @Description TODO
 * @Author lktbz
 * @Date 2020/12/4
 */
public class ConsumersExample {
    public static void main(String[] args) {
        demo01();
    }
    public  static void  demo01(){
        List<Person> listOfPerson = new ArrayList<Person>();
//        listOfPerson.add(new Person("abc", 27));
//        listOfPerson.add(new Person("mno", 26));
//        listOfPerson.add(new Person("pqr", 28));
//        listOfPerson.add(new Person("xyz", 27));
//
//        listOfPerson.forEach((person) -> {
//            System.out.println(" Person name : " + person.getName());
//            System.out.println(" Person age : " + person.getAge());
//        });
        // Second example
        /**
         * 分析此处函数式用法/场景
         * 需要传入参数，然后处理参数，不需要返回操作
         * 下面代码就是遍历person 对象
         */
        Consumer<Person> consumer = (person) -> {
            System.out.println(person.getName());
            System.out.println(person.getAge());
        };
        consumer.accept(new Person("a",18));
    }
    /**
     public DubboBootstrap registry(String id, Consumer<RegistryBuilder> consumerBuilder) {
         RegistryBuilder builder = createRegistryBuilder(id);
         consumerBuilder.accept(builder);
         return registry(builder.build());
     }


     下一个demo
     函数的梳理操作

     protected boolean processRestMethodMetadata(Method serviceMethod, Class<?> serviceType,
     Class<?> serviceInterfaceClass,
     Consumer<RestMethodMetadata> metadataToProcess) {

     if (!isRestCapableMethod(serviceMethod, serviceType, serviceInterfaceClass)) {
     return false;
     }

     String requestPath = resolveRequestPath(serviceMethod, serviceType, serviceInterfaceClass); // requestPath is required

     if (requestPath == null) {
     return false;
     }

     String requestMethod = resolveRequestMethod(serviceMethod, serviceType, serviceInterfaceClass); // requestMethod is required

     if (requestMethod == null) {
     return false;
     }

     RestMethodMetadata metadata = new RestMethodMetadata();

     MethodDefinition methodDefinition = resolveMethodDefinition(serviceMethod, serviceType, serviceInterfaceClass);
     // Set MethodDefinition
     metadata.setMethod(methodDefinition);

     // process the annotated method parameters
     processAnnotatedMethodParameters(serviceMethod, serviceType, serviceInterfaceClass, metadata);

     // process produces
     Set<String> produces = new LinkedHashSet<>();
     processProduces(serviceMethod, serviceType, serviceInterfaceClass, produces);

     // process consumes
     Set<String> consumes = new LinkedHashSet<>();
     processConsumes(serviceMethod, serviceType, serviceInterfaceClass, consumes);

     // Initialize RequestMetadata
     RequestMetadata request = metadata.getRequest();
     request.setPath(requestPath);
     request.setMethod(requestMethod);
     request.setProduces(produces);
     request.setConsumes(consumes);

     //
     postResolveRestMethodMetadata(serviceMethod, serviceType, serviceInterfaceClass, metadata);

     // Accept RestMethodMetadata
     metadataToProcess.accept(metadata);

     return true;
     }


     consumer 传参数

     if (!processRestMethodMetadata(serviceMethod, serviceType, serviceInterfaceClass, serviceRestMetadata.getMeta()::add)) {
     Method declaredServiceMethod = entry.getValue();
     processRestMethodMetadata(declaredServiceMethod, serviceType, serviceInterfaceClass,
     serviceRestMetadata.getMeta()::add);
     }
     }
     **/

}
