package com.xiao.java8.function;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @ClassName SuppliersExample
 * @Description 生产者
 * @Author lktbz
 * @Date 2020/12/4
 */
public class SuppliersExample {
    /**
     * Gets a result.
     *
     * @return a result
     *     T get();
     */

    public static void main(String[] args) {
//        demo01();
        demo02();
    }
    //提供对象Person 消费
    public  static void demo01(){
        Supplier<Person> supplier = () -> {
            return new Person("Ramesh", 30 );
        };
        Person p = supplier.get();
        System.out.println("Person Detail:\n" + p.getName() + ", " + p.getAge());
    }
    /**
     *
     * 阿里的提供者使用代码
     *
    private <T> T executeShared(Supplier<T> supplier) {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return supplier.get();
        } finally {
            readLock.unlock();
        }
    }
    private List<URL> getRevisionExportedURLs(String serviceName, String revision) {
        return executeShared(() -> {
            Map<String, List<URL>> revisionExportedURLsMap = getRevisionExportedURLsMap(serviceName);
            List<URL> exportedURLs = revisionExportedURLsMap.get(revision);
            // Get a copy from source in order to prevent the caller trying to change the cached data
            return exportedURLs != null ? new ArrayList<>(exportedURLs) : emptyList();
        });
    }

     */

    /**
     * public static MetadataReportService instance(Supplier<URL> metadataReportUrl) {
     *         if (metadataReportService == null) {
     *             synchronized (lock) {
     *                 if (metadataReportService == null) {
     *                   //获取对象
     *                     URL metadataReportURLTmp = metadataReportUrl.get();
     *                     if (metadataReportURLTmp == null) {
     *                         return null;
     *                     }
     *                     metadataReportService = new MetadataReportService(metadataReportURLTmp);
     *                 }
     *             }
     *         }
     *         return metadataReportService;
     *     }
     */
    /**
     *
     MetadataReportService(URL metadataReportURL) {
     if (METADATA_REPORT_KEY.equals(metadataReportURL.getProtocol())) {
     String protocol = metadataReportURL.getParameter(METADATA_REPORT_KEY, DEFAULT_DIRECTORY);
     metadataReportURL对象的创建
     metadataReportURL = URLBuilder.from(metadataReportURL)
     .setProtocol(protocol)
     .removeParameter(METADATA_REPORT_KEY)
     .build();
     }
     this.metadataReportUrl = metadataReportURL;
     metadataReport = metadataReportFactory.getMetadataReport(this.metadataReportUrl);

     }

     */
    //根据上面的例子进行修改
    public  static void  demo02(){
        Supplier<Person>ps=()->new Person("zs",20);
        transportPeson(ps);
    }
    public static void transportPeson(Supplier<Person>ps){
        if(!Objects.isNull(ps)){
            Person person = ps.get();
            System.out.println("获取传过来的对象"+person.toString());
        }
    }
}
