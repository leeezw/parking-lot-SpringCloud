package com.parking.common.utils;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class GlobalIdGenerator {

    // 雪花算法的相关配置
    private static final long EPOCH = 1580515200000L; // 起始时间戳（可以选择任意的时间）
    private static final long WORKER_ID_BITS = 5L; // 机器ID位数
    private static final long DATA_CENTER_ID_BITS = 5L; // 数据中心ID位数
    private static final long SEQUENCE_BITS = 12L; // 序列号位数
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS; // 工作ID偏移量
    private static final long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS; // 数据中心ID偏移量
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATA_CENTER_ID_BITS; // 时间戳偏移量
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS); // 序列号掩码
    private static final long WORKER_ID_MASK = ~(-1L << WORKER_ID_BITS); // 工作ID掩码
    private static final long DATA_CENTER_ID_MASK = ~(-1L << DATA_CENTER_ID_BITS); // 数据中心ID掩码

    private static long workerId = 0;
    private static long dataCenterId = 0;
    private static long lastTimestamp = -1L;
    private static AtomicLong sequence = new AtomicLong(0L);

    // 构造函数，设置机器ID和数据中心ID
    public GlobalIdGenerator(long workerId, long dataCenterId) {
        if (workerId > WORKER_ID_MASK || workerId < 0) {
            throw new IllegalArgumentException("Worker ID can't be greater than " + WORKER_ID_MASK + " or less than 0");
        }
        if (dataCenterId > DATA_CENTER_ID_MASK || dataCenterId < 0) {
            throw new IllegalArgumentException("DataCenter ID can't be greater than " + DATA_CENTER_ID_MASK + " or less than 0");
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    // 获取当前时间戳（毫秒）
    private static long timeGen() {
        return System.currentTimeMillis();
    }

    // 生成 ID
    public synchronized String generateId(IdGenerationStrategy strategy) {
        switch (strategy) {
            case SNOWFLAKE:
                return generateSnowflakeId();
            case UUID:
                return generateUUID();
            case TIMESTAMP:
                return generateTimestampId();
            default:
                throw new IllegalArgumentException("Invalid strategy");
        }
    }

    // 雪花算法生成 ID
    public static String generateSnowflakeId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new IllegalStateException("Clock moved backwards, refusing to generate id");
        }

        if (timestamp == lastTimestamp) {
            sequence.compareAndSet(0, 0);
            sequence.incrementAndGet();
            if (sequence.get() > SEQUENCE_MASK) {
                timestamp = waitForNextMillisecond(lastTimestamp);
            }
        } else {
            sequence.set(0);
        }

        lastTimestamp = timestamp;

        return String.format("%013d", (timestamp - EPOCH) << TIMESTAMP_SHIFT | (dataCenterId << DATA_CENTER_ID_SHIFT) | (workerId << WORKER_ID_SHIFT) | sequence.get());
    }

    // 等待下一毫秒
    private static long waitForNextMillisecond(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    // 生成 32 位 UUID
    private String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // 基于时间戳 + 随机数生成 ID
    private String generateTimestampId() {
        return System.currentTimeMillis() + String.valueOf((int) (Math.random() * 1000000000));
    }

    // ID 生成策略枚举
    public enum IdGenerationStrategy {
        SNOWFLAKE, UUID, TIMESTAMP
    }

    public static void main(String[] args) {
        GlobalIdGenerator idGenerator = new GlobalIdGenerator(1, 1);

        // 测试不同策略的 ID 生成
        System.out.println("Snowflake ID: " + idGenerator.generateId(IdGenerationStrategy.SNOWFLAKE));
        System.out.println("UUID ID: " + idGenerator.generateId(IdGenerationStrategy.UUID));
        System.out.println("Timestamp ID: " + idGenerator.generateId(IdGenerationStrategy.TIMESTAMP));
    }
}
