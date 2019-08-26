import lombok.Data;
import org.springframework.util.NumberUtils;

import java.lang.management.*;
import java.util.List;

public class SystemInfos {
    public static void main(String[] args) {
        int count = 10;
        while (count > 0) {
            fetchOs( );
            fetchThreads();
            fetchGc();
            try {
                Thread.sleep(1000 * 5);
                String[] strs = new String[100];
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println("------------------------");
        }
    }

    private static void fetchOs() {
        OperatingSystemMXBean bean = ManagementFactory.getOperatingSystemMXBean();
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setArch(bean.getArch());
        systemInfo.setName(bean.getName());
        systemInfo.setVersion(bean.getVersion());
        systemInfo.setAvailableProcessors(bean.getAvailableProcessors());
        systemInfo.setLoadAverage(bean.getSystemLoadAverage());

        if (isInstanceOfInterface(bean.getClass(), "com.sun.management.OperatingSystemMXBean")) {
            com.sun.management.OperatingSystemMXBean b = (com.sun.management.OperatingSystemMXBean) bean;

            systemInfo.setTotalPhysicalMemory(b.getTotalPhysicalMemorySize());
            systemInfo.setFreePhysicalMemory(b.getFreePhysicalMemorySize());
            systemInfo.setTotalSwapSpace(b.getTotalSwapSpaceSize());
            systemInfo.setFreeSwapSpace(b.getFreeSwapSpaceSize());
            systemInfo.setProcessTime(b.getProcessCpuTime());
            systemInfo.setCommittedVirtualMemory(b.getCommittedVirtualMemorySize());
        }
        System.out.println(systemInfo);
    }

    private static void fetchThreads() {
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        ThreadsInfo threadsInfo = new ThreadsInfo();
        threadBean.setThreadContentionMonitoringEnabled(true);

        ThreadInfo[] threads;

//        threads = bean.dumpAllThreads(true, true);

        threadsInfo.setCount(threadBean.getThreadCount());
        threadsInfo.setDaemonCount(threadBean.getDaemonThreadCount());
        threadsInfo.setPeekCount(threadBean.getPeakThreadCount());
        threadsInfo.setTotalStartedCount((int) threadBean.getTotalStartedThreadCount());
        System.out.println(threadsInfo);
    }

    private static void fetchGc() {
        MemoryMXBean bean = ManagementFactory.getMemoryMXBean();
        Runtime runtime = Runtime.getRuntime();

        MemoryInfo memory = new MemoryInfo();
        memory.setMax(runtime.maxMemory());
        memory.setTotal(runtime.totalMemory());
        memory.setFree(runtime.freeMemory());
        memory.setHeapUsage(bean.getHeapMemoryUsage().getUsed());
        memory.setNonHeapUsage(bean.getNonHeapMemoryUsage().getUsed());
        memory.setHeapUsagePercent(memory.heapUsage / bean.getHeapMemoryUsage().getMax());
        memory.setNonHeapUsagePercent(memory.nonHeapUsage / bean.getNonHeapMemoryUsage().getMax());
        System.out.println(memory);

        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean mxBean : beans) {
            if (mxBean.isValid()) {
                GcInfo gc = new GcInfo();
                gc.setName(mxBean.getName());
                gc.setCount(mxBean.getCollectionCount());
                gc.setTime(mxBean.getCollectionTime());
                gc.setCollectionTime(mxBean.getCollectionTime());
                System.out.println(gc);
            }
        }
        for (MemoryPoolMXBean mpBean : ManagementFactory.getMemoryPoolMXBeans()) {
            mpBean.getCollectionUsage();
            long count = mpBean.getUsage().getUsed();
            String name = mpBean.getName();
            HeapUsage heapUsage = new HeapUsage();
            heapUsage.setCount(count);
            heapUsage.setName(name);
            heapUsage.setInit(mpBean.getUsage().getInit());
            heapUsage.setCommitted(mpBean.getUsage().getCommitted());
            heapUsage.setMax(mpBean.getUsage().getMax());
            heapUsage.setPercent((double) count / (double) heapUsage.getCommitted());
            System.out.println(heapUsage);
        }
    }

    private static boolean isInstanceOfInterface(Class<?> clazz, String interfaceName) {
        if (clazz == Object.class) {
            return false;
        } else if (clazz.getName().equals(interfaceName)) {
            return true;
        }

        Class<?>[] interfaceclasses = clazz.getInterfaces();

        for (Class<?> interfaceClass : interfaceclasses) {
            if (isInstanceOfInterface(interfaceClass, interfaceName)) {
                return true;
            }
        }

        return isInstanceOfInterface(clazz.getSuperclass(), interfaceName);
    }

    @Data
    private static class HeapUsage {
        private String name;
        private long count;
        private long init;
        private long committed;
        private long max;
        private double percent;
    }
    @Data
    private static class MemoryInfo {
        private long max;
        private long total;
        private long free;
        private long heapUsage;
        private long nonHeapUsage;
        private double heapUsagePercent;
        private double nonHeapUsagePercent;
    }

    @Data
    private static class SystemInfo {
        private String arch;
        private String name;
        private String version;
        private int availableProcessors;
        private double loadAverage;

        private long totalPhysicalMemory;
        private long freePhysicalMemory;
        private long totalSwapSpace;
        private long processTime;
        private long freeSwapSpace;
        private long committedVirtualMemory;
    }

    @Data
    private static class ThreadsInfo {
        private int count;
        private int daemonCount;
        private int peekCount;
        private long totalStartedCount;
    }

    @Data
    private static class GcInfo {
        private String name;
        private long count;
        private long time;
        private long collectionTime;
    }
}
