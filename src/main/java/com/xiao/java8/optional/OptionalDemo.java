package com.xiao.java8.optional;

public class OptionalDemo {
    public static void main(String[] args) {
//        getGirlFriendName(new Department(new Employee(new Girl("zs"))));
//        创建Optional
//        我们可以使用静态工厂方法Optional.empty，创建一个空的Optional对象
//        Optional<Department> department = Optional.empty();
//        我们也可以使用静态工厂方法Optional.of来创建一个非空对象的Optional对象：
//        Optional<Employee> optEmployee = Optional.of(employee);
//        使用静态工厂方法Optional.ofNullable，我们可以创建一个允许null值的Optional对象：
//        Optional<Employee> optEmployee = Optional.ofNullable(employee);
//        Optional方法
//        isPresent 顾名思义，如果值存在返回true，否则返回false。如：
//        Optional<Department> opt = Optional.ofNullable(department);
//        if(opt.isPresent()){
//            System.out.println(opt.get().getEmployee());
//        }

//        get 如果Optional有值则将其返回，否则抛出NoSuchElementException。下面举个抛出NoSuchElementException的例子：
//        try {
//            Optional.empty().get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ifPresent
//        如果Optional实例有值则为其调用Consumer（函数描述符为T -> void），否则不做处理。如：
//
//        girl.ifPresent(g -> System.out.println("我有女朋友，名字是：" + g.getName()));
       /** orElse
        如果Optional实例有值则将其返回，否则返回orElse方法传入的参数。如：

        System.out.println(Optional.empty().orElse("There is no value present!"));
        程序将输出There is no value present!。

        orElseGet
        orElseGet与orElse方法类似，orElse方法将传入的字符串作为默认值，而orElseGet方法可以接受Supplier（函数描述符为() -> T）来生成默认值。如：

        System.out.println(Optional.empty().orElseGet(() -> "There is no value present!"));
        程序同样输出There is no value present!。

        orElseThrow
        如果有值则将其返回，否则抛出Supplier接口创建的异常。如：

        try {
            Optional.empty().orElseThrow(NoSuchElementException::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        代码将捕获到 java.util.NoSuchElementException: No value present 异常。

        map
        如果Optional有值，则对其执行调用Function函数描述符为（T -> R）得到返回值。如果返回值不为null，则创建包含Function回值的Optional作为map方法返回值，否则返回空Optional。

        Optional<String> upperName = name.map(String::toUpperCase);
        System.out.println(upperName.orElse("No value found"));
        flatMap
        如果有值，为其执行Function函数返回Optional类型返回值，否则返回空Optional。flatMap与map方法类似，区别在于flatMap中的Function函数返回值必须是Optional。调用结束时，flatMap不会对结果用Optional封装。如：

        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));
        filter
        filter个方法通过传入Predicate（函数描述符为T -> Boolean）对Optional实例的值进行过滤。如：

        Optional<String> name = Optional.of("Jane");
        Optional<String> LongName = name.filter((value) -> value.length() >= 3);
        System.out.println(LongName.orElse("名字长度小于3个字符"));
        方法输出Jane。
        */


    }

    static String getGirlFriendName(Department department) {
        if (department != null) {
            Employee employee = department.getEmployee();
            if (employee != null) {
                Girl girl = employee.getGirlFriend();
                if (girl != null) {
                    return girl.getName();
                }
                return "单身汪";
            }
            return "没有员工";
        }
        return "部门为空";
    }
//    static String getGirlFriendName2(Department department) {
//        Optional<Department> opt = Optional.ofNullable(department);
//        return opt.map(Department::getEmployee)
//                .map(Employee::getGirlFriend)
//                .map(Girl::getName)
//                .orElseThrow(NoSuchElementException::new);
//    }
}
